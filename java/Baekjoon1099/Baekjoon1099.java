import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[] dp;
    String s;
    String[] wards;

    public Problem(String s, String n) {
        this.s = s;
        this.n = Integer.parseInt(n);
        this.wards = new String[this.n];
        this.dp = new int[s.length()+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
    }

    public int solve() {
        makeTable();
        return dp[s.length()] == Integer.MAX_VALUE ? -1 : dp[s.length()];
    }

    private void makeTable() {
        dp[0] = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for(int j = 0; j < n; ++j) {
                int end = i+wards[j].length();
                if(end <= s.length() && canMake(s.substring(i, end), wards[j])) {
                    dp[end] = Math.min(dp[end], dp[i] + getCost(s.substring(i, end), wards[j]));
                }
            }
        }
    }

    private int getCost(String sub, String ward) {
        int cost = 0;
        for(int k = 0; k < sub.length(); ++k) {
            if(sub.charAt(k) != ward.charAt(k)) {
                ++cost;
            }
        }
        return cost;
    }

    private boolean canMake(String sub, String ward) {
        int[] alpaS = new int[26];
        int[] alpaW = new int[26];
        for(int i = 0; i < sub.length(); ++i) {
            ++alpaS[sub.charAt(i) - 'a'];
            ++alpaW[ward.charAt(i) - 'a'];
        }
        for(int i = 0; i < 26; ++i) {
            if(alpaS[i] != alpaW[i]) {
                return false;
            }
        }
        return true;
    }
}

public class Baekjoon1099 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(br.readLine(), br.readLine());
        for(int i = 0; i < p.n; ++i) {
            p.wards[i] = br.readLine();
        }
        System.out.println(p.solve());
    }
}
