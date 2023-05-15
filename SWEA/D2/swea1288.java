import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1288 {
	static boolean isAllChecked(int[] arr) {
		for (int i : arr) {
			if (i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int kN = N;
			int[] m = new int[10];
			int n;

			while (!isAllChecked(m)) {
				for (char s : String.valueOf(kN).toCharArray()) {
					n = s - '0';
					if (m[n] == 0) {
						m[n] = 1;
					}

				}
				kN += N;
			}

			sb.append("#" + test_case + " " + (kN - N) + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
