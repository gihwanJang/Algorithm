import java.io.*;
import java.util.*;

class Problem {
    long s, e;
    boolean[] visited;
    public Problem(long s, long e) {
        this.s = s;
        this.e = e;
        visited = new boolean[(int)(e-s)+1];
    }
    public long solve() {
        long cnt = 0;
        makeVisited();
        for(int i = 0; i <= e-s; ++i) {
            if(!visited[i]) {
                ++cnt;
            }
        }
        return cnt;
    }
    private void makeVisited() {
        for(long i = 2; i*i <= e; ++i) {
            long n = s / (i*i);   

            if(s % (i*i) != 0) {
                ++n;
            }

            while(n * i * i <= e) {
                visited[(int)(n * i * i - s)] = true;
                ++n;
            }
        }
    }
}

public class Baekjoon1016 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        System.out.println(problem.solve());
    }
}
