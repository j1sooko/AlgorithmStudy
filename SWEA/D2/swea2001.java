import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea2001 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N, M;
		int[][] Narray;
		int[][] m;
		String[] input;
		int max;
		int sum;
		int sumRow;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			Narray = new int[N][N];
			sumRow = N - M + 1;
			m = new int[N][N - M + 1];
			
			// 입력 받기
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					Narray[i][j] = Integer.parseInt(input[j]);
				}
				// m 초기화
				for (int j = 0; j < N - M + 1; j++) {
					for (int k = j; k < j + M; k++) {
						m[i][j] += Narray[i][k];
					}
				}

			}

			// System.out.println(Arrays.deepToString(m));

			// max 계산
			max = m[0][0];
			for (int i = 0; i < sumRow; i++) {
				for (int j = 0; j < sumRow; j++) {
					sum = 0;
					for (int k = j; k < j + M; k++) {
						sum += m[k][i];
					}
					if (max < sum) {
						max = sum;
					}
				}
			}

			sb.append("#" + test_case + " " + max + "\n");

		}
		
		bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}

}