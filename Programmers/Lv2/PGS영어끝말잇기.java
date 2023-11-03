import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        ArrayList<String> arr = new ArrayList<>();
        boolean pass = true;
        int i;
        
        for (i = 0; i < words.length; i++) {
            if (i > 0) {
                int pre = words[i - 1].charAt(words[i - 1].length() - 1);
                int post = words[i].charAt(0);
                if (pre != post) {
                    pass = false;
                    break;
                }
            }
            int idx = arr.indexOf(words[i]);
            if (idx == -1)
                arr.add(words[i]);
            else {
                pass = false;
                break;
            }
        }
        
        if (!pass) {
            answer[0] = i % n + 1;
            answer[1] = i / n + 1;
        }

        return answer;
    }
}
