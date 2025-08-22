import java.io.*;
import java.util.*;

class Problem {
    private static final int[] DR = {-1,1,0};
    private static final int[] DC = {0,0,1};
    private int w, h, goalY;
    private int[][] map;
    private int[][][] memo;

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

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h+1][w];
        memo = new int[h + 1][w][3];
        st = new StringTokenizer(br.readLine()); 
        int n = Integer.parseInt(st.nextToken());
        goalY = Integer.parseInt(st.nextToken());
        int[] lanes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] speeds = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < n; ++i) {
            for (int r = i == 0 ? 0 : lanes[i - 1]; r <= lanes[i]; ++r) {
                for (int c = 0; c < w; ++c) {
                    map[r][c] = speeds[i];
                }
            }
        }
    }

    private void output() {
        System.out.println(DFS(0, 0, 2));
    }

    private int DFS(int r, int c, int dir) {
        if (r == goalY && c == w - 1){
            return map[r][c];
        } else if (memo[r][c][dir] != 0) {
            return memo[r][c][dir];
        }

        int time = 1234567890;
        for (int i = 0; i < 3; ++i) {
            int nextR = r + DR[i];
            int nextC = c + DC[i];

            if (isValidate(nextR, nextC) && !(dir == 1 && i == 0) && !(dir == 0 && i == 1)) {
                time = Math.min(map[r][c] + DFS(nextR, nextC, i), time);
            }
        }
        return memo[r][c][dir] = time;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r <= h
                &&
                0 <= c && c < w);
    }
}

public class C {
    public static void main(String[] args) {
        new Problem();
    }
}
