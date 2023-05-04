import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea2071 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			String[] input = br.readLine().split(" ");
			double sum = 0; //자료형 주의
			for (int i = 0; i < 10; i++) {
				sum += Integer.parseInt(input[i]);
			}
			sb.append("#" + test_case + " " + (Math.round(sum / 10)) + "\n"); //소수점 첫째자리에서 반올림
		}
		
		bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}

}
