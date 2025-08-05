import java.io.*;
import java.util.*;

public class C {
    static final int N = 8;
    static final int TOTAL_REMOVE = 60;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] grid = new char[N][N];
        List<int[]> aliveBlocks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'O') {
                    aliveBlocks.add(new int[]{i, j});
                }
            }
        }

        int totalAlive = aliveBlocks.size();

        double maxProb = -1;
        int bestX = -1, bestY = -1;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                List<int[]> cornerBlocks = Arrays.asList(
                    new int[]{i, j},
                    new int[]{i + 1, j},
                    new int[]{i, j + 1},
                    new int[]{i + 1, j + 1}
                );

                boolean valid = true;
                for (int[] pos : cornerBlocks) {
                    if (grid[pos[0]][pos[1]] != 'O') {
                        valid = false;
                        break;
                    }
                }

                if (!valid) continue;

                double pDie = combination(totalAlive - 4, TOTAL_REMOVE - 4) / combination(totalAlive, TOTAL_REMOVE);
                double pSurvive = 1.0 - pDie;

                if (pSurvive > maxProb) {
                    maxProb = pSurvive;
                    bestX = i + 1;
                    bestY = j + 1;
                }
            }
        }

        System.out.printf("%d %d\n", bestX, bestY);
        System.out.printf("%.15f\n", maxProb);
    }

    static double combination(int n, int r) {
        if (r < 0 || r > n) return 0;
        double res = 1.0;
        for (int i = 1; i <= r; i++) {
            res *= (n - i + 1);
            res /= i;
        }
        return res;
    }
}
