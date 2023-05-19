import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class swea3131 {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = 1000000;
		int[] arr = new int[N + 1];

		for (int i = 0; i < N + 1; i++)
			arr[i] = i; // 100,0000까지 나열

		// 아직 처리하지 않은 가장 작은 수를 찾아 그 수를 제외한 배수 제거
		for (int i = 2; i < Math.sqrt(N) + 1; i++) { // 2~N의 제곱근까지 확인
			int j = 2;
			while (i * j <= N) { // i의 N까지의 배수 순회
				arr[i * j] = -1;
				j++; //2, 3, 4...

			}
		}
		
		for (int i = 2; i < N + 1; i++)
			if (arr[i] != -1)
				sb.append(arr[i] + " ");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
