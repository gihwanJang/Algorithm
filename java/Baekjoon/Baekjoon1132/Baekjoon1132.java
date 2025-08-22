import java.io.*;

class Problem {
    int n;
    long ans;
    String[] numStrings;
    int[] match;
    boolean[] visited;

    public Problem(int n) {
        this.n = n;
        ans = 0;
        match = new int[10];
        visited = new boolean[10];
        numStrings = new String[n];
    }

    public long solve() {
        makeMaxValue(0);
        return ans;
    }

    private void makeMaxValue(int depth) {
        if(depth == 10) {
            ans = Math.max(ans, getSum());
            return;
        }

        for(int i = 9; i >= 0; --i) {
            if(!visited[i]) {
                visited[i] = true;
                match[depth] = i;
                makeMaxValue(depth+1);
                visited[i] = false;
            }
        }
    }

    private long getSum() {
        long sum = 0, value;
        for(int i = n-1; i >= 0; --i) {
            value = match[numStrings[i].charAt(0) - 'A'];

            if(value == 0) {
                return 0;
            }

            for(int j = 1; j < numStrings[i].length(); ++j) {
                value *= 10;
                value += match[numStrings[i].charAt(j) - 'A'];
            }

            sum += value;
        }
        return sum;
    }
}

public class Baekjoon1132 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));

        for(int i = 0; i < p.n; ++i) {
            p.numStrings[i] = br.readLine();
        }

        System.out.println(p.solve());
    }
}
