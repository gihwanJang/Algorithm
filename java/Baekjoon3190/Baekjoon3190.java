import java.io.*;
import java.util.*;

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Move {
    int time;
    int direction;

    public Move(String t, String d) {
        this.time = Integer.parseInt(t);
        this.direction = convert(d);
    }

    private int convert(String d) {
        if (d.equals("D")) {
            return 1;
        }
        return -1;
    }
}

class Problem {
    int n;
    int dir;
    int[][] map;
    Move[] movement;
    Queue<Location> body;

    final int[] dx = {0,1,0,-1};
    final int[] dy = {1,0,-1,0};

    public Problem(int n) {
        this.n = n;
        this.dir = 0;
        this.map = new int[n][n];
        this.body = new ArrayDeque<>();
    }

    public int solve() {
        int time = 0;
        Location curr = new Location(0, 0);

        body.add(curr);
        for (int i = 0; isValidate(curr.x, curr.y); ++time) {
            if (map[curr.x][curr.y] == 0) {
                map[body.peek().x][body.peek().y] = 0;
                body.poll();
            }
            if (i < movement.length && movement[i].time == time) {
                dir = (dir + 4 + movement[i++].direction) % 4;
            }
            body.add(new Location(curr.x, curr.y));
            map[curr.x][curr.y] = 1;
            curr.x += dx[dir];
            curr.y += dy[dir];
        }
        return time;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < n
                &&
                0 <= c && c < n
                &&
                map[r][c] != 1);
    }
}

public class Baekjoon3190 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));

        for (int i = Integer.parseInt(br.readLine()); i > 0; --i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p.map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
        }
        p.movement = new Move[Integer.parseInt(br.readLine())];
        for (int i = 0; i < p.movement.length; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p.movement[i] = new Move(st.nextToken(), st.nextToken());
        }
        System.out.println(p.solve());
    }
}
