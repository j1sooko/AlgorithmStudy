import java.util.Scanner;

public class swea2058_2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int N = Integer.parseInt(input);
		
		int sum = 0;
		
		for (int i = 0; i < 4; i++) {
			sum += N % 10;
			N /= 10; 
		}
		System.out.println(sum);
		
		sc.close();
	}

}
