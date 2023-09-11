package BOJ12764;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class User implements Comparable<User> {
	int p, q; //p: 시작시간, q: 종료시간
	
	public User(int p, int q) {
		this.p = p;
		this.q = q;
	}

	@Override
	public int compareTo(User user) {
		if (this.p < user.p) return -1;
		else if (this.p > user.p) return 1;
		return 0;
	}
}

class Computer implements Comparable<Computer> {
	int q, cnt, idx; // q: 종료시간, idx: 컴퓨터 번호
	
	public Computer(int q, int idx) {
		this.q = q;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(Computer computer) {
		if (this.q < computer.q) return -1;
		else if (this.q > computer.q) return 1;
		return 0;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<User> UserQueue = new PriorityQueue<>(); // 사람 우선순위 큐: 시작 시간이 빠른 순서대로
		PriorityQueue<Computer> computerQueue = new PriorityQueue<>(); // 사용중인 컴퓨터 우선순위 큐: 끝나는 시간이 빠른 순서대로
		PriorityQueue<Integer> nextComQueue = new PriorityQueue<>(); // 사용 가능한 컴퓨터 우선순위 큐: 컴퓨터 번호가 작은 순서대로 번호를 담음
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			UserQueue.add(new User(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		
		int[] comCnt = new int[100001];
		int originalIndex = 0;
;		for (int i = 0; i < N; i++) {
			// 사용 시간이 빠른 사용자부터	
			User user = UserQueue.poll();
			
			// nextComQueue.add()
			// 사용중인 컴퓨터들 중 (사용자의 시작시간 > 컴퓨터 사용 종료시간)인 컴퓨터를 사용가능 대기열에 모두 추가
			while (!computerQueue.isEmpty() && user.p > computerQueue.peek().q) {
				nextComQueue.add(computerQueue.poll().idx);
			}
		
			// computerQueue.add()
			if (nextComQueue.isEmpty()) { // 사용가능한 컴퓨터가 없음
				computerQueue.add(new Computer(user.q,  originalIndex)); // 컴퓨터 추가
				comCnt[originalIndex]++;
				originalIndex++;
			}
			else { //사용가능한 컴퓨터 중 번호가 작은 것 먼저 사용, 컴퓨터 사용열에 추가
				computerQueue.add(new Computer(user.q, nextComQueue.peek()));
				comCnt[nextComQueue.poll()]++;
			}
		}
		
		sb.append(originalIndex + "\n");
		for (int i = 0; i < originalIndex; i++) {
			sb.append(comCnt[i] + " ");
		}
		
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
