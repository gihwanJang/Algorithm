import java.io.*;
import java.util.*;

class Problem {
    double dis;
    int d, t;
    public Problem(int x, int y, int d, int t) {
        this.dis = Math.sqrt(x*x+y*y);
        this.d = d;
        this.t = t;
    }
    public double solve() {
        int jump = (int)dis / d;
        double remain = dis - jump * d;
        double ans = Math.min(dis, remain + jump * t);

        ans = Math.min(ans, (jump+1)*d-dis + (jump+1)*t);
        if(jump > 0) {
            ans = Math.min(ans, (jump+1)*t);
        } else if(dis < d){
            ans = Math.min(ans, t*2);
        }

        return ans;
    }
}

public class Baekjoon1069 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        System.out.println(p.solve());
    }
}
