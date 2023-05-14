import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1285 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N  = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			
			int min = 100000;
			int count = 0;
			int d = 0;
			for (String a : arr) {
				d = Math.abs(Integer.parseInt(a));
				if (min > d) {
					min = d;
					count = 1;
				} else if (min == d) {
					count++;
				}
			}
			sb.append("#" + test_case + " " + min + " " + count + "\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
