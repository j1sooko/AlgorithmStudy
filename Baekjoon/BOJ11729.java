import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	/*
	 * 전역 변수를 사용하지 않으려면 n-1개의 원판을 tmp에서 to로, 그리고 to에서 tmp로 옮기는 경우의 수 마지막 원판 하나를 to로
	 * 옮기는 횟수 if (n == 1) return 1; return 1 + (hanoi_count(n - 1) * 2);
	 */
	static int cnt = 0;
	static StringBuilder sb;

	static void hanoiTower(int from, int tmp, int to, int n) {
		if (n == 1) {
			sb.append(from + " " + to + "\n");
			cnt++;
			return;
		} else {
			hanoiTower(from, to, tmp, n - 1); // 3번 장대를 temp로 사용하고 1->2
			sb.append(from + " " + to + "\n"); // 1->3
			cnt++;
			hanoiTower(tmp, from, to, n - 1); // 1번 장대를 temp로 사용하고 3->2
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		hanoiTower(1, 2, 3, N);
		System.out.println(cnt);

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}
}
