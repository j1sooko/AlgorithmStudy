import java.util.*;
class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static char[] numArr;
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        numArr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        // 입력 숫자 문자열을 char 배열로
        for (int i = 0; i < numbers.length(); i++) {
            numArr[i] = numbers.charAt(i);
        }
        
        find("", 0);
        answer = set.size();
        
        return answer;
    }
    
    public void find(String snum, int k) {
        if (snum != "") {
            // 소수 check
            int num = Integer.parseInt(snum);
            if (isPrime(num)) {
                set.add(num);
            }
            
        }
        if (k == numArr.length) return; // 종료
    
        for (int i = 0; i < numArr.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            find(snum + numArr[i], k + 1);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}


