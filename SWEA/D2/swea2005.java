import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea2005 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int len = N * (N + 1) / 2;
			int[] paskal = new int[len];
			
			paskal[0] = 1;
			int k = 0;
			
			sb.append("#" + test_case + "\n");
			
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < i; j++) {
					if (j == 0) { // 왼쪽 변 부분
						paskal[k] = paskal[k - i + 1];
					} else if (j == i - 1) { // 오른쪽 변 부분
						paskal[k] = paskal[k - i];
					} else {
						paskal[k] = paskal[k - i + 1] + paskal[k - i];
					}
					sb.append(paskal[k] + " ");
					k++;
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
