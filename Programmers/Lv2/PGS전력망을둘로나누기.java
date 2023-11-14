import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> tree;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        // tree 노드 추가. 무방향 그래프
        for (int i = 0; i < wires.length; i++) {
            tree.get(wires[i][0]).add(wires[i][1]);
            tree.get(wires[i][1]).add(wires[i][0]);
        }
        
        // bfs로 완전탐색하며 전선을 하나씩 끊어봄
        for (int i = 0; i < wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];
            
            // 전선 끊기
            tree.get(s).remove(Integer.valueOf(e));
            tree.get(e).remove(Integer.valueOf(s));
            
            // bfs
            answer = Math.min(bfs(n, s), answer);
            
            // 전선 되돌리기
            tree.get(s).add(e);
            tree.get(e).add(s);
        }
        
        return answer;
    }
    
    public int bfs(int n, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer w : tree.get(v)) {
                if (!visited[w]) {
                    visited[w] = true;
                    cnt++;
                    queue.offer(w);
                }
            }
        }
        
        // 두 네트워크의 송전탑 개수 비교
        return Math.abs(cnt - (n - cnt));
    }
}
