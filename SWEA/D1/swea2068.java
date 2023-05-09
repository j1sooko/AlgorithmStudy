import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea2068 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] inputList = br.readLine().split(" ");
			int[] numList = new int[10];
			int i = 0;
			
			for (String input : inputList) {
				numList[i] = Integer.parseInt(input);
				i++;
			}
			
			int max = numList[0];
			
			for (int n : numList) {
				if (max < n) {
					max = n;
				}
			}
	
			sb.append("#" + test_case + " " + max + "\n");
		}
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
