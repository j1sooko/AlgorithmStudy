import java.util.Scanner;

public class swea2050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.nextLine();
		
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i) - 'A' + 1 + " ");
		}
		
		System.out.print(sb.toString());
		sc.close();

	}

}
