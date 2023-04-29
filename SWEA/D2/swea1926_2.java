import java.util.Scanner;

public class swea1926_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();;
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			String number = String.valueOf(i);
			
			if (number.matches(".?[369].?")) {
				number = number.replaceAll("[369]", "-");
				number = number.replaceAll("[0124578]", "");
			}
			sb.append(number + " ");
		}
		System.out.print(sb.toString());
		sc.close();
	}

}
