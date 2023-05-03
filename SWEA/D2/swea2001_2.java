import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class swea2001_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N, M;
		int[][] arr;
		int[][] m;
		String[] input;
		int max;
		int sum;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			arr = new int[20][20];
			m = new int[20][20];
			
			// 입력 받기
			for (int i = 1; i <= N; i++) { // 1~N 
				input = br.readLine().split(" ");
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(input[j - 1]);
					m[i][j] = arr[i][j]; // m 초기화
					
					// m[i][j]까지의 누적 최댓값 계산하기(중복 계산 없이)
					if (i > 0) { // 세로로 누적값
						m[i][j] += m[i - 1][j];
					}
					if (j > 0) { // 가로로 누적값
						m[i][j] += m[i][j - 1];
					}
					if (i > 0 && j > 0) { // 중복으로 더해진 값 빼기
						m[i][j] -= m[i - 1][j - 1];
					}
//					System.out.print(m[i][j] + " ");
				}

			}
				
			
//			System.out.println();
//			System.out.println(Arrays.deepToString(m));

			// 필요하지 않은 합산 값 제거하기(M*M 부분만 계산해야하므로)
			// max 계산
			max = 0;
			for (int i = 0; i <= N - M; i++) { // 0~N-M
				for (int j = 0; j <= N - M; j++) {
					sum = m[i + M][j + M] - m[i + M][j] - m[i][j + M] + m[i][j];
					if (max < sum) {
						max = sum;
					}
				}

			}
//			System.out.println(Arrays.deepToString(m));

			sb.append("#" + test_case + " " + max + "\n");

		}
		
		bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}

}