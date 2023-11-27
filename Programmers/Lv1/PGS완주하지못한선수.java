import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            if (map.containsKey(p)) { // 이미 존재한다면 value + 1
                int cnt = map.get(p);
                map.put(p, ++cnt);
            } else {
               map.put(p, 1); 
            }
        }
        
        for (String c : completion) {
            if (map.get(c) > 1) {
                int cnt = map.get(c);
                map.put(c, --cnt); 
            } else {
                map.remove(c);
            }
        }
        
        for (String key : map.keySet())
            answer = key;
        
        
        return answer;
    }
}
