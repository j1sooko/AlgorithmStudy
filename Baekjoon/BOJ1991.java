package BOJ1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node {
	char key;
	Node left, right;
	
	public Node(char key) {
		this.key = key;
	}
}


public class Main {
	
	public static String preorder(Node node) {
		String result = "";
		result += node.key;
		if (node.left != null)
			result += preorder(node.left);
		if (node.right != null)
			result += preorder(node.right);
		return result;

	}
	
	public static String inorder(Node node) {
		String result = "";
		if (node.left != null)
			result += inorder(node.left);
		result += node.key;
		if (node.right != null)
			result += inorder(node.right);
		return result;

	}
	
	public static String postorder(Node node) {
		String result = "";
		if (node.left != null)
			result += postorder(node.left);
		if (node.right != null)
			result += postorder(node.right);
		result += node.key;
		return result;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		char root = 'A';
		Node[] tree = new Node[N];
		for (int i = 0; i < N; i++) // key가 'A', 'B', 'C' ... 가 되도록 Node 배열 생성
			tree[i] = new Node(root++);
		
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			if (!input[1].equals(".")) // Node의 left에 해당하는 Node 입력
				tree[input[0].charAt(0) - 65].left = tree[input[1].charAt(0) - 65];
			else 
				tree[input[0].charAt(0) - 65].left = null;
			if (!input[2].equals(".")) // Node의 right에 해당하는 Node 입력
				tree[input[0].charAt(0) - 65].right = tree[input[2].charAt(0) - 65];
			else 
				tree[input[0].charAt(0) - 65].right = null;
		}	
		
		sb.append(preorder(tree[0]) + "\n");
		sb.append(inorder(tree[0]) + "\n");
		sb.append(postorder(tree[0]) + "\n");
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

}
