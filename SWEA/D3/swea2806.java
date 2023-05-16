import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea2806 {
	static int cnt;
	static int[] board;

	static void nQueen(int N, int k) {

		if (k == N) {// N개의 말을 모두 놓았음
			cnt++;
		} else {
			for (int i = 0; i < N; i++) { // 하나의 행마다 N개의 열씩 말을 놓아본다(가로 체크: 한 행에 1개를 놓으면 끝)
				boolean isPossible = true;
				for (int j = 0; j < k; j++) { // 이전에 놓았던 말들에 대해 세로, 오른쪽 대각선, 왼쪽 대각선 체크
					if (i == board[j] || i == board[j] + (k - j) || i == board[j] - (k - j))
						isPossible = false;
				}
				if (isPossible) {
					board[k] = i;
					nQueen(N, k + 1);
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			cnt = 0;
			board = new int[N];
			nQueen(N, 0); // 0행부터 시작
			sb.append("#" + test_case + " " + cnt + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
