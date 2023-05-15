import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class swea1208 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine()); //덤프 횟수
			String[] input = br.readLine().split(" ");
			int[] box = new int[100];
			int d = 0;
			
			for (int i = 0; i < 100; i++) 
				box[i] = Integer.parseInt(input[i]);
			
			Arrays.sort(box);
			for (int i = 0; i < N; i++) {
				box[99]--;
				box[0]++;
				Arrays.sort(box);
				d = box[99] - box[0];
			}
			sb.append("#" + test_case + " " + d + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
