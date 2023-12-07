import java.io.*;
import java.util.*;

class Location implements Comparable<Location> {
    int r, c, cnt;

    public Location(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Location o) {
        return cnt - o.cnt;
    }
}

class Problem {
    int n, m;
    int[][] map, distance;

    public Problem(int m, int n) {
        this.n = n;
        this.m = m;
        map = new int[n][m];
        distance = new int[n][m];
        for(int i = 0; i < n; ++i) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
    }

    public int solve() {
        escapeMaze();
        return distance[n-1][m-1];
    }

    private void escapeMaze() {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Location curr = new Location(0, 0, 0);
        PriorityQueue<Location> pq = new PriorityQueue<>();
        pq.add(curr);

        while(!pq.isEmpty()) {
            curr = pq.poll();

            if(curr.cnt < distance[curr.r][curr.c]) {
                distance[curr.r][curr.c] = curr.cnt;

                for(int i = 0; i < 4; ++i) {
                    int nextR = curr.r + dx[i];
                    int nextC = curr.c + dy[i];
                    if(isValidate(nextR, nextC)) {
                        int nextCount = curr.cnt + map[nextR][nextC];
                        pq.add(new Location(nextR, nextC, nextCount));
                    }
                }
            }
        }
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < n
                &&
                0 <= c && c <m);
    }
}

public class Baekjoon1261 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int i = 0; i < problem.n; ++i) {
            String row = br.readLine();

            for(int j = 0; j < problem.m; ++j) {
                if(row.charAt(j) == '1') {
                    problem.map[i][j] = 1;
                } 
            }
        }

        System.out.println(problem.solve());
    }
}
