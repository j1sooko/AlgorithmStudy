import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Balloon {
	int index;
	int num;

	Balloon(int index, int num) {
		this.index = index;
		this.num = num;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Deque<Balloon> deque = new ArrayDeque<>(); // **LinkedList 사용시 메모리 초과 발생
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			deque.add(new Balloon(i + 1, Integer.parseInt(input[i])));
		}

		// 첫번째 풍선 제거
		Balloon b = deque.pollFirst();
		sb.append(b.index + " ");
		// 풍선이 터지고 나온 종이값에 해동한만큼 이동하여 제거
		while (!deque.isEmpty()) { // 모든 풍선이 터질때까지
			int num = b.num;
//			int num = (deque.size() == 0) ? b.num : (b.num + 1) % deque.size(); // 메모리 초과 방지

			if (num > 0) { // 오른쪽으로 이동: 앞에서부터 풍선을 제거하여 다시 뒤에 붙임으로써 이동
				for (int i = 0; i < num - 1; i++) {
					deque.offerLast(deque.pollFirst());
				}
				b = deque.pollFirst();

			} else if (num < 0) { // 왼쪽으로 이동: 뒤에서부터 풍선을 제거하여 앞에 붙임으로써 이동
				for (int i = 0; i > num + 1; i--) {
					deque.offerFirst(deque.pollLast());
				}
				b = deque.pollLast();
				
			}
			sb.append(b.index + " ");


		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
