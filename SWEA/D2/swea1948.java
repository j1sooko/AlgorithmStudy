import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1948 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] daySum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {	
			String[] input = br.readLine().split(" ");
			int m1 = Integer.parseInt(input[0]);
			int d1 = Integer.parseInt(input[1]);
			int m2 = Integer.parseInt(input[2]);
			int d2 = Integer.parseInt(input[3]);
			
			int sum = 0;
			for (int j = m1; j <= m2; j++) {
				if (j == m1) { //첫 달일 경우
					sum += daySum[j - 1] - d1 + 1;
					if (m1 == m2) {
						break;
					}
				}
				else if (j == m2) { //마지막 달일 경우
					sum += d2;
				}
				else {
					sum += daySum[j - 1];
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
