import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1284 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int P, Q, R, S, W;
		int A, B;
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			P = Integer.parseInt(input[0]);
			Q = Integer.parseInt(input[1]);
			R = Integer.parseInt(input[2]);
			S = Integer.parseInt(input[3]);
			W = Integer.parseInt(input[4]);
			
			A = W * P;
			
			if (W <= R) {
				B = Q;
			} else {
				B = Q + (W - R) * S;
			}
			
			sb.append("#" + test_case + " " + ((A < B) ? A : B) + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
