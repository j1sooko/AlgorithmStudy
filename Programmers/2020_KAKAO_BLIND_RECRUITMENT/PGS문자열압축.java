import java.util.Scanner;

public class PGS문자열압축 {
	public static int solution(String s) {
		int len = s.length();
		int answer = len;

		for (int unit = 1; unit < len; unit++) { // 문자열의 길이인 경우에는 할 필요 없음
			int cnt;
			String rst = "";
			String tmp;
			for (int i = 0; i < len; i++) {
				cnt = 1;
				int j;
				
				if (i + unit >= len) { // 남은 검사하려는 문자열이 unit 단위보다 적다면 남은 문자열을 넣고 끝
					tmp = s.substring(i, len);
					rst += tmp;
					break;
				}
				
				tmp = s.substring(i, i + unit); // 먄약 i + unit이 남은 문자열보다 작을 경우 처리
				for (j = i + unit; j + unit - 1 < len; j += unit) {
					if (tmp.equals(s.substring(j, j + unit)))
						cnt++;
					else
						break;
				}
				i = j - 1;

				if (cnt != 1)
					rst += cnt;
				rst += tmp;
			}
			answer = Math.min(answer, rst.length());
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String input = sc.next();

		System.out.print(solution(input));

		sc.close();
	}

}
