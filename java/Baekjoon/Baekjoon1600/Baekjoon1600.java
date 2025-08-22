import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
	int r;
	int c;
	int j;
	int d;
	
	public Location(int r, int c, int j, int d) {
		this.r = r;
		this.c = c;
		this.j = j;
		this.d = d;
	}
}

class B1600 {

	int k;
	int rSize;
	int cSize;
	boolean[][] map;
	boolean[][][] visited;

	public B1600() throws Exception {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		cSize = Integer.parseInt(st.nextToken());
		rSize = Integer.parseInt(st.nextToken());
		map = new boolean[rSize][cSize];
		visited = new boolean[rSize][cSize][k + 1];
		for (int r = 0; r < rSize; ++r) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < cSize; ++c) {
				map[r][c] = (st.nextToken().equals("0"));
			}
		}
		System.out.print(solve());
	}

	private int solve() {
		Location curr;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int[] ddx = { -2, -2, 2, 2, -1, 1, -1, 1 };
		int[] ddy = { -1, 1, -1, 1, -2, -2, 2, 2 };
		Queue<Location> que = new ArrayDeque<>();

		que.add(new Location(0, 0, 0, 0));
		while (!que.isEmpty()) {
			curr = que.poll();

			if (!visited[curr.r][curr.c][curr.j]) {
				visited[curr.r][curr.c][curr.j] = true;

				if (curr.r == rSize - 1 && curr.c == cSize - 1) {
					return curr.d;
				}

				for (int i = 0; i < 4; ++i) {
					int nextR = curr.r + dx[i];
					int nextC = curr.c + dy[i];

					if (isValidate(nextR, nextC) && map[nextR][nextC]) {
						que.add(new Location(nextR, nextC, curr.j, curr.d + 1));
					}
				}

				for (int i = 0; i < 8; ++i) {
					int nextR = curr.r + ddx[i];
					int nextC = curr.c + ddy[i];

					if (isValidate(nextR, nextC) && map[nextR][nextC] && curr.j < k) {
						que.add(new Location(nextR, nextC, curr.j + 1, curr.d + 1));
					}
				}
			}
		}
		return -1;
	}

	private boolean isValidate(int r, int c) {
		return (0 <= r && r < rSize) && (0 <= c && c < cSize);
	}

}

public class Baekjoon1600 {

	public static void main(String[] args) throws Exception {
		new B1600();
	}

}
