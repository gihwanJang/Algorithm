import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[][] points;

    public Problem(int n) {
        this.n = n;
        points = new int[n][2];
    }

    public long solve() {
        long[] xMap = new long[100001];
        long[] yMap = new long[100001];
        for(int i = 0; i < n; ++i) {
            xMap[points[i][0]] += 1;
            yMap[points[i][1]] += 1;
        }
        return getTriangleCnt(xMap, yMap);
    }

    private long getTriangleCnt(long[] xMap, long[] yMap) {
        long ret = 0;
        for(int i = 0; i < n; ++i) {
            ret += (xMap[points[i][0]]-1) * (yMap[points[i][1]]-1);
        }
        return ret;
    }
}

public class Baekjoon3000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        for(int i = 0; i < problem.n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problem.points[i][0] = Integer.parseInt(st.nextToken());
            problem.points[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(problem.solve());
    }
}
