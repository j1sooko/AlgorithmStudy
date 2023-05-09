import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea2063 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] inputList = br.readLine().split(" ");
		int[] numList = new int[N];
		
		int i = 0;
		for (String input : inputList) {
			numList[i] = Integer.parseInt(input);
			i++;
		}
		
		Arrays.sort(numList);
		System.out.println(String.valueOf(numList[N / 2]));
		br.close();
	}
}
