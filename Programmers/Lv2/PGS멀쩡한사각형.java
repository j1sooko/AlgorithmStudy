class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long weight = (long) w;
        long height = (long) h;
        
        // 작은 패턴 찾기 -> 최대 공약수 구하기
        long max = 0;
        for (long i = 1; i <= w && i <= h; i++) {
            if (w % i ==  0 && h % i == 0) {
                max = i;
            }
        }
        
        long minw = weight / max;
        long minh = height / max;
        long white = minw * minh - (minw - 1) * (minh - 1);
        answer = (weight * height) - (white * max);
        return answer;
    }
}
