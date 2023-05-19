import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea6808 {
	static int winCnt, loseCnt;
	static int[] card1, card2, item;

	static void pick(boolean[] isSelected, int k) { // isSelected: 인덱스에 해당하는 카드를 뽑았는지의 여부, k: 뽑은 카드수
		int smallest = 0; // 만약 조합일 경우 작은 것부터 뽑게함(bucket[lastIndex] + 1 : 전에 뽑은 것보다 큰 수

		if (k == 9) { // 모든 카드를 뽑음
			int s1 = 0, s2 = 0;
			for (int i = 0; i < card1.length; i++) {
				if (card1[i] > card2[i])
					s1 += card1[i] + card2[i];
				else if (card1[i] < card2[i])
					s2 += card1[i] + card2[i];
			}
			
			if (s1 > s2)
				winCnt++;
			else if (s1 < s2)
				loseCnt++;
			return;
		}

		for (int i = smallest; i < 9; i++)
			if (!isSelected[i]) {
				card2[k] = item[i];
				isSelected[i] = true;
				pick(isSelected, k + 1);
				isSelected[i] = false; // 다른 경우의 수에서 다시 뽑을 수 있도록
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
			card1 = new int[9]; //규영이 낸 카드
			card2 = new int[9]; //인영이 낼 카드
			item = new int[9]; //인영이 가지고 있는 카드
			
			// 규영의 카드 입력 받기
			String[] input = br.readLine().split(" ");
			boolean[] used = new boolean[19];
			for (int i = 0; i < card1.length; i++) {
				card1[i] = Integer.parseInt(input[i]);
				used[card1[i]] = true;
			}
			
			
			// 인영의 가지고 있는 카드 배열 만들기
			int i = 0;
			for (int n = 1; n <= 18; n++)
				if (!used[n])
					item[i++] = n;

			// 카드를 내는 경우의수 -> 순열
			boolean[] isSelected = new boolean[9];
			pick(isSelected, 0);

			sb.append("#" + test_case + " " + winCnt + " " + loseCnt + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
