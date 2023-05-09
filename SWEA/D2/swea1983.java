import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class swea1983 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		String[] gradeList = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int K = Integer.parseInt(input[1]);
			int rat = N / 10;
			Map<Integer, Double> map = new HashMap<>();

			for (int i = 1; i <= N; i++) {
				String[] scoreList = br.readLine().split(" ");
				// 총점 계산하여 map에 저장
				double score = Integer.parseInt(scoreList[0]) * 0.35 + Integer.parseInt(scoreList[1]) * 0.45 + Integer.parseInt(scoreList[2]) * 0.2;
				map.put(i, score);

			}

			// value 기준으로  내림차순 정렬
			List<Integer> keySetList = new ArrayList<>(map.keySet());
			Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

			int rank = keySetList.indexOf(K) + 1;
			int remain = rank % rat;
			String grade;
			if (remain > 0) {
				grade = gradeList[rank / rat]; //나머지가 있을 경우 다음 grade
			} else {
				grade = gradeList[rank / rat - 1];
			}

			sb.append("#" + test_case + " " + grade + "\n");

		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
