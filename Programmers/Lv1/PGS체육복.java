import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        boolean find = false;
        int findIdx;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayList<String> reserveList = new ArrayList<>();
        
        for (int num : reserve) {
            reserveList.add(String.valueOf(num));
        }
        
        // 잃어버린 사람이 여벌을 갖고있는지 먼저 체크
        for (int i = 0; i < lost.length; i++) {
            findIdx = reserveList.indexOf(String.valueOf(lost[i]));
            if (findIdx != -1) { 
                reserveList.remove(findIdx);
                lost[i] = -1;
                }
        }
        
        // 앞뒤 번호의 학생이 여벌을 갖고 있는지 순으로 체크
        for (int i = 0; i < lost.length; i++) {
            int[] arr = {-1, 1};
            if (lost[i] != -1) {
                for (int k : arr) {
                    findIdx = reserveList.indexOf(String.valueOf(lost[i] + k));
                    if (findIdx != -1) { 
                        reserveList.remove(findIdx);
                        find = true;
                        break;
                    }
                }
                if (!find) {
                answer--;
                }
            }
  
            find = false;
            System.out.println();
        }
        
        return answer;
    }
}
