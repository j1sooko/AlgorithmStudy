import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class swea1974_2 {

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

			//가로 체크
			for (int i = 0; i < 9; i++) {
				boolean[] isUsed = new boolean[10];
				for (int j = 0; j < 9; j++) {
					if (isUsed[sudoku[i][j]]) {
						ans = 0;
						break;
					} else {
						isUsed[sudoku[i][j]] = true;
					}
				}
			}
			
			//세로 체크
			for (int i = 0; i < 9; i++) {
				boolean[] isUsed = new boolean[10];
				for (int j = 0; j < 9; j++) {
					if (isUsed[sudoku[j][i]]) {
						ans = 0;
						break;
					} else {
						isUsed[sudoku[j][i]] = true;
					}
				}
			}
			
			//격자 체크
			for (int i = 0; i <= 6; i += 3) {
				for (int j = 0; j <= 6; j += 3) {
					boolean[] isUsed = new boolean[10];
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							if (isUsed[sudoku[i + r][j + c]]) {
								ans = 0;
								break;
							} else {
								isUsed[sudoku[i + r][j + c]] = true;
							}
						}
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
