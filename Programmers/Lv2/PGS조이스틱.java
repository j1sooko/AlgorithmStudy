class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1; // 좌우 이동 횟수
        
        // 모든 문자열을 검사
        for (int i = 0; i < len; i++) {
            // 상하 움직임 수 체크
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            
            // 좌우 움직임 수 체크
            // - 다음 문자가 A가 아닐 경우 -> 순서대로 간다
            // - 다음 문자열에 A가 1개 이상 있을 경우 -> 순서대로 vs 거꾸로
            // 1. A의 개수 체크
            int idx = i + 1; // 현재 문자 다음부터 검사
            while (idx < len && name.charAt(idx) == 'A') {
                idx++;
            } // 최종적으로 idx는 바꿔야할 다음 문자를 가리킴
            
            // 2. 순서대로 가는 경우, 거꾸로 가는 경우 중 작은 값 선택
            // (i + i) : 온 만큼 + 되돌아감, (len - idx) : 뒤에서 다음 문자열까지
            move = Math.min(move, i * 2 + len - idx);
            
            // 3. 처음부터 거꾸로 거꾸로 가는 것이 나은 경우
            // (len - idx) : 뒤에서 다음 문자열까지의 거리만큼 가기 + 처음 문자열로 돌아오기
            // i : A 문자열이 있기 전만큼
            move = Math.min(move, (len - idx) * 2 + i);
            
            
        }
        return answer + move;
    }
}
