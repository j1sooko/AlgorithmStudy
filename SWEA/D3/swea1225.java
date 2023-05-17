import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class swea1225 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
//			int[] arr = new int[8];

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < 8; i++)
				queue.add(Integer.parseInt(input[i]));
			
			boolean isPassword = false;
			while (!isPassword) {
				for (int i = 1; i <= 5; i++) {
					int dequeueNum = queue.remove() - i;
					if (dequeueNum <= 0) {
						isPassword = true;
						queue.add(0);
						break;
					}
					queue.add(dequeueNum);
				}
			}

			sb.append("#" + test_case + " ");
			for (int i = 0; i < 8; i++)
				sb.append(queue.remove() + " ");
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}