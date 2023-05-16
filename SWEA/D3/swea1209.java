import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class swea1209 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int[][] mat = new int[100][100];
			int Tnum = Integer.parseInt(br.readLine());
			int[] sum = new int[202];
			
			for (int i = 0; i < 100; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < 100; j++)
					mat[i][j] = Integer.parseInt(input[j]);
			}

			for (int i = 0; i < 100; i++) { // 행
				for (int j = 0; j < 100; j++) { // 한 행당 8-N까지 검사
					sum[i] += mat[i][j]; //sum[0~99]: 가로합 저장
					sum[i + 100] += mat[j][i]; //sum[100~199]: 세로합 저장
					if (i == j) //sum[200]: 오른쪽 대각선 합 저장
						sum[200] += mat[i][j];
					if (i + j == 99) //sum[201]: 왼쪽 대각선 합 저장
						sum[201] += mat[i][j];
				}
			}
			
			Arrays.sort(sum); //내림차순 정렬, 마지막 값이 최댓값
			sb.append("#" + Tnum + " " + sum[201] + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}