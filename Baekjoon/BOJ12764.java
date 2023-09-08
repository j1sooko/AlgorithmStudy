package BOJ12764;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Person implements Comparable<Person> {
	int p, q; //p: 시작시간, q: 종료시간
	
	public Person(int p, int q) {
		this.p = p;
		this.q = q;
	}

	@Override
	public int compareTo(Person person) {
		if (this.p < person.p) return -1;
		else if (this.p > person.p) return 1;
		return 0;
	}
}

class Computer implements Comparable<Computer> {
	int q, cnt, idx; // q: 종료시간, cnt: 사용한 사람 수, idx: 컴퓨터 번호
	
	public Computer(int q, int cnt, int idx) {
		this.q = q;
		this.cnt = cnt;
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
		
		PriorityQueue<Person> personQueue = new PriorityQueue<>(); // 사람 우선순위 큐: 시작 시간이 빠른 순서대로
		PriorityQueue<Computer> computerQueue = new PriorityQueue<>(); // 컴퓨터 우선순위 큐: 끝나는 시간이 빠른 순서대로
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			personQueue.add(new Person(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		
		int originalIndex = 0;
;		for (int i = 0; i < N; i++) {
			Person person = personQueue.poll();
			// 사용할 수 있는 컴퓨터가 하나도 없는 경우
			if (computerQueue.isEmpty() || (computerQueue.peek().q > person.p)) {
				computerQueue.add(new Computer(person.q, 1, originalIndex++));
						
			} else { // 다른 사람의 사용이 끝나 빈 자리가 있는 경우
				Computer computer = computerQueue.poll();
				int count = computer.cnt + 1;
				int index = computer.idx;
			
				computerQueue.add(new Computer(person.q, count, index));
			}
		}

		// 컴퓨터의 인덱스 기준으로 정렬
		int len = computerQueue.size();
		HashMap<Integer, Integer> rstMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			Computer c = computerQueue.poll();
			rstMap.put(c.idx, c.cnt);
		}
		
		List<Integer> keyList = new ArrayList<>(rstMap.keySet());
		keyList.sort((s1, s2) -> s1.compareTo(s2));
		for (int key: keyList) {
			sb.append(rstMap.get(key) + " ");
		}
		
		// 번호가 작은 경우 고려해야함
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
