import java.util.Scanner;

public class swea2070 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int n1, n2;
		char sign;
		for (int test_case = 1; test_case <= T; test_case++) {
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			
			if (n1 > n2) {
				sign = '>';
			} else if (n1 < n2) {
				sign = '<';
			} else {
				sign = '=';
			}
			
			System.out.println("#" + test_case + " " + sign);
		}
		
		sc.close();
	}

}
