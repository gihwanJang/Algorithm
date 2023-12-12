import java.io.*;

/*
 * 01 -> 0
 * 02 -> 0
 * 03 -> 0
 * 04 -> (13 C 1)
 * 05 -> (13 C 1) * (48 C 01)
 * 06 -> (13 C 1) * (48 C 02)
 * 07 -> (13 C 1) * (48 C 03)
 * 08 -> (13 C 1) * (48 C 04) - (13 C 2)
 * 09 -> (13 C 1) * (48 C 05) - (13 C 2) * (44 C 1)
 * 10 -> (13 C 1) * (48 C 06) - (13 C 2) * (44 C 2)
 * 11 -> (13 C 1) * (48 C 07) - (13 C 2) * (44 C 3)
 * 12 -> (13 C 1) * (48 C 08) - (13 C 2) * (44 C 4) + (13 C 3)
 * 13 -> (13 C 1) * (48 C 09) - (13 C 2) * (44 C 5) + (13 C 3) * (40 C 1)
 * 14 -> (13 C 1) * (48 C 10) - (13 C 2) * (44 C 6) + (13 C 3) * (40 C 2)
 * ...
 * 47 -> 
 * 48 -> 
 * 49 -> 
 * 50 -> 
 * 51 -> 1 * 52
 * 52 -> (13 C 1) * (48 C 48) - (13 C 2) * (44 C 44) + (13 C 3) * (40 C 40) ....
 */

class Problem {
    int cardNum;
    final int MOD = 10_007;
    final int winCount = 4;
    final int totalCardNum = 52;
    long[][] combMemo;

    public Problem(int n) {
        this.cardNum = n;
        combMemo = new long[totalCardNum + 1][totalCardNum + 1];
    }

    public long solve() {
        long ans = 0;
        int caseCount = cardNum / 4;
        for(int i = 1; i <= caseCount; ++i) {
            int n = totalCardNum - winCount * i;
            int r = cardNum - winCount * i;
            if(i % 2 == 0) {
                ans += MOD - (comb(13, i) * comb(n, r)) % MOD;
            } else {
                ans += (comb(13, i) * comb(n, r)) % MOD;
            }
            ans %= MOD;
        }
        return ans;
    }

    private long comb(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else if (combMemo[n][r] != 0) {
            return combMemo[n][r];
        } else {
            long result = (comb(n - 1, r - 1) % MOD + comb(n - 1, r) % MOD) % MOD;
            combMemo[n][r] = result;
            return result;
        }
    }
}

public class Baekjoon16565 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        System.out.println(problem.solve());
    }
}
