import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class swea1860 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); // 손님 수
			int M = Integer.parseInt(input[1]); // 붕어빵 만드는 데 걸리는 시간
			int K = Integer.parseInt(input[2]); // M초당 만들 수 있는 붕어빵 개수

			input = br.readLine().split(" ");
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) // 손님이 오는 시간을 저장
				arr[i] = Integer.parseInt(input[i]);

			Arrays.sort(arr); // 시간 순서대로 정렬

			boolean isPossible = true;
			for (int i = 0; i < N; i++) {
				arr[i] = (arr[i] / M) * K; // 시간이 지남에 따라 만들 수 있는 붕어빵 개수를 다시 저장
				arr[i] -= (i + 1); // 이전에 온 손님 수만큼 붕어빵 개수를 차감
				if (arr[i] < 0) { // 음수가 되었다면 붕어빵 개수가 부족했음
					isPossible = false;
					break;
				}
			}

			String ans;
			if (isPossible)
				ans = "Possible";
			else
				ans = "Impossible";

			sb.append("#" + test_case + " " + ans + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
