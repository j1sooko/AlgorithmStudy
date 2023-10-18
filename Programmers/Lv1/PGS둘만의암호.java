class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (char c : s.toCharArray()) {
            for (int i = 0; i < index; i++) {
                c += 1;
                // 'z' 다음 문자면 다시 'a'로
                if (c > 'z')
                    c -= ('z' - 'a' + 1);
                
                // skip의 문자가 있다면 다시 검사
                if (skip.contains(Character.toString(c)))
                    i--;
            }
            answer += c;
        }
    
        return answer;
    }
}
