import java.io.*;
import java.util.*;

public class Baekjoon14939 {
    Boolean[][] map;
    Boolean[][] temp;
    int[] dx = { 0, 1, 0, -1, 0 };
    int[] dy = { 0, 0, 1, 0, -1 };

    private void makeTemp() {
        temp = Arrays.stream(map)
                    .map(Boolean[]::clone)
                    .toArray(Boolean[][]::new);
    }

    private boolean validationLoc(int r, int c) {
        return (0 <= r && r < 10 &&
                0 <= c && c < 10);
    }

    private int changeState(int r, int c) {
        for (int i = 0; i < 5; ++i)
            if (validationLoc(r + dx[i], c + dy[i]))
                temp[r + dx[i]][c + dy[i]] = !temp[r + dx[i]][c + dy[i]];

        return 1;
    }

    private boolean isDone() {
        for (int c = 0; c < 10; ++c)
            if (temp[9][c])
                return false;

        return true;
    }

    public int solve() {
        int ans = Integer.MAX_VALUE;

        for (int bt = 0; bt < (1 << 10); ++bt) {
            int cnt = 0;
            makeTemp();

            for (int c = 0; c < 10; ++c)
                if ((bt & (1 << c)) != 0)
                    cnt += changeState(0, c);

            for (int r = 1; r < 10; ++r)
                for (int c = 0; c < 10; ++c)
                    if (temp[r - 1][c])
                        cnt += changeState(r, c);

            if (isDone())
                ans = Math.min(ans, cnt);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon14939 problem = new Baekjoon14939();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        problem.map = new Boolean[10][10];
        for (int r = 0; r < 10; ++r)
            problem.map[r] = br.readLine().chars().mapToObj(c -> c == 'O').toArray(Boolean[]::new);

        System.out.println(problem.solve());
    }
}