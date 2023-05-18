import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea3431 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			int L = Integer.parseInt(input[0]);
			int U = Integer.parseInt(input[1]);
			int X = Integer.parseInt(input[2]);
			
			int ans = 0;
			if (X < L)
				ans = L - X;
			else if (X > U)
				ans = -1;
			
			sb.append("#" + test_case + " " + ans + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
