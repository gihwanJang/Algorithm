import java.io.*;

class Problem {
    int size;
    int MOD = 1_000_000_009;
    int[] counts;

    public Problem() {
        this.size = 1_000_000;
        counts = new int[size+1];
        counts[0]=counts[1]=1;
        counts[2]=2;
        makeTable();
    }

    public int solve(int n) {
        return counts[n];
    }

    private void makeTable() {
        for(int i = 3; i <= size; ++i) {
            long tmp = 0;
            for(int j = 1; j < 4; ++j) {
                tmp += counts[i - j];
            }
            counts[i] = (int)(tmp % MOD);
        }
    }
}

public class Baekjoon15988 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; ++i) {
            System.out.println(problem.solve(Integer.parseInt(br.readLine())));
        }
    }
}
