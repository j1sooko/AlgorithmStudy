import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    // 모든 자리수의 합 계산
    public static int sum(String str) {
    	if (str.equals("")) return 0;
    	
    	int sum = 0;
    	
    	for (int i = 0; i < str.length(); i++)
    		sum += str.charAt(i) - '0';
    	return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] serial = new String[N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            serial[i] = br.readLine();
        }


        Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int diffLen = s1.length() - s2.length(); 
				if (diffLen != 0) //  1. 길이가 짧은 것 먼저
					return s1.length() - s2.length();
				else {
					String ints1 = s1.replaceAll("[^0-9]", "");
					String ints2 = s2.replaceAll("[^0-9]", "");
					
					int diffSum = sum(ints1) - sum(ints2);
					if (diffSum != 0) // 2. 자리수의 합이 작은 것 먼저
						return sum(ints1) - sum(ints2);
					else //  3. 사전 순(숫자가 알파벳보다 작음)
						return s1.compareTo(s2);
				}
			}
        	
        };
        
        Arrays.sort(serial, comp);
        
        for (int i = 0; i < serial.length; i++)
        	System.out.println(serial[i]);

        br.close();
    }

}
