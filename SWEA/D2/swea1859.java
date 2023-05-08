import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1859 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] s_input = br.readLine().split(" ");
			int[] priceList = new int[N];
			long sum = 0;
			int max;
			
			// 배열 생성
			for (int i = 0; i < N; i++) {
				priceList[i] = Integer.parseInt(s_input[i]);
			}
			max = priceList[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if (priceList[i] < max) {
					sum += max - priceList[i];
				}
				else {
					max = priceList[i];
				}
			}
			sb.append("#" + test_case + " " + sum + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
        bw.close();
	}

}
