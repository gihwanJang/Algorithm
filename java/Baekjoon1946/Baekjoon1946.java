import java.io.*;
import java.util.*;

class Rank implements Comparable<Rank> {
    int f, s;
    public Rank(int f, int s) {
        this.f = f;
        this.s = s;
    }
    @Override
    public int compareTo(Rank o) {
        return f - o.f;
    }
}

class Problem {
    int n;
    Rank[] ranks;
    public Problem(int n) {
        this.n = n;
        ranks = new Rank[n];
    }
    public int solve() {
        Arrays.sort(ranks);
        int cnt = 1, min = ranks[0].s;
        for(int i = 1; i < n; ++i) {
            if(ranks[i].s < min) {
                ++cnt;
            }
            min = Math.min(min, ranks[i].s);
        }
        return cnt;
    }
}

public class Baekjoon1946 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int T=Integer.parseInt(br.readLine()); T>0; --T){
            Problem problem = new Problem(Integer.parseInt(br.readLine()));

            for(int i = 0; i < problem.n; ++i){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int socre = Integer.parseInt(st.nextToken());
                int rank = Integer.parseInt(st.nextToken());
                problem.ranks[i] = new Rank(socre, rank);
            }

            sb.append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
