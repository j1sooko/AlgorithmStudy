import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1949_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] daySum = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		//누적 값 게산
		for (int i = 2; i < 13; i++) {
			daySum[i] += daySum[i-1];
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {	
			String[] input = br.readLine().split(" ");
			int m1 = Integer.parseInt(input[0]);
			int d1 = Integer.parseInt(input[1]);
			int m2 = Integer.parseInt(input[2]);
			int d2 = Integer.parseInt(input[3]);
			
			int sum1 = daySum[m1 - 1]; //1월~첫번째 날짜의 전달까지
			sum1 += d1; //첫번째 날짜까지의 누적일수
			int sum2 = daySum[m2 - 1]; //1월~두번째 날짜의 전달까지
			sum2 += d2; //두번째 날짜까지의 누적일수
			
			sb.append("#" + (i + 1) + " " + (sum2 - sum1 + 1) + "\n");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
        bw.close();
	}
}
