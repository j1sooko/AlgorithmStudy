import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int big, small;
		
		if (m > (n - m)) {
			big = m;
			small = n - m;
		} else {
			big = n - m;
			small = m;
		}
		
		BigInteger val1 = new  BigInteger("1");
		BigInteger val2 = new  BigInteger("1");
		
		for (int i = n; i > big; i--)
			val1 = val1.multiply(new BigInteger(String.valueOf(i))); 
		for (int i = small; i >= 1; i--)
			val2 = val2.multiply(new BigInteger(String.valueOf(i))); 
		
		System.out.println(val1.divide(val2));

		br.close();

	}
}
