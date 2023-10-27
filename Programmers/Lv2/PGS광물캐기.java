class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        mine(picks, minerals, 0, 0);
        return answer;
    }
    
    // 백트래킹
    void mine(int[] picks, String[] minerals, int sum, int index) {
        // 돌을 다 캐거나 곡괭이를 다 쓰면 min과 비교
        boolean allPickUsed = true;
        for (int p : picks) {
            if (p != 0) {
                allPickUsed = false;
                break;
            }
        }
        
        if (index == minerals.length || allPickUsed) {
            answer = Math.min(answer, sum);
            return;
        }
        
        
        // 곡괭이를 하나씩 선택
        for (int i = 0; i < picks.length; i++) {
            int newSum = sum;
            // 선택한 곡괭이가 없으면 continue
            if (picks[i] == 0) continue;
            
            // 선택한 곡괭이로 광물 5개 캐기
            int end = (index + 5 > minerals.length) ? minerals.length : index + 5;
            int damage = 1;
            for (int j = index; j < end; j++) {
               switch (i) {
                   case 0:
                       damage = 1;
                       break;
                    case 1:
                        if (minerals[j].equals("diamond"))
                            damage = 5;
                        else
                            damage = 1;
                        break;
                    case 2:
                       if (minerals[j].equals("diamond"))
                            damage = 25;
                       else if (minerals[j].equals("iron"))
                            damage = 5;
                       else
                           damage = 1;
                        break;
                } 
                newSum += damage;
            }
            
            // 다음 곡괭이 선택
            picks[i]--;
            mine(picks, minerals, newSum, end);
            picks[i]++;
            
            
        }
        
    }
}
