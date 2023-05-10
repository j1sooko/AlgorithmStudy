import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1976 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			int h1 = Integer.parseInt(input[0]);
			int m1 = Integer.parseInt(input[1]);
			int h2 = Integer.parseInt(input[2]);
			int m2 = Integer.parseInt(input[3]);
			
			int mm = (m1 + m2) % 60;
			int hh = (h1 + h2 + (m1 + m2) / 60) % 12;
			
			if (hh == 0) {
				hh = 12;
			}
			
			sb.append("#" + test_case + " " + hh + " " + mm + "\n");
		
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
        bw.close();
		

	}

}
