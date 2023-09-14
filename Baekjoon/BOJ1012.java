
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static boolean[][] visited;
	static int[][] field;
    static int count;
    static int M, N;

	static void dfs(int x, int y) { 
        // 방문 표시
        visited[x][y] = true;

        // 상하좌우 체크를 위한 배열
		int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // 상하좌우 체크
        for (int i = 0; i < 4; i++) {
            int vx = x + dx[i];
            int vy = y + dy[i];

            if (vx >= 0 && vx < M && vy >= 0 && vy < N) {    // 배추밭 밖으로 나가지 않고
                if (!visited[vx][vy] && field[vx][vy] == 1) {    // 배추가 심어져 있고, 방문하지 않았다면 탐색
                    dfs(vx, vy);
                }
            }
        }

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]); // 배추밭의 가로길이
			N = Integer.parseInt(input[1]); // 배추밭의 세로길이
			int K = Integer.parseInt(input[2]); // 배추가 심어진 위치개수
			

			field = new int[M][N]; 
            count = 0;
            // 방문 여부 체크
			visited = new boolean[M][N];
			
			// 인접행렬
			for (int i = 0; i < K; i++) {
				input = br.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				field[x][y] = 1;
			}

            // 인접행렬 dfs 탐색
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && field[i][j] == 1) { // 배추가 심어져있고, 방문하지 않았다면 탐색
                        dfs(i, j);
                        count++; // 새로 탐색을 시작할 때마다 지렁이 수 증가
                    }
                }
            }

            System.out.println(count);
		}
        br.close();
	}

}
