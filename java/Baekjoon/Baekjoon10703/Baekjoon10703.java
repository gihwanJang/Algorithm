import java.io.*;
import java.util.*;

class Problem {
    private int row;
    private int col;
    private char[][] map;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        for (int r = 0; r < row; ++r) {
            String s = br.readLine();
            for (int c = 0; c < col; ++c) {
                map[r][c] = s.charAt(c);
            }
        }

        solve();
    }

    private void solve() {
        int gap = row;

        for (int c = 0; c < col; ++c) {
            int count = 0;
            boolean isCount = false;
            for (int r = 0; r < row; ++r) {
                if (isCount && map[r][c] == '.') {
                    ++count;
                } else if (isCount && map[r][c] == '#') {
                    isCount = false;
                    gap = Math.min(gap, count);
                } else if (map[r][c] == 'X') {
                    isCount = true;
                    count = 0;
                }
            } 
        }

        processImg(gap);
        output();
    }

    private void processImg(int gap) {
        for (int r = row-1; r >= 0; --r) {
            for (int c = 0; c < col; ++c) {
                if (map[r][c] == 'X') {
                    map[r + gap][c] = 'X';
                    map[r][c] = '.';
                }
            }
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

public class Baekjoon10703 {
    public static void main(String[] args) {
        new Problem();
    }
}