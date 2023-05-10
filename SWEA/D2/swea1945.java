import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1945 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] cnt = new int[5];
			while (N != 1) {
				if (N % 2 == 0) {
					N /= 2;
					cnt[0]++;
				}
				if (N % 3 == 0) {
					N /= 3;
					cnt[1]++;
				}
				if (N % 5 == 0) {
					N /= 5;
					cnt[2]++;
				}
				if (N % 7 == 0) {
					N /= 7;
					cnt[3]++;
				}
				if (N % 11 == 0) {
					N /= 11;
					cnt[4]++;
				}
			}
			sb.append("#" + test_case);
			for (int i = 0; i < 5; i++) {
				sb.append(" " + cnt[i]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
        bw.close();
		

	}

}
