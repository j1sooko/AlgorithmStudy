import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1216 {
	static boolean isPalindrome(int len, int[][] arr) {
		for (int i = 0; i < 100; i++) { // 행
			// 가로 검사
			for (int j = 0; j < 100 - len + 1; j++) { // 열
				boolean flag = true;
				for (int k = 0; k < len / 2; k++) { // palindrome 검사
					if (arr[i][j + k] != arr[i][j + len - 1 - k]) {
						flag = false;
						break;
					}
				}
				if (flag)
					return true;
			}
			// 세로 검사
			for (int j = 0; j < 100 - len + 1; j++) { // 열
				boolean flag = true;
				for (int k = 0; k < len / 2; k++) { // palindrome 검사
					if (arr[j + k][i] != arr[j + len - 1 - k][i]) {
						flag = false;
						break;
					}
				}
				if (flag)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int[][] board = new int[100][100];
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				for (int j = 0; j < 100; j++)
					board[i][j] = input.charAt(j) - '0';
			}

			// 가로 검사
			for (int i = 100; i >= 0; i--) // palindrome의 길이를 0부터 100까지, 큰 순서대로
				if (isPalindrome(i, board)) {
					sb.append("#" + test_case + " " + i + "\n");
					break;
				}
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}