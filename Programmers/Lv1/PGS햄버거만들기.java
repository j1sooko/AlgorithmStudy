import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] tmp = new int[ingredient.length];
        int idx = 0;
        
        for (int i : ingredient) {
            tmp[idx++] = i;
            if (idx >= 4) { //재료가 4개 이상 모였고
                // 햄버거 재료 순서가 맞으면
                if (tmp[idx - 4] == 1 && tmp[idx - 3] == 2 && tmp[idx - 2] == 3 && tmp[idx - 1] == 1) {
                    idx -= 4; // 재료를 써서 햄버거를 만듦
                    answer++;
                }
            }
        
        }
        
        return answer;
    }
}
