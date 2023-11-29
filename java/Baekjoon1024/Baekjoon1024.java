import java.io.*;
import java.util.*;

class Line {
    double a, b;

    public Line(double x1, double y1, double x2, double y2) {
        a = (y2-y1) / (x2-x1);
        b = -x1 * a + y1;
    }

    public boolean canSee(int x, int y) {
        double r = a * x + b;
        return r > y;
    }
}

class Problem {
    int size;
    int[] buildings;

    public Problem(int n) {
        size = n;
        buildings = new int[size];
    }

    public int solve() {
        int ans = 0;

        for(int i = 0; i < size; ++i) {
            ans = Math.max(ans, findLeft(i) + findRight(i));
        }

        return ans;
    }

    private int findRight(int idx) {
        int cnt = 0;

        for(int i = idx+1; i < size; ++i) {
            if(canSee(idx, i)){
                ++cnt;
            }
        }

        return cnt;
    }

    private int findLeft(int idx) {
        int cnt = 0;

        for(int i = idx-1; i >= 0; --i) {
            if(canSee(i, idx)) {
                ++cnt;
            }
        }

        return cnt;
    }

    private boolean canSee(int lo, int hi) {
        Line line = new Line(lo, buildings[lo], hi, buildings[hi]);

        for(int i = lo+1; i < hi; ++i){
            if(!line.canSee(i, buildings[i])) {
                return false;
            }
        }

        return true;
    }
}

public class Baekjoon1024 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < problem.size; ++i) {
            problem.buildings[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(problem.solve());
    }
}
