import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1244 {
	static int[] num;
	static int cnt;
	static int max;

	static void swap(int a, int b) {
		int tmp;
		tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
	}
	
	static void solve(int start, int k) {
		if (k == cnt) { // cnt번 만큼 모두 바꿨다면 최댓값 계산
			String s = "";
			for (int i = 0; i < num.length; i++)
				s += num[i];
			max = Math.max(max, Integer.parseInt(s));
			return;
		}

		for (int i = start; i < num.length; i++) // 재귀할 때 전에 위치를 바꾼 다음 수부터 바꾼다
			for (int j = i + 1; j < num.length; j++) { // 위치를 바꿀 수들을 탐색
					swap(i, j);
					solve(i, k + 1);
					swap(j, i); // 다른 경우의 수를 위해 원상태 복귀
			}
		

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			num = new int[input[0].length()];
			cnt = Integer.parseInt(input[1]);
			max = 0;
			for (int i = 0; i < input[0].length(); i++)
				num[i] = input[0].charAt(i) - '0';

			if (cnt > num.length) // *** 시간초과 해결 : 문자열 길이보다 교환횟수가 크면 문자열 길이만큼만 바꾼다 (문자열 길이만큼만 바꿔도 모든 배열을 만들 수 있음)
				cnt = num.length; // ex. 49 10일 경우 10번 다 할 필요 없이 문자열 길이인 2번만 하면 됨
			solve(0, 0);
			sb.append("#" + test_case + " " + max + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}
}
