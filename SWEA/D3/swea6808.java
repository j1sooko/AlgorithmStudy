import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea6808 {
	static int winCnt, loseCnt;
	static int[] card1;
	
	static void judge(int[] card2) {
		int s1 = 0, s2 = 0;
		for (int i = 0; i < card1.length; i++) {
			if (card1[i] > card2[i])
				s1 += card1[i] + card2[i];
			else
				s2 += card1[i] + card2[i];
		}
		
		if (s1 > s2)
			winCnt++;
		else if (s1 < s2)
			loseCnt++;
	}

	static void pick(int[] item, int[] bucket, int k) { // bucket: 카드의 인덱스를 뽑는 배열, k: 뽑아야하는 카드 수
		int lastIndex = bucket.length - k - 1; // bucket에 뽑은 마지막 index
		int smallest = 0; // 만약 조합일 경우 작은 것부터 뽑게함(bucket[lastIndex] + 1 : 전에 뽑은 것보다 큰 수

		if (k == 0) { // 모든 카드를 뽑음
			int[] card2 = new int[9];
			for (int i = 0; i < card2.length; i++)
				card2[i] = item[bucket[i]];
			judge(card2);
			return;
		}

		for (int i = smallest; i < item.length; i++) {
			boolean chosen = false;
			for (int j = 0; j <= lastIndex; j++) // 이전에 그 카드를 뽑은 적이 있음
				if (bucket[j] == i) {
					chosen = true;
					break;
				}

			if (!chosen) { // 이전에 뽑은 적이 카드일 경우 뽑는다
				bucket[lastIndex + 1] = i;
				pick(item, bucket, k - 1);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			winCnt = 0;
			loseCnt = 0;
			
			// 규영의 카드 입력 받기
			String[] input = br.readLine().split(" ");
			card1 = new int[9];
			for (int i = 0; i < card1.length; i++)
				card1[i] = Integer.parseInt(input[i]);
			
			
			// 인영의 카드 배열 만들기
			int[] item = new int[9];
			int i = 0;
			for (int n = 1; n <= 18; n++) {
				boolean chosen = false;
				for (int j = 0; j < card1.length; j++)
					if (card1[j] == n) {
 						chosen = true;
 						break;
					}
				if (!chosen)
					item[i++] = n;
			}

			// 카드를 내는 경우의수 -> 순열
			int[] bucket = new int[9];
			pick(item, bucket, 9);

			sb.append("#" + test_case + " " + winCnt + " " + loseCnt + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
