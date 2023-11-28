import java.util.*;
import java.text.SimpleDateFormat;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        
        // hashmap에 terms 저장
        HashMap<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] sdate = privacy[0].split("\\.");
            int[] date = new int[sdate.length];
            
            for (int j = 0; j < sdate.length; j++) {
                date[j] = Integer.parseInt(sdate[j]);
            }
            
            // 파기날짜 계산
            date[1] += map.get(privacy[1]);
            date[0] += date[1] / 12;
            date[1] %= 12;
            
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");         
                Date destroyDate = formatter.parse(date[0] + "." + date[1] + "." + date[2]);   
                Date todayDate = formatter.parse(today);  
            
                // 유효기간이 지났으면 파기
                if (destroyDate.before(todayDate) || destroyDate.equals(todayDate))
                    ans.add(i + 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
