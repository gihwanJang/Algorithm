import java.io.*;
import java.util.*;

class Tree {
    int r, c, state, depth;
    public Tree(int centerR, int centerC, int state, int depth) {
        this.c = centerC;
        this.r = centerR;
        this.state = state;
        this.depth = depth;
    }
}

class Problem {
    private static final int[] DR = {0,0,-1,1};
    private static final int[] DC = {-1,1,0,0};
    private static final int ROW = 0;
    private static final int COL = 1;
    private int n;
    private char[][] map;
    private boolean[][][] visited;
    private int startR, startC, startState;
    private int endR, endC, endState;

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

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n][2];
        for (int i = 0; i < n; ++i) {
            map[i] = br.readLine().toCharArray();
        }
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                if (map[r][c] == 'B') {
                    if (isInitValidate(r, c, COL)) {
                        startR = r;
                        startC = c;
                        startState = COL;
                    } else if (isInitValidate(r, c, ROW)) {
                        startR = r;
                        startC = c;
                        startState = ROW;
                    }
                } else if (map[r][c] == 'E') {
                    if (isInitValidate(r, c, COL)) {
                        endR = r;
                        endC = c;
                        endState = COL;
                    } else if (isInitValidate(r, c, ROW)) {
                        endR = r;
                        endC = c;
                        endState = ROW;
                    }
                }
            }
        }
    }

    private void output() {
        System.out.println(bFS());
    }

    private int bFS() {
        Tree curr;
        Queue<Tree> que = new ArrayDeque<>();

        visited[startR][startC][startState] = true;
        que.add(new Tree(startR, startC, startState, 0));
        while(!que.isEmpty()) {
            curr = que.poll();

            if (curr.r == endR && curr.c == endC && curr.state == endState) {
                return curr.depth;
            }

            for (int i = 0; i < 4; ++i) {
                int nextR = curr.r + DR[i];
                int nextC = curr.c + DC[i];
    
                if (isValidate(nextR, nextC, curr.state) && !visited[nextR][nextC][curr.state]) {
                    visited[nextR][nextC][curr.state] = true;
                    que.add(new Tree(nextR, nextC, curr.state, curr.depth + 1));
                }
            }
            if (isValidate(curr.r, curr.c, Math.abs(curr.state-1)) && turnValidate(curr.r, curr.c) && !visited[curr.r][curr.c][Math.abs(curr.state-1)]) {
                visited[curr.r][curr.c][Math.abs(curr.state-1)] = true;
                que.add(new Tree(curr.r, curr.c, Math.abs(curr.state-1), curr.depth + 1));
            }
        }
        return 0;
    }

    private boolean isInitValidate(int r, int c, int state) {
        if (state == COL) {
            return (isValidate(r, c, COL) 
                    && map[r][c - 1] == map[r][c] 
                    && map[r][c + 1] == map[r][c]);
        }
        return (isValidate(r, c, ROW) 
                && map[r - 1][c] == map[r][c] 
                && map[r + 1][c] == map[r][c]);
    }

    private boolean turnValidate(int centerR, int centerC) {
        return (map[centerR-1][centerC-1] != '1' 
                && 
                map[centerR-1][centerC+1] != '1'
                && 
                map[centerR+1][centerC-1] != '1'
                && 
                map[centerR+1][centerC+1] != '1');
    }

    private boolean isValidate(int centerR, int centerC, int state) {
        if (state == ROW) {
            return (validate(centerR - 1, centerC) && validate(centerR + 1, centerC) && validate(centerR, centerC));
        } else {
            return (validate(centerR, centerC - 1) && validate(centerR, centerC + 1) && validate(centerR, centerC));
        }
    }

    private boolean validate(int r, int c) {
        return (0 <= r && r < n
                &&
                0 <= c && c < n
                &&
                map[r][c] != '1');
    }
}

public class Baekjoon1938 {
    public static void main(String[] args) {
        new Problem();
    }
}
