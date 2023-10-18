import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int cut = -1;
        for (int[] target : targets) {
            if (cut > target[0]) {
                continue;
            }
            answer++;
            cut = target[1];
        }
        return answer;
    }
}
