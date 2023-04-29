import java.util.Scanner;

public class swea1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			String number = String.valueOf(i);
			String result = number.replace("3", "-");
			result = result.replace("6", "-");
			result = result.replace("9", "-");

			// "-" 갯수 세기
			int count = result.length() - result.replace("-", "").length();
			
			if (count == 0) { //박수를 칠 필요가 없는 경우
				sb.append(number);
			} else { //박수를 한 번이라도 쳐야할 경우(숫자 제거)
				for (int j = 0; j < count; j++) {
					sb.append("-");
				}
			}

			sb.append(" ");
		}
		System.out.print(sb.toString());
		sc.close();
	}

}
