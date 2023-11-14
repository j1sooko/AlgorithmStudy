class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
    
        int[][] m = triangle;
        for (int i = 1; i < triangle.length; i++) {
            m[i] = triangle[i].clone();
        }
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) { // 왼쪽 변
                    m[i][j] += m[i - 1][j];
                }
                else if (j == i) { // 오른쪽 변
                    m[i][j] += m[i - 1][j - 1];
                }
                else { // 왼쪽 부모와 오른쪽 부모 중 더 큰 값 선택
                    m[i][j] += Math.max(m[i - 1][j - 1], m[i - 1][j]);
                }
            }
        }
    
        answer = m[0][0];
        
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                answer = Math.max(answer, m[i][j]);
            }
        }
        
        return answer;
    }
}
