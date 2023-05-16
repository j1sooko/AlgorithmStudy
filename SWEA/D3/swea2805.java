import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea2805 {
	static int sum;
	static int[][] farm;

	static void solve(int N, int k, int a) {
		for (int i = 0 + a; i < N - a; i++)
			sum += farm[N / 2 + k][i];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < N; j++)
					farm[i][j] = Integer.parseInt(input[j]);
			}

			sum = 0;

			solve(N, 0, 0);
			for (int i = 1; i <= N / 2; i++) {
				solve(N, -i, i);
				solve(N, i, i);
			}
			// solve(N, 0, 0); // 0행부터 시작
			sb.append("#" + test_case + " " + sum + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
