import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1928 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[][] sudoku = new int[9][9];
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 1;
			for (int i = 0; i < 9; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < 9; j++) {
					// 입력 받기
					sudoku[i][j] = Integer.parseInt(input[j]);
				}
			}

			for (int i = 0; i < 9; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 0; j < 9; j++) {
					// 가로 합 계산
					rowSum += sudoku[i][j];
					// 세로합 계산
					colSum += sudoku[j][i];
				}
				if (rowSum != 45 || colSum != 45) {
					ans = 0;
					break;
				}
			}
			
			//격자합 계산
			for (int i = 0; i <= 6; i += 3) {
				for (int j = 0; j <= 6; j += 3) {
					int squareSum = 0;
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							squareSum += sudoku[i + r][j + c];
						}
					}
					if (squareSum != 45) {
						ans = 0;
						break;
					}
				}
			}
			sb.append("#" + test_case + " " + ans + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
