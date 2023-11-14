import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // 2차원 배열로 park 생성
        char[][] board = new char[park.length][park[0].length()];
        int sw = 0, sh = 0;
        
         for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                board[i][j] = park[i].charAt(j);
                if (board[i][j] == 'S') {
                    sh = i;
                    sw = j;
                }
            }
        }
        
        int h = sh;
        int w = sw;
        
        for (int i = 0; i < routes.length; i++) {
            char direction = routes[i].charAt(0);
            int move = routes[i].charAt(2) - '0';

            int tmph = h;
            int tmpw = w;
            
            boolean possible = true;
            for (int j = 0; j < move; j++) {
                switch (direction) {
                case 'N':
                    if (movable(h - 1, w, board))
                        h -= 1; 
                    else {
                        possible = false;
                        break;
                    }
                            
                    break;
                case 'S':
                    if (movable(h + 1, w, board))
                        h += 1;
                    else {
                        possible = false;
                        break;
                    }
                    break;
                case 'W':
                    if (movable(h, w - 1, board))
                        w -= 1;
                    else {
                        possible = false;
                        break;
                    }
                    break;
                case 'E':
                    if (movable(h, w + 1, board))
                        w += 1;
                    else {
                        possible = false;
                        break;
                    }
                    break;
                }
                
                if (!possible) {
                    h = tmph;
                    w = tmpw;
                }
            }
        }
        
        answer[0] = h;
        answer[1] = w;
        
        return answer;
    }
    
    public boolean movable(int h, int w, char[][] board) {
        int height = board.length;
        int width = board[0].length;
        // 공원을 벗어나는 지 확인
        if (h < 0 || h >= height || w < 0 || w >= width) {
            return false;
        }
        
        // 장애물을 만나는지 확인
        if (board[h][w] == 'X')
            return false;
        return true;
    }
}
