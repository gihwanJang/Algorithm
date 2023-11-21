import java.io.*;

// solution 1
class Problem {
    final int MOD = 9901;
    int size;
    int[] cage;

    public Problem(int n) {
        size = n;
        cage = new int[size+1];
    }
    public int solve() {
        cage[0] = 1;
        cage[1] = 3;

        for(int i = 2; i <= size; ++i)
            cage[i] = ((cage[i-1] * 2) % MOD + cage[i-2] % MOD) % MOD;

        return cage[size];
    }
}

// solution 2
class Problem2 {
    final int MOD = 9901;
    int size;
    int[][] cage;

    public Problem2(int n) {
        size = n;
        cage = new int[size][3];
    }
    public int solve() {
        return 0;
    }

    private int DFS() {
        return 0;
    }
}

public class Baekjoon1309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Problem problem = new Problem(Integer.parseInt(br.readLine()));
        Problem2 problem = new Problem2(Integer.parseInt(br.readLine()));
        System.out.println(problem.solve());
    }
}


/*
 * 1 -> 1,  2 : 3
 * 2 -> 1,  4,  2 : 7
 * 3 -> 1,  6,  8,  2 : 17
 * 4 -> 1,  8, 18, 12,  2 : 41
 * 5 -> 1, 10, 32, 38, 16, 2 : 99
 */