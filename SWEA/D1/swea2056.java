import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class swea2056 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		int[] dayList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i = 1; i <= 12; i++) {
			if (i <10) {
				map.put("0" + i, dayList[i - 1]);
			} else {
				map.put(String.valueOf(i), dayList[i - 1]);
			}
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			String input = br.readLine();
			String yyyy = input.substring(0, 4);
			String mm = input.substring(4, 6);
			String dd = input.substring(6, 8);
			int day = Integer.parseInt(dd);
			
			if ((day > 0) && (day <= map.getOrDefault(mm, 0))) {
				sb.append("#" + test_case + " " + yyyy + "/" + mm + "/" + dd + "\n");
			} else {
				sb.append("#" + test_case + " -1\n");
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
