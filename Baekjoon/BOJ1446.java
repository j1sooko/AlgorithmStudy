import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	// 지름길 정보 저장
	public static ArrayList<Node> graph;
	public static int D;
			
	public static class Node {
		int s;
		int e;
		int weight;
		
		Node(int s, int e, int weight) {
			this.s = s;
			this.e = e;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		// 그래프 초기화
		int N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
//		
		// 지름길 삽입
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			
			// if 도착 위치 > 목적지 위치 then 지름길 아님(역주행x)
			if (e > D)
				continue;
			// if 도작 위치 - 시작 위치 >= 지름길 길이 then 삽입하지 않음
			if (e - s > len) {
				graph.add(new Node(s, e, len));
			}
		}
		
		Collections.sort(graph, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				if (n1.s == n2.s) return n1.e - n2.e;
				return n1.s - n2.s;
			}
		});

		dijkstra(0);
		
	}
	
	public static void dijkstra(int start) {
		int[] dist = new int[D + 1];
		
		// dist 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 시작 노드 초기화
		dist[start] = 0;
		int move = 0; // 현재 계산하고 있는 위치
		int nodeIdx = 0;
		
		while (move < D) {
			if (nodeIdx < graph.size()) {
				// 지름길을 하나씩 꺼내며 검사
				Node node = graph.get(nodeIdx);
				if (move == node.s) { // 현재 위치(move)가 지름길의 시작 위치인 경우, 도착 위치 최단길이 갱신
					// e로 가는 최단 거리 = s로 가는 최단 거리 + 현재 선택한 지름길 거리 vs 기존 e로 가는 최단거리 
					dist[node.e] = Math.min(dist[node.s] + node.weight, dist[node.e]);
					// 다음 지름길 선택
					nodeIdx++;
				} else {
					// 현재 위치(move) != 지름길의 시작 위치인 경우,
					// dist[move + 1], dist[move] + 1 둘 중 하나가 지름길의 끝 위치일 경우 갱신 됨 -> 뒤따른 위치들도 따라서 갱신됨
					dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
					move++;
					
				}
			} else {
				// 지름길을 다 꺼내면 나머지 값 계산
				dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
				move++;
			}
			
		}
		
		System.out.print(dist[D]);
		
	}
	

}	
