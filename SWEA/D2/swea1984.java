import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class swea1984 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			int[] arr = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			
			//정렬
			Arrays.sort(arr);
			
			//평균값 구하기
			double sum = 0;
			for (int i = 1; i < arr.length - 1; i++) {
				sum += arr[i];
			}

			sb.append("#" + test_case + " " + Math.round(sum / (arr.length - 2)) + "\n");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
