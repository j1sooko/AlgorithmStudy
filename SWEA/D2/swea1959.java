import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1959 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			int[] a = new int[N];
			int[] b = new int[M];
			int[] result;
			int sum = 0;
			int max;
			
			//배열 생성
			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(input[i]);
			}
			input = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(input[i]);
			}

			//solution
			if (N == M) { //N과 M이 같을 경우 마주보는 숫자들을 곱한 후 더한다
				for (int i = 0; i < N; i++) {
					sum += a[i] * b[i];
				}
				max = sum;
			} else {
				if (N > M) { //N이 더 클 경우 M을 움직인다
					result = new int[N - M + 1];
					for (int k = 0; k <= N - M; k++) {
						sum = 0;
						for (int i = 0; i < M; i++) {
							sum += a[i + k] * b[i];
						}
						result[k] = sum;
					}
				} else { //M이 더 클 경우 N을 움직인다
					result = new int[M - N + 1];
					for (int k = 0; k <= M - N; k++) {
						sum = 0;
						for (int i = 0; i < N; i++) {
							sum += a[i] * b[i + k];
						}
						result[k] = sum;
					}
				}
				// 최댓값 찾기
				max = result[0];
				for (int i = 0; i < result.length; i++) {
					if (max < result[i]) {
						max = result[i];
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
