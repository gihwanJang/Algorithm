import java.io.*;
import java.util.*;

class Problem {
    int[] mary, john;

    public Problem() {
        mary = new int[2];
        john = new int[2];
    }

    public int solve() {
        makeOdd(0, 1);
        makeOdd(1, 0);
        return Math.max(mary[0], mary[1]);
    }

    private void makeOdd(int m, int j) {
        if(mary[m] > john[j]) {
            mary[m] -= john[j];
            john[j] = 0;
        } else {
            john[j] -= mary[m];
            mary[m] = 0;
        }
    }
}

public class Baekjoon5747 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                break;
            }

            Problem problem = new Problem();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; ++i) {
                ++problem.mary[Integer.parseInt(st.nextToken())%2];
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; ++i) {
                ++problem.john[Integer.parseInt(st.nextToken())%2];
            }
            sb.append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}