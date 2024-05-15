import java.io.*;
import java.util.*;

class Problem {
    private int[] DX = {-1,1,0,0};
    private int[] DY = {0,0,-1,1};
    private int n, m;
    private int[][] map;
    private List<int[]> cctvList;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cctvList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new int[]{i, j});
                }
            }
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        int blindSpot = 987654321;
        int[] curr;
        Queue<int[]> que = new ArrayDeque<>();

        que.add(new int[cctvList.size()+1]);
        while (!que.isEmpty()) {
            curr = que.poll();

            if (curr[cctvList.size()] == cctvList.size()) {
                blindSpot = Math.min(blindSpot, countBlindSpot(curr));
            } else {
                int cctv = map[cctvList.get(curr[cctvList.size()])[0]][cctvList.get(curr[cctvList.size()])[1]];

                if (cctv == 1 || cctv == 3 || cctv == 4) {
                    for (int i = 0; i < 4; ++i) {
                        int[] next = curr.clone();
                        next[curr[cctvList.size()]] = i;
                        ++next[cctvList.size()];
                        que.add(next);
                    }
                } else if (cctv == 2) {
                    for (int i = 0; i < 2; ++i) {
                        int[] next = curr.clone();
                        next[curr[cctvList.size()]] = i;
                        ++next[cctvList.size()];
                        que.add(next);
                    }
                } else {
                    ++curr[cctvList.size()];
                    que.add(curr);
                }
            }
        }
        return blindSpot;
    }

    private int countBlindSpot(int[] state) {
        int blindSpot = 0;
        int[][] checkTable = new int[n][m];
        for (int i = 0; i < n; ++i) {
            checkTable[i] = map[i].clone();
        }
        for (int i = 0; i < cctvList.size(); ++i) {
            if (map[cctvList.get(i)[0]][cctvList.get(i)[1]] == 1) {
                if (state[i] == 0) { // up
                    checkView(0, i, checkTable);
                } else if (state[i] == 1) { //down
                    checkView(1, i, checkTable);
                } else if (state[i] == 2) { // left
                    checkView(2, i, checkTable);
                } else { // right
                    checkView(3, i, checkTable);
                }
            } else if (map[cctvList.get(i)[0]][cctvList.get(i)[1]] == 2) {
                if (state[i] == 0) { // up down
                    checkView(0, i, checkTable);
                    checkView(1, i, checkTable);
                } else { // left right
                    checkView(2, i, checkTable);
                    checkView(3, i, checkTable);
                }
            } else if (map[cctvList.get(i)[0]][cctvList.get(i)[1]] == 3) {
                if (state[i] == 0) { // up left
                    checkView(0, i, checkTable);
                    checkView(2, i, checkTable);
                } else if (state[i] == 1) { // up right
                    checkView(0, i, checkTable);
                    checkView(3, i, checkTable);
                } else if (state[i] == 2) { // down left
                    checkView(1, i, checkTable);
                    checkView(2, i, checkTable);
                } else { // down right
                    checkView(1, i, checkTable);
                    checkView(3, i, checkTable);
                }
            } else if (map[cctvList.get(i)[0]][cctvList.get(i)[1]] == 4) {
                if (state[i] == 0) { // up left right
                    checkView(0, i, checkTable);
                    checkView(2, i, checkTable);
                    checkView(3, i, checkTable);
                } else if (state[i] == 1) { // up left down
                    checkView(0, i, checkTable);
                    checkView(2, i, checkTable);
                    checkView(1, i, checkTable);
                } else if (state[i] == 2) { // left down right
                    checkView(2, i, checkTable);
                    checkView(1, i, checkTable);
                    checkView(3, i, checkTable);
                } else { // down right up
                    checkView(1, i, checkTable);
                    checkView(3, i, checkTable);
                    checkView(0, i, checkTable);
                }
            } else {
                for (int dir = 0; dir < 4; ++dir) {
                    checkView(dir, i, checkTable);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (checkTable[i][j] == 0) {
                    ++blindSpot;
                }
            }
        } 
        return blindSpot;
    }

    private void checkView(int dir, int idx, int[][] checkTable) { // up down left right
        for (int i = 1; i < 8; ++i) {
            int r = cctvList.get(idx)[0] + DX[dir] * i;
            int c = cctvList.get(idx)[1] + DY[dir] * i;

            if (!isValidate(r, c) || checkTable[r][c] == 6) {
                return;
            } else if (checkTable[r][c] == 0) {
                checkTable[r][c] = -1;
            }
        }
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < n && 0 <= c && c < m);
    }
}

public class Baekjoon15683 {
    public static void main(String[] args) {
        new Problem();
    }
}
