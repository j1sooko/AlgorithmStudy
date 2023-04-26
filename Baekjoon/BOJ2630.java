import java.util.Scanner;

public class BOJ2630 {

    public static int w;
    public static int b;
    public static int[][] board;
    public static void partition(int x, int y, int n) {
        // 배열의 모든 원소를 합산하여 모두 0이거나 n * n이면 흰색 또는 파란색 종이 수 +1
        int sum = 0;
        for (int i = x; i < x + n; i++) { //범위 주의
            for (int j = y; j < y + n; j++) {
                sum += board[i][j];
            }
        }

        if (sum == 0) {
            w++;
        } else if (sum == n * n) {
            b++;
        } else {
            //배열을 4분할
            partition(x, y, n / 2);
            partition(x + n / 2, y, n / 2);
            partition(x, y + n / 2, n / 2);
            partition(x + n / 2, y + n / 2, n / 2);
        }

        return;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        board = new int[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        partition(0, 0, n);
        
        System.out.println(w);
        System.out.println(b);

        sc.close();
    }
}
