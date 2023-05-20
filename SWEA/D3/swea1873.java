import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea1873 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
//			System.out.println("testcase: " + test_case);
			String[] input = br.readLine().split(" ");
			int H = Integer.parseInt(input[0]);
			int W = Integer.parseInt(input[1]);

			String[][] map = new String[H][W];
			int x = -1, y = -1; // 전차 위치

			for (int i = 0; i < H; i++) {
				input = br.readLine().split("");
				for (int j = 0; j < W; j++) {
					map[i][j] = input[j];
					if (map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<")
							|| map[i][j].equals(">")) { // 전차 위치 기록
						x = j;
						y = i;
					}

				}
			}

			int N = Integer.parseInt(br.readLine());
			String cmd = br.readLine();

			for (char c : cmd.toCharArray()) {
				switch (c) {
				case 'U':
					map[y][x] = "^";
					if (y > 0 && map[y - 1][x].equals(".")) {
						map[y - 1][x] = "^";
						map[y][x] = ".";
						y--;
					}
					break;
				case 'D':
					map[y][x] = "v";
					if (y < H - 1 && map[y + 1][x].equals(".")) {
						map[y + 1][x] = "v";
						map[y][x] = ".";
						y++;
					}
					break;
				case 'L':
					map[y][x] = "<";
					if (x > 0 && map[y][x - 1].equals(".")) {
						map[y][x - 1] = "<";
						map[y][x] = ".";
						x--;
					}
					break;
				case 'R':
					map[y][x] = ">";
					if (x < W - 1 && map[y][x + 1].equals(".")) {
						map[y][x + 1] = ">";
						map[y][x] = ".";
						x++;
					}
					break;
				case 'S':
					int i = 0, j = 0;
					boolean stop = false;
					do {
						if (map[y][x].equals("^"))
							i--;
						else if (map[y][x].equals("v"))
							i++;
						else if (map[y][x].equals("<"))
							j--;
						else if (map[y][x].equals(">"))
							j++;

						if ((y + i < 0 || y + i > H - 1 || x + j < 0 || x + j > W - 1)
								|| map[y + i][x + j].equals("#")) {
							stop = true;
							break;
						} else if (map[y + i][x + j].equals("*")) {
							map[y + i][x + j] = ".";
							stop = true;
							break;
						}

					} while (!stop);
					break;
				}
			}

			sb.append("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}
}
