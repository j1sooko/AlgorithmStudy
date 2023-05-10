import java.util.Scanner;

public class swea2058 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		char[] arr = N.toCharArray();
		int sum = 0;
		
		for (char c : arr) {
			sum += c - '0';
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
