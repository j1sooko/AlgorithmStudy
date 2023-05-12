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
			String tmp = "";
			for (int i = 0; i < 30; i++) {
				// 다음 문자에 tmp와 동일한 문자열이 있는지 확인한다
				boolean isSame = true;
				for (int j = 0; j < tmp.length(); j++) {
					if (input.charAt(i + j) != tmp.charAt(j)) {
						isSame = false;
						break;
					}
				}
				
				// 있을 경우 tmp의 문자 길이 반환
				if (isSame && !tmp.isEmpty()) {
					break;
				}
				// 없을 경우 tmp에 현재 문자를 추가한다
				else {
					tmp += input.charAt(i);
				}
			}
			System.out.println("#" + test_case + " " + tmp.length());

		}
		br.close();
		bw.flush();
		bw.close();
	}

}
