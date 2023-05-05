import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1989 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		String s;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int isPalindrome = 1;
			s = br.readLine();
			
			for (int i = 0; i < s.length() / 2 + 1; i++) {
				if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
					isPalindrome = 0;
					break;
				}
			}
			
			sb.append("#" + test_case + " " + isPalindrome + "\n");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
