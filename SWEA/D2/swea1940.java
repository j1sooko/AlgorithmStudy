import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1940 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int v = 0, d = 0;
			int c;
			for (int i = 0; i < N; i++) { //커맨드 수 만큼 반복
				String[] input = br.readLine().split(" ");
				c = Integer.parseInt(input[0]);
				if (c == 0) { //속도를 유지할 경우
					d += 1 * v;
				}
				else {
					int a = Integer.parseInt(input[1]);
					if (c == 1) { // 가속할 경우
						v += a;
					
					} else if (c == 2) { // 감속할경우
						if (v < a) { // 현재 속도보다 감속할 속도가 더 클 경우
							v = 0;
						} else { 
							v -= a;
						}
					}
					d += 1 * v;
				}

			}
			sb.append("#" + test_case + " " + d + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
