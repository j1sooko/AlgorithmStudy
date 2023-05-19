import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class swea1234 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); // 문자열 길이
			ArrayList<String> arr = new ArrayList<>(Arrays.asList(input[1].split("")));
	
			int i  = 0;
			while (i < arr.size() - 1) {
				if (arr.get(i).equals(arr.get(i + 1))) {
					arr.remove(i);
					arr.remove(i);
					i = 0;
				} else
					i++;
			}
			

			sb.append("#" + test_case + " ");
			for (String s : arr)
				sb.append(s);
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
