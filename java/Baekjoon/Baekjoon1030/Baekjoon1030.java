import java.io.*;
import java.util.*;

class Problem {
    int s, n, k, r1, r2, c1, c2;
    public Problem(String line) {
        StringTokenizer st = new StringTokenizer(line);
        s  = Integer.parseInt(st.nextToken());
        n  = Integer.parseInt(st.nextToken());
        k  = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        for(int r = r1; r <= r2; ++r) {
            for(int c = c1; c <= c2; ++c) {
                sb.append(getColor(r,c,0) ? '1' : '0');        
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private boolean getColor(int r, int c, int t) {
        if(t == s) {
            return false;
        }
        int step = power(n, t);
        int start = ((n - k) / 2) * step; 
        int shiftR = r % (step*n);
        int shiftC = c % (step*n);       
        if (start <= shiftR && shiftR < start + (k*step)
            &&
            start <= shiftC && shiftC < start + (k*step)) {
                return true;
        }
        return getColor(r, c, t+1);
    }
    private int power(int a, int b) {
        int p = 1;
        for(int i = 0; i < b; ++i) {
            p *= a;
        }
        return p;
    }
}

public class Baekjoon1030 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(br.readLine());
        System.out.print(p.solve());
    }
}