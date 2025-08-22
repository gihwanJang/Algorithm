import java.io.*;
import java.util.*;

class Problem {
    private int l;
    private String ans;
    private int[][] origin;
    private List<boolean[][]> pices;

    public Problem() {
        ans = "gg";
        try {
            if (input()) {
                solve(0);
            }
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void solve(int depth) {
        if (depth == pices.size()) {
            makeAnswer();
            return;
        }

        int rowSize = pices.get(depth).length;
        int colSize = pices.get(depth)[0].length;

        for (int r = 0; r <= l - rowSize; ++r) {
            for (int c = 0; c <= l - colSize; ++c) {
                if (isValidate(r, c, depth, rowSize, colSize)) {
                    doFill(r, c, depth, rowSize, colSize);
                    solve(depth + 1);
                    undoFill(r, c, depth, rowSize, colSize);
                }
            }
        }
    }

    private void doFill(int r, int c, int idx, int rowSize, int colSize) {
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (pices.get(idx)[i][j] == true) {
                    origin[r + i][c + j] = idx + 1;
                }
            }
        }
    }

    private void undoFill(int r, int c, int idx, int rowSize, int colSize) {
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (origin[r + i][c + j] == idx + 1) {
                    origin[r + i][c + j] = 0;
                }
            }
        }
    }

    private boolean isValidate(int r, int c, int idx , int rowSize, int colSize) {
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (origin[r + i][c + j] != 0 && pices.get(idx)[i][j] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean input() throws Exception {
        int count = 0;
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.l = Integer.parseInt(br.readLine());
        this.origin = new int[l][l];
        this.pices = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            int[] size = Arrays.stream(line.split(" "))
                    .mapToInt(i ->  Integer.parseInt(i))
                    .toArray();
            boolean[][] pice = new boolean[size[0]][size[1]];

            for (int r = 0; r < size[0]; ++r) {
                String row = br.readLine();

                for (int c = 0; c < size[1]; ++c) {
                    if (row.charAt(c) == '#') {
                        pice[r][c] = true;
                        ++count;
                    }
                }
            }
            pices.add(pice);
        }
        return count == l * l;
    }

    private void makeAnswer() {
        if (!canPrint()) {
            return;
        }
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < l; ++r) {
            for (int c = 0; c < l; ++c) {
                sb.append(origin[r][c]);
            }
            sb.append("\n");
        }
        if (ans.equals("gg") || 0 < ans.compareTo(sb.toString())) {
            ans = sb.toString();
        }
    }

    private void output() {
        System.out.print(ans);
    }

    private boolean canPrint(){
        for (int r = 0; r < l; ++r) {
            for (int c = 0; c < l; ++c) {
                if (origin[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Baekjoon1207 {
    public static void main(String[] args) {
        new Problem();
    }
}
