import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class swea1240 {
	static Map<String, String> map = new HashMap<>();

	static int validateCode(String str) {
		int a = 0, b = 0;
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			if (str.charAt(i) == 'n')
				return 0;
			else {
				if (i % 2 != 0)
					a += str.charAt(i) - '0';
				else
					b += str.charAt(i) - '0';
			}
		}

		if ((a * 3 + b) % 10 == 0)
			for (int i = 0; i < str.length(); i++)
				cnt += str.charAt(i) - '0';
		else
			return 0;

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		map.put("0001101", "0");
		map.put("0011001", "1");
		map.put("0010011", "2");
		map.put("0111101", "3");
		map.put("0100011", "4");
		map.put("0110001", "5");
		map.put("0101111", "6");
		map.put("0111011", "7");
		map.put("0110111", "8");
		map.put("0001011", "9");

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			String codeStr = "";

			// 코드가 존재하는 행을 저장
			for (int i = 0; i < N; i++) {
				String input2 = br.readLine();
				for (int j = 0; j < M; j++) {
					if (input2.charAt(j) == '1') {
						codeStr = input2;
						break;
					}
				}
			}

			// 코드가 존재하는 행을 뒤에서부터 읽어 1이 나오는 순간부터 7자씩 읽어 뒤집어서 코드 검증
			String str = "";
			int ans = 0;
			for (int i = codeStr.length() - 1; i >= 0; i--) {
				if (codeStr.charAt(i) == '1') {
					for (int j = i; j >= i - 49; j -= 7)
						str += map.getOrDefault((codeStr.substring(j - 6, j + 1)), "n");
					break;
				}
			}

			ans = validateCode(str);

			sb.append("#" + test_case + " " + ans + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
