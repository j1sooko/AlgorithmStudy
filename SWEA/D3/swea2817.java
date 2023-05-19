import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea2817 {
	static int N, K;
	static int[] seq;
	static boolean[] isSelected;
	static int cnt;

	static void solve(int index, int sum) { // index : 현재 뽑으려는 수를 나타낸 index, sum: 현재까지 합산된 
		
		isSelected[index] = true; // 현재 index의 수를 선택함
		sum += seq[index];// sum 계산
		
		if (sum == K)
			cnt++;
		
		if (sum > K)
			return;
		
		for (int i = index; i < N; i++)
			if (!isSelected[i]) {
				solve(i, sum);
				isSelected[i] = false; // 다른 경우의 수에서 고를 수 있도록
			}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);
			cnt = 0;

			seq = new int[N];
	

			input = br.readLine().split(" ");

			for (int i = 0; i < N; i++)
				seq[i] = Integer.parseInt(input[i]);

			for (int i = 0; i < N; i++) {
				isSelected = new boolean[N];
				solve(i, 0);
			}

			sb.append("#" + test_case + " " + cnt + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
