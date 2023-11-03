import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int[] alphabets = new int[26];
        
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = Integer.MAX_VALUE;
            char c = (char)('A' + i);
            
            for (String key : keymap) {
                int idx = key.indexOf(c) + 1;
                if (idx != 0)
                    alphabets[i] = Math.min(idx, alphabets[i]);
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (alphabets[c - 'A'] == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                } else {
                    sum += alphabets[c - 'A'];  
                }
            }  
            answer[i] = sum;
        }
        
        return answer;
    }
}
