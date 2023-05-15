import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1204 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] m = new int[101];
			
			String[] input = br.readLine().split(" ");
			for (String s : input) {
				int score = Integer.parseInt(s);
				m[score]++;
			}

			int maxCnt = 0;
			int avg = 0;
			
			for (int i = 100; i >= 0; i--) { //큰 점수부터 순회하여 최빈수가 여러개일때 큰 점수를 출력하게 함
				if (maxCnt < m[i]) {
					maxCnt = m[i];
					avg = i; 
				}
			}		
			sb.append("#" + test_case + " " + avg + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
