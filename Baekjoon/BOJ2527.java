
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2527 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 4; test_case++) {
			String[] input = br.readLine().split(" ");
			int ax, ay, ap, aq, bx, by, bp, bq;
			char ans;
			ax = Integer.parseInt(input[0]);
			ay = Integer.parseInt(input[1]);
			ap = Integer.parseInt(input[2]);
			aq = Integer.parseInt(input[3]);
			bx = Integer.parseInt(input[4]);
			by = Integer.parseInt(input[5]);
			bp = Integer.parseInt(input[6]);
			bq = Integer.parseInt(input[7]);
			
			if (bx > ap || bp < ax || by > aq || bq < ay)
				ans = 'd'; 
			else if ((ap == bx && aq == by) || (ap == bx) && (ay == bp) ||
					(ax == bp && ay == bq) || (ax == bp && aq == by))
				ans = 'c';
			else if (ay == bq || aq == by || ax == bp || ap == bx)
				ans = 'b';
			else
				ans = 'a';
			
			sb.append(ans + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
