package BOJ11866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) { 
			queue.add(i);
		}
		
		sb.append("<");
		while (!queue.isEmpty()) { 
			for (int i = 0; i < K - 1; i++) {
				int tmp = queue.poll();
				queue.add(tmp);
			}
			
			if (queue.size() != 1) {
				sb.append(queue.poll() + ", ");
			} else {
				sb.append(queue.poll() + ">");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
