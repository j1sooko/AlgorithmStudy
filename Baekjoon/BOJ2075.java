package BOJ2075;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 오름차순

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(input[j]);
				if (priorityQueue.size() == N) { // 큐 size가 N이 되면 min 값과 현재 입력값을 비교한 후 큰 값을 넣음
					if (priorityQueue.peek() < num) {
						priorityQueue.poll();
						priorityQueue.add(num);
					}

				} else {
					priorityQueue.add(num);
				}

			}
		}
		System.out.print(priorityQueue.poll());

		br.close();
	}
}
