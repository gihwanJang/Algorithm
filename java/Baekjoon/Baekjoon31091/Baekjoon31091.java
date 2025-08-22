import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[] more, less;
    List<Integer> liar;
    
    public Problem(int n) {
        this.n = n;
        more = new int[n+2];
        less = new int[n+2];
        liar = new ArrayList<>();
    }
    public String solve() {
        makeTable();
        for(int i = 0; i <= n; ++i) {
            int count = 0;
            if(i < n) {
                count += more[i+1];
            }
            if(i > 0) {
                count += less[i-1];
            }
            if(count == i) {
                liar.add(count);
            }
        }
        return getAns();
    }

    private void makeTable() {
        for(int i = 1; i <= n; ++i) {
            less[i] += less[i-1];
        }
        for(int i = n; i > 0; --i) {
            more[i-1] += more[i];
        }
    }

    private String getAns() {
        StringBuilder sb = new StringBuilder();
        sb.append(liar.size()).append("\n");
        for (int i : liar) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}

public class Baekjoon31091 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < problem.n; ++i) {
            int talk = Integer.parseInt(st.nextToken());
            if(talk > 0) {
                ++problem.more[talk];
            } else {
                ++problem.less[-talk];
            }
        }

        System.out.println(problem.solve());
    }
}
