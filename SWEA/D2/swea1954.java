import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1954 {
	public static int[][] snail;
	public static int num;
	public static boolean flag;
	
	static void solve (int N) {
		for (int s = 0, e = N - 1; ; s++, e--) {
			right(s, e, s);
			if (num > N * N) return;
			down(s + 1, e, e);
			if (num > N * N) return;
			left(e - 1, s, e);
			if (num > N * N) return;
			up(e - 1, s + 1, s);
			if (num > N * N) return;
		}
		
	}
	
	static void right(int s, int e, int i) {
		for (int j = s; j <= e; j++) {
			snail[i][j] = num;
			num++;
		}
	}
	
	static void down(int s, int e, int j) {
		for (int i = s; i <= e; i++) {
			snail[i][j] = num;
			num++;
		}
	}
	
	static void left(int s, int e, int i) {
		for (int j = s; j >= e; j--) {
			snail[i][j] = num;
			num++;
		}
	}
	
	static void up(int s, int e, int j) {
		for (int i = s; i >= e; i--) {
			snail[i][j] = num;
			num++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			num = 1;
			flag = false;
			solve(N);
			
			sb.append("#" + test_case + " \n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(snail[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}

}