import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			sb.append("#" + test_case + "\n");
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				String C = input[0];
				int K = Integer.parseInt(input[1]);
				
				for (int j = 0; j < K; j++) {
					sb.append(C);
					cnt++;
					if (cnt == 10) {
						sb.append("\n");
						cnt = 0;
					}
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
