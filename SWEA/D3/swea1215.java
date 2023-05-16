import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1215 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int[][] board = new int[8][8];
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				String input = br.readLine();
				for (int j = 0; j < 8; j++) {
					board[i][j] = input.charAt(j) - '0';
				}
			}

			// 가로 검사
			for (int i = 0; i < 8; i++) { // 행
				for (int j = 0; j <= 8 - N; j++) { // 한 행당 8-N까지 검사
					boolean isPalindrome = true;
					for (int k = 0; k < N / 2; k++) {
						if (board[i][k + j] != board[i][N - 1 - k + j]) {
							isPalindrome = false;
							break;
						}
					}
					if (isPalindrome)
						cnt++;
				}
			}
			
			// 세로 검사
			for (int i = 0; i < 8; i++) { // 열
				for (int j = 0; j <= 8 - N; j++) { // 한 열당 8-N까지 검사
					boolean isPalindrome = true;
					for (int k = 0; k < N / 2; k++) {
						if (board[k + j][i] != board[N - 1 - k + j][i]) {
							isPalindrome = false;
							break;
						}
					}
					if (isPalindrome)
						cnt++;
				}
			}
			sb.append("#" + test_case + " " + cnt + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}