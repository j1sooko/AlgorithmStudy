import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1206 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] building = new int[N];
			int count = 0;
			
			for (int i = 0; i < N; i++)
				building[i] = Integer.parseInt(input[i]);
				
			
			for (int i = 0; i < N; i++) {
				// 건물의 높이가 0일 경우 continue
				if (building[i] == 0)
					continue;
				// 현재 건물의 높이가 뒤의 두 건물 높이보다 커야함
				else {
					int d = 255;
					for (int j = 2; j >= -2; j--) {
						if (j == 0) continue;
						d = (building[i] - building[i + j] < d) ? building[i] - building[i + j] : d;
						if (d < 0) { // 앞 혹은 뒤의 건물의 높이가 더 큼
							d = 0;
							break; 
						}
					}
					count += d;
	
				}
			}
			
			sb.append("#" + test_case + " " + count + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
