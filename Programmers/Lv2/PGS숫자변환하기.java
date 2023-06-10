import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PGS숫자변환하기 {
	
	public static int solution(int x, int y, int n) { //bfs
        int answer = 0;
        int[] dist = new int[1000001];
        Queue<Integer> queue = new LinkedList<>();
        
        dist[x] = 1;
        queue.add(x);
        while (!queue.isEmpty()) {
        	x = queue.poll();
        	
        	if (x + n <= 1000000 && dist[x + n] == 0) {
        		queue.add(x + n);
        		dist[x + n] = dist[x] + 1;
        	}
        	
        	if (x * 2 <= 1000000 && dist[x * 2] == 0) {
        		queue.add(x * 2);
        		dist[x * 2] = dist[x] + 1;
        	}
        	
        	if (x * 3 <= 1000000 && dist[x * 3] == 0) {
        		queue.add(x * 3);
        		dist[x * 3] = dist[x] + 1;
        	}
       
        }
        answer = dist[y] - 1;
        return answer;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(solution(x, y, n));
		
		sc.close();
	}

}
