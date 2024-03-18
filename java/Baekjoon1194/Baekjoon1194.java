import java.io.*;
import java.util.*;

class Problem {
    private class Info {
        int r, c, v;
        
        public Info(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }

        @Override
        public boolean equals(Object obj) {
            Info other = (Info)obj;
            return (r == other.r && c == other.c && v == other.v);
        }

        @Override
        public int hashCode() {
            return r * 31 * 31 + c * 31 + v;
        }
    }
    private class QueInfo {
        int d;
        Info info;
    
        public QueInfo(Info info, int d) {
            this.info = info;
            this.d = d;
        }
    }
    private final int[] dr = {-1,1,0,0};
    private final int[] dc = {0,0,-1,1};
    private int R;
    private int C;
    private int startR;
    private int startC;
    private char[][] map;
    private Set<Info> visited;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new HashSet<>();
        for (int r = 0; r < R; ++r) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < C; ++c) {
                if (map[r][c] == '0') {
                    startR = r;
                    startC = c;
                }
            }
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        QueInfo curr;
        Queue<QueInfo> que = new ArrayDeque<>();

        que.add(new QueInfo(new Info(startR, startC, 0), 0));
        visited.add(que.peek().info);
        while(!que.isEmpty()) {
            curr = que.poll();

            if (map[curr.info.r][curr.info.c] == '1') {
                return curr.d;
            }
            
            move(que, curr);
        }
        return -1;
    }

    private void move(Queue<QueInfo> que, QueInfo curr) {
        for (int i = 0; i < 4; ++i) {
            int nextR = curr.info.r + dr[i];
            int nextC = curr.info.c + dc[i];

            if (isValidate(nextR, nextC)) {
                Info nextInfo = getNextInfo(nextR, nextC, curr.info.v);
                if (nextInfo != null && !visited.contains(nextInfo)) {
                    que.add(new QueInfo(nextInfo, curr.d + 1));
                    visited.add(nextInfo);
                }
            }
        }
    }

    private Info getNextInfo(int nextR, int nextC, int v) {
        if ('a' <= map[nextR][nextC] && map[nextR][nextC] <= 'z') {
            return new Info(nextR, nextC, v | 1 << (map[nextR][nextC] - 'a'));
        } else if (map[nextR][nextC] == '.' 
                || map[nextR][nextC] == '0' 
                || map[nextR][nextC] == '1' 
                || (1 << (map[nextR][nextC] - 'A') & v) != 0) {
            return new Info(nextR, nextC, v);
        }
        return null;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < R 
                && 0 <= c && c < C
                && map[r][c] != '#');
    }
}
//000001
public class Baekjoon1194 {
    public static void main(String[] args) {
        new Problem();
    }
}
