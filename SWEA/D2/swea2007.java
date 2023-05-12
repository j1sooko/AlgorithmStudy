import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class swea2007 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String input = br.readLine();
			String pattern = "";
			int patternLen;
			for (int i = 0; i < 30; i++) {
				pattern += input.charAt(i);
				patternLen = pattern.length();
				if (pattern.equals(input.substring(patternLen, patternLen + patternLen))) {
					//패턴을 제거하고 남은 남은 문자열 길이가 패턴 길이보다  작을 경우 break
					String restString = input.replace(pattern, "");
					if (restString.length() < patternLen)
						break;
				}
			}
			System.out.println("#" + test_case + " " + pattern.length());

		}
		br.close();
		bw.flush();
		bw.close();
	}

}
