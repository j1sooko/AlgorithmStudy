import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int len = people.length;
        int answer = len;
        boolean[] choice = new boolean[len];
        
        // 오름차순 정렬
        Arrays.sort(people);
        
        int choiceIdx = 0;
        for (int i = len - 1; i > choiceIdx; i--) {
            if (people[i] >= limit) // limit 이상이라면 혼자 타야하는 것이 정해짐
               continue;
            // if 가장 무거운 사람 + 가장 가벼운 사람 <= limit, then 같이 탐
            // 가장 가벼운 사람과 타도 limit 이상이라면 혼자 타야함
            if (people[choiceIdx] + people[i] <= limit) {
                answer--;
                choiceIdx++;
            } 
        }
        
        return answer;
    }
}
