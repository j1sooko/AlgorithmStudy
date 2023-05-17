import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1220 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] table = new int[N][N];
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++)
					table[i][j] = Integer.parseInt(input[j]);
			}
			
			for (int i = 0; i < N; i++) {
				boolean meetRed = false;
				for (int j = 0; j < N; j++) {
					if (table[j][i] == 1)
						meetRed = true; 
					else if (meetRed && table[j][i] == 2) {// 2이고 전에 1을 만난 적 있을 경우 cnt++
						cnt++;
						meetRed = false;
					}
					
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
