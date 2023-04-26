import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1260 {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph;
    public static ArrayList<Integer> dfs_result = new ArrayList<>();
    public static ArrayList<Integer> bfs_result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int n, m, v; //n: 정점 갯수, m: 간선 갯수, v: 시작 번호

        String[] nmv = br.readLine().split(" ");
        n = Integer.parseInt(nmv[0]);
        m = Integer.parseInt(nmv[1]);
        v = Integer.parseInt(nmv[2]);

        //인접 리스트
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] nv = br.readLine().split(" ");
            int n1 = Integer.parseInt(nv[0]);
            int n2 = Integer.parseInt(nv[1]);

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        //인접 리스트 정렬
        for (ArrayList<Integer> g : graph) {
            Collections.sort(g);
        }

        //1번 인접리스트부터 n번 인접리스트까지 출력
        /* 
        for (int i = 1; i <= n; i++) {
            bw.write(graph.get(i).toString());
        }
        */

        //dfs
        visited = new boolean[n];
        dfs(v);
        for (Integer integer : dfs_result) {
            bw.write(integer.toString() + " ");
        }
        bw.write("\n");
        
        //bfs
        visited = new boolean[n];
        bfs(v);
        for (Integer integer : bfs_result) {
            bw.write(integer.toString() + " ");
        }

        
        bw.flush();
        bw.close();
    }

    public static void dfs(int v)
    {
        // 방문한 정점 표시
        visited[v - 1] = true;
        dfs_result.add(v);

        //인접 정점 탐색
        for (Integer w : graph.get(v)) {
            if (!visited[w - 1]) {
                dfs(w);
            }
        }

        return;
    }

    public static void bfs(int v)
    {
        Queue<Integer> queue = new LinkedList<>();
        // 방문한 정점 표시
        visited[v - 1] = true;
        bfs_result.add(v);

        queue.offer(v); //시작 정점을 큐에 저장
        while (!queue.isEmpty()) {
            v = queue.poll();
            // 인접 정점 탐색
            for (Integer w : graph.get(v)) {
                if (!visited[w - 1]) {
                    visited[w - 1] = true;
                    // 방문한 정점 표시
                    visited[w - 1] = true;
                    bfs_result.add(w);
                    queue.offer(w); // 정점을 큐에 저장
                }
            }
        }
        
    }
}
