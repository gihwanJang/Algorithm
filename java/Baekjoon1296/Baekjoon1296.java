import java.io.*;

class Problem {
    int n;
    int MOD = 100;
    String love;
    String name;
    String[] names;
    int[] set;
    
    public Problem(String name, int n) {
        this.n = n;
        this.name = name;
        this.names = new String[n];
        this.love = "LOVE";
        this.set = new int[26];
        makeSet();
    }

    public String solve() {
        String winner = names[0];
        int score = getScore(0);
        for(int i = 1; i < n; ++i) {
            int newScore = getScore(i);
            if(score < newScore) {
                winner = names[i];
                score = newScore;
            } else if (score == newScore && winner.compareTo(names[i]) > 0) {
                winner = names[i];
            }
        }
        return winner;
    }

    private int getScore(int idx) {
        int score = 1;
        int[] newSet = getNewSet(idx);
        for(int i = 0; i < 3; ++i) {
            int left = (set[love.charAt(i) - 'A'] + newSet[love.charAt(i) - 'A']) % MOD;
            for(int j = i + 1; j < 4; ++j) {
                int right = (set[love.charAt(j) - 'A'] + newSet[love.charAt(j) - 'A']) % MOD;
                score = (score * (left + right) % MOD) % MOD;
            }
        }
        return score;
    }

    private int[] getNewSet(int idx) {
        int[] newSet = new int[26];
        for(int i = 0; i < names[idx].length(); ++i) {
            newSet[names[idx].charAt(i) - 'A'] += 1;
        }
        return newSet;
    }

    private void makeSet() {
        for(int i = 0; i < name.length(); ++i) {
            set[name.charAt(i) - 'A'] += 1;
        }
    }
}

public class Baekjoon1296 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(br.readLine(), Integer.parseInt(br.readLine()));
        for(int i = 0; i < problem.n; ++i) {
            problem.names[i] = br.readLine();
        }
        System.out.println(problem.solve());
    }
}
