import java.io.*;
import java.util.*;

class Problem {
    private static final int[] DR = {-1,1,0,0};
    private static final int[] DC = {0,0,-1,1};

    private int[] nmk;
    private int[][] map;
    private boolean[][] used;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nmk = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        map = new int[nmk[0]][nmk[1]];
        used = new boolean[nmk[0]][nmk[1]];
        for (int i = 0; i < nmk[0]; ++i) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(solve(0, 0, 0));
    }

    private int solve(int count, int currR, int currC) {
        if (count == nmk[2]) {
            return 0;
        } else if (currR == nmk[0]) {
            return Integer.MIN_VALUE;
        }

        int ret = Integer.MIN_VALUE;
        if (canUse(currR, currC)) {
            used[currR][currC] = true;
            int use = solve(count + 1, (currC + 1) % nmk[1] == 0 ? currR + 1 : currR, (currC + 1) % nmk[1]);
            used[currR][currC] = false;

            if (use != Integer.MIN_VALUE) {
                ret = Math.max(ret, use + map[currR][currC]);
            } 
        }

        ret = Math.max(ret, solve(count, (currC + 1) % nmk[1] == 0 ? currR + 1 : currR, (currC + 1) % nmk[1]));
        return ret;
    }

    private boolean canUse(int r, int c) {
        for (int i = 0; i < 4; ++i) {
            int checkR = r + DR[i];
            int checkC = c + DC[i];
            if ((0 <= checkR && checkR < nmk[0] &&
                0 <= checkC && checkC < nmk[1]) && 
                used[checkR][checkC]) {
                    return false;
            }
        }
        return true;
    }
}

public class Baekjoon18290 {
    public static void main(String[] args) {
        new Problem();
    }
}
