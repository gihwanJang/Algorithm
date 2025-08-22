import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[] rgb;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        StringTokenizer st = new StringTokenizer(
                new BufferedReader(new InputStreamReader(System.in)).readLine());
        
        this.rgb = new int[3];
        this.n = Integer.parseInt(st.nextToken());
        this.rgb[0] = Integer.parseInt(st.nextToken());
        this.rgb[1] = Integer.parseInt(st.nextToken());
        this.rgb[2] = Integer.parseInt(st.nextToken());
    }

    private void output() {
        System.out.println(solve());
    }

    private long solve() {
        return recvMakeTree(1);
    }

    private long recvMakeTree(int level) {
        if (n < level) {
            return 1;
        }

        long sum = 0;

        sum += singleColorTree(level);
        if (level % 2 == 0) {
            sum += twinColorTree(level);
        }
        if (level % 3 == 0) {
            sum += tripleColorTree(level);
        }
        return sum;
    }

    private long singleColorTree(int level) {
        long sum = 0;

        for (int i = 0; i < 3; ++i) {
            if (level <= rgb[i]) {
                rgb[i] -= level;
                sum += recvMakeTree(level + 1);
                rgb[i] += level;
            }
        }
        return sum;
    }

    private long twinColorTree(int level) {
        long sum = 0;
        int total = factorial(level);
        int duplicated = factorial(level / 2);

        for (int i = 0; i < 2; ++i) {
            for (int j = i + 1; j < 3; ++j) {
                if (level/2 <= rgb[i] && level/2 <= rgb[j]) {
                    rgb[i] -= level/2;
                    rgb[j] -= level/2;
                    sum += recvMakeTree(level + 1) * total / (duplicated * duplicated);
                    rgb[i] += level/2;
                    rgb[j] += level/2;
                }
            }
        }
        return sum;
    }

    private long tripleColorTree(int level) {
        long sum = 0;
        int total = factorial(level);
        int duplicated = factorial(level / 3);

        if (level/3 <= rgb[0] && level/3 <= rgb[1] && level/3 <= rgb[2]) {
            rgb[0] -= level/3;
            rgb[1] -= level/3;
            rgb[2] -= level/3;
            sum += recvMakeTree(level + 1) * total / (duplicated * duplicated * duplicated);
            rgb[0] += level/3;
            rgb[1] += level/3;
            rgb[2] += level/3;
        }
        return sum;
    }

    private int factorial(int k) {
        for (int i = k - 1; i > 0; --i) {
            k *= i;
        }
        return k;
    }
}

public class Baekjoon1234 {
    public static void main(String[] args) {
        new Problem();
    }
}
