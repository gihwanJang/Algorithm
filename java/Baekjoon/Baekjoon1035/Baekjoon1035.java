import java.io.*;
import java.util.*;

class Point {
    private int r;
    private int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return p.getR() == r && p.getC() == c;
    }

    @Override
    public int hashCode() {
        return r * 31 + c;
    }
}

class Problem {
    private static final int[] dr = {-1,1,0,0};
    private static final int[] dc = {0,0,-1,1};

    private int cnt;
    private int start;
    private boolean[] visited;
    private boolean[] connect;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        start = 0;
        connect = new boolean[25];
        visited = new boolean[(1 << 26) -1];
        for (int r = 0; r < 5; ++r) {
            String line = br.readLine();

            for (int c = 0; c < 5; ++c) {
                if (line.charAt(c) == '*') {
                    start |= (1 << (r * 5 + c));
                    ++cnt;
                }
            }
        }
    }

    private void output() {
        System.out.println(BFS());
    }

    private int BFS() {
        int[] curr;
        Queue<int[]> que = new ArrayDeque<>();

        visited[start] = true;
        que.add(new int[]{0, start});
        while (!que.isEmpty()) {
            int pR = 0;
            int pC = 0;
            curr = que.poll();

            for (int r = 0; r < 5; ++r) {
                for (int c = 0; c < 5; ++c) {
                    if ((curr[1] & (1 << (r * 5 + c))) != 0) {
                        pR = r;
                        pC = c;

                        for (int i = 0; i < 4; ++i) {
                            int nextMap = move(curr[1], r, c, i);
                            if (nextMap != -1) {
                                visited[nextMap] = true;
                                que.add(new int[]{curr[0] + 1, nextMap});
                            }
                        }
                    }
                }
            }

            if (isConnected(pR, pC, curr[1])) {
                return curr[0];
            }
        }
        return -1;
    }

    private int move(int map, int r, int c, int dir) {
        int nextR = r + dr[dir];
        int nextC = c + dc[dir];
        int nextMap = (map - (1 << (r * 5 + c))) | 1 << (nextR * 5 + nextC);

        if (isValidate(nextR, nextC) 
            && (map & 1 << (nextR * 5 + nextC)) == 0
            && !visited[nextMap]) {
            return nextMap;
        }
        return -1;
    }

    private boolean isConnected(int r, int c, int map) {
        Point curr;
        int count = 0;
        Queue<Point> que = new ArrayDeque<>();
        Arrays.fill(connect, false);

        connect[r * 5 + c] = true;
        que.add(new Point(r, c));
        while (!que.isEmpty()) {
            ++count;
            curr = que.poll();

            for (int i = 0; i < 4; ++i) {
                int nextR = curr.getR() + dr[i];
                int nextC = curr.getC() + dc[i];

                if (isValidate(nextR, nextC) 
                    && (map & 1 << (nextR * 5 + nextC)) != 0 
                    && !connect[nextR * 5 + nextC]) {

                    connect[nextR * 5 + nextC] = true;
                    que.add(new Point(nextR, nextC));
                }
            }
        }
        return (count == cnt);
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < 5
                &&
                0 <= c && c < 5);
    }

    private void print(int map) {
        for (int r = 0; r < 5; ++r) {
            for (int c = 0; c < 5; ++c) {
                System.out.print((map & (1 << (r * 5 + c))) != 0 ? "*" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class Baekjoon1035 {
    public static void main(String[] args) {
        new Problem();
    }
}
