import java.io.*;
import java.util.*;

class Location {
    int x,y,d,c;
    public Location(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.c = 0;
    }
    public Location(int x, int y, int d, int c) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.c = c;
    }
}

class Problem {
    int n, m;
    BitSet[] map;
    BitSet[][] visited;
    Location start, end;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public Problem(int n, int m) {
        this.n = n;
        this.m = m;
        map = new BitSet[n];
        visited = new BitSet[n][m];
        for(int i = 0; i < n; ++i) {
            map[i] = new BitSet(m);
        }
        for(int r = 0; r < n; ++r) {
            for(int c = 0; c < m; ++c) {
                visited[r][c] = new BitSet(4);
            }
        }
    }
    public int solve() {
        Location curr;
        Queue<Location> que =new ArrayDeque<>();
        que.add(start);
        visited[start.x][start.y].set(start.d);

        while(!que.isEmpty()) {
            curr = que.poll();
            if(isExit(curr)) {
                return curr.c;
            }
            step(que, curr);
            changeDirection(que, curr);
        }

        return -1;
    }

    private void changeDirection(Queue<Location> que, Location curr) {
        if(curr.d == 0 || curr.d == 1) {
            if(!visited[curr.x][curr.y].get(2)) {
                que.add(new Location(curr.x, curr.y, 2, curr.c + 1));
                visited[curr.x][curr.y].set(2);
            }
            if(!visited[curr.x][curr.y].get(3)) {
                que.add(new Location(curr.x, curr.y, 3, curr.c + 1));
                visited[curr.x][curr.y].set(3);
            }
        } else {
            if(!visited[curr.x][curr.y].get(0)) {
                que.add(new Location(curr.x, curr.y, 0, curr.c + 1));
                visited[curr.x][curr.y].set(0);
            }
            if(!visited[curr.x][curr.y].get(1)) {
                que.add(new Location(curr.x, curr.y, 1, curr.c + 1));
                visited[curr.x][curr.y].set(1);
            }
        }
    }
    private void step(Queue<Location> que, Location curr) {
        for(int i = 1; i < 4; ++i) {
            int nextX = curr.x + dx[curr.d] * i;
            int nextY = curr.y + dy[curr.d] * i;
            if(!isValidate(nextX, nextY)) {
                return;
            }
            if(!visited[nextX][nextY].get(curr.d)) {
                que.add(new Location(nextX, nextY, curr.d, curr.c + 1));
                visited[nextX][nextY].set(curr.d);
            }
        }
    }
    private boolean isExit(Location loc) {
        return(loc.x == end.x && loc.y == end.y && loc.d == end.d);
    }
    private boolean isValidate(int x, int y) {
        return (0 <= x && x < n
                &&
                0 <= y && y < m
                &&
                map[x].get(y));
    }
}

public class Baekjoon1726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        for(int r = 0; r < p.n; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < p.m; ++c) {
                if(st.nextToken().equals("0")) {
                    p.map[r].set(c);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        p.start = new Location(
                Integer.parseInt(st.nextToken())-1, 
                Integer.parseInt(st.nextToken())-1, 
                Integer.parseInt(st.nextToken())-1);
        st = new StringTokenizer(br.readLine());
        p.end = new Location(
                Integer.parseInt(st.nextToken())-1, 
                Integer.parseInt(st.nextToken())-1, 
                Integer.parseInt(st.nextToken())-1);

        System.out.println(p.solve());
    }
}
