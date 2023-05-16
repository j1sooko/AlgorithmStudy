import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++)
					farm[i][j] = input.charAt(j) - '0';
			}

			int sum = 0;

			for (int i = 1; i <= N / 2; i++) { // 마름모윗부분
				for (int j = i; j < N - i; j++)
					sum += farm[N / 2 - i][j];
			}

			for (int j = 0; j < N; j++) // 마름모가운데부분
				sum += farm[N / 2][j];

			for (int i = 1; i <= N / 2; i++) { // 마름모아랫부분
				for (int j = i; j < N - i; j++)
					sum += farm[N / 2 + i][j];
			}

			sb.append("#" + test_case + " " + sum + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}