class Solution {
    public static int maxSubscriber = 0;
    public static int maxSalesAmount = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer;
        
        // 1. 플러스 가입자 최대
        // 2. 이모티콘 판매액 최대
        // 할인율: 10, 20, 30, 40
        
        int[] discount = {40, 30, 20, 10};
        int[] emoticonsRate = new int[emoticons.length];
        
        // 할인율을 모두 적용시켜보기 : 완전 탐색
        dfs(users, emoticons, 0, discount, emoticonsRate);
        answer = new int[] {maxSubscriber, maxSalesAmount};
        return answer;
    }
    
    public void dfs(int[][] users, int[] emoticons, int idx, int[] discount, int[] emoticonsRate) {
        if (idx == emoticons.length) {
            // max 값 update
            calcResult(users, emoticons, emoticonsRate);
            return;
        }
        
        for (int i : discount) {
            emoticonsRate[idx] = i;
            dfs(users, emoticons, idx + 1, discount, emoticonsRate);
        }
    }
    
    public void calcResult(int[][] users, int[] emoticons, int[] emoticonsRate) {
        // 이모티콘 가격 = 각 이모티콘의 할인율 * 이모티콘 가격
        // 이모티콘 구매 비용: 각 가격을 더함
        // 이모티콘 가입자 수: users의 가격 <= 구매 비용 이면 cnt++;
        
        int amount = 0; // 총 판매액
        int cnt = 0; // 가입자 수
        
        for (int[] user : users) {
            // 해당 사용자의 이모티콘 구매 할인율 <= 해당 이모티콘의 할인율일 경우만
            // 이모티콘 구매비용(해당 이모티콘 가격 * (100 -해당 이모티콘 할인율 ) / 100 계산
            // 이모티콘 구매 비용이 가격을 넘기지 않으면
            // 판매액 += 이모티콘 구매 비용
            // 넘긴다면 cnt++;
            int sum = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (user[0] <= emoticonsRate[i]) {
                    sum += emoticons[i] * (100 - emoticonsRate[i]) / 100;
                    
                }
                if (sum >= user[1]) {
                    cnt++;
                    sum = 0;
                    break;
                }
            }
            amount += sum;
        }
        
        if (maxSubscriber < cnt) {
            maxSubscriber = cnt;
            maxSalesAmount = amount;
        }
        else if (maxSubscriber == cnt)
            maxSalesAmount = Math.max(maxSalesAmount, amount);
    }
}
