import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

class Location {
    int r, c;
    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Problem {
    int n;
    int[][] map;
    boolean[][] visited;
    PriorityQueue<Integer> pq;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public Problem(int n) {
        this.n = n;
        map = new int[n][n];
        visited = new boolean[n][n];
        pq = new PriorityQueue<>();
    }
    public void setMap(int r, String val) {
        for(int c = 0; c < n; ++c)
            map[r][c] = val.charAt(c) - '0';
    }
    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int r = 0; r < n; ++r)
            for(int c = 0; c < n; ++c)
                if(map[r][c] == 1 && !visited[r][c])
                    travle(r, c);

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        return sb.toString();
    }

    private void travle(int r, int c) {
        int cnt = 0;
        Location curr = new Location(r, c);
        Queue<Location> que = new ArrayDeque<>();

        que.add(curr);
        while(!que.isEmpty()) {
            curr = que.poll();

            if(!visited[curr.r][curr.c]) {
                visited[curr.r][curr.c] = true;
                ++cnt;

                for(int i = 0; i < 4; ++i) {
                    int nextR = curr.r + dx[i];
                    int nextC = curr.c + dy[i];
                    if(isValidate(nextR, nextC) && map[nextR][nextC] == 1) {
                        que.add(new Location(nextR, nextC));
                    }
                }
            }
        }

        pq.add(cnt);
    }
    private boolean isValidate(int r, int c) {
        return (
            0 <= r && r < n
            &&
            0 <= c && c < n
        );
    }
}

public class D {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Problem problem = new Problem(Integer.parseInt(br.readLine()));

        for(int i = 0; i < problem.n; ++i) {
            problem.setMap(i, br.readLine());
        }

        System.out.println(problem.solve());
	}
}