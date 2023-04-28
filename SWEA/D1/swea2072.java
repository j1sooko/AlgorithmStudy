import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea2072 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String[] s_input = br.readLine().split(" ");
			int sum = 0;
			for (String number: s_input) {
				int n = Integer.parseInt(number);
				if (n % 2 != 0) {
					sum += n;
				}
			}
			
			sb.append("#" + (i + 1) + " " + sum + "\n");
		
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
        bw.close();
		

	}

}
