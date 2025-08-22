import java.io.*;
import java.util.*;

class Location {
    int x, y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Problem {
    int n, m;
    int[][] map;
    boolean[][] visited;
    int[] dx = {-1,1,0,0,-1,-1,1,1};
    int[] dy = {0,0,-1,1,-1,1,-1,1};
    
    public Problem(String n, String m) {
        this.n = Integer.parseInt(n);
        this.m = Integer.parseInt(m);
        map = new int[this.n][this.m];
        visited = new boolean[this.n][this.m];
    }
    public int solve() {
        int cnt = 0;
        for(int x = 0; x < n; ++x) {
            for(int y = 0; y < m; ++y) {
                if(!visited[x][y] && BFS(x, y)) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
    private boolean BFS(int x, int y) {
        boolean flag = true;
        Location curr;
        Stack<Location> stack = new Stack<>();
        stack.add(new Location(x,y));

        while(!stack.isEmpty()) {
            curr = stack.pop();

            if(!visited[curr.x][curr.y]) {
                visited[curr.x][curr.y] = true;
                
                for(int i = 0; i < 8; ++i) {
                    int nextX = curr.x + dx[i];
                    int nextY = curr.y + dy[i];
                    if(isValidate(nextX, nextY)) {
                        if(map[curr.x][curr.y] == map[nextX][nextY]) {
                            stack.add(new Location(nextX, nextY));
                        } else if(map[curr.x][curr.y] < map[nextX][nextY]) {
                            flag = false;
                        }
                    }
                }
            }
        }
        return flag;
    }
    private boolean isValidate(int x, int y) {
        return( 0 <= x && x < n
                &&
                0 <= y && y < m
        );
    }
}

public class Baekjoon1245 {
	static public void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(st.nextToken(), st.nextToken());

        for(int i = 0; i < problem.n; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < problem.m; ++j) {
                problem.map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(problem.solve());
    }
}
