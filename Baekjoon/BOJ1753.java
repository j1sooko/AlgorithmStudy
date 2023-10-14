import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

	public static class Node implements Comparable<Node> {
		int idx;
		int weight;
		
		Node (int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}
	}
	
	public static void Dijkstra(int start, int V) {
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		//우선순위 큐
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		// 시작값 초기화
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int idx = node.idx;
			int weight = node.weight;
			
			if (weight > dist[idx]) // 우선순위큐는 오름차순 정렬되기 때문에 이전에 방문된 노드라는 뜻
				continue;
			
			for (Node linkedNode : graph.get(idx)) {
				if (dist[linkedNode.idx] > weight + linkedNode.weight) {
					// 최단거리 정보 갱신
					dist[linkedNode.idx] = weight + linkedNode.weight;
					// 갱신된 노드를 우선순위큐에 추가
					pq.add(new Node(linkedNode.idx, dist[linkedNode.idx]));
				}
			}
			
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 시작 정점 번호
		
		// 그래프 초기화
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		Dijkstra(K, V);
		
		br.close();
	}

}
