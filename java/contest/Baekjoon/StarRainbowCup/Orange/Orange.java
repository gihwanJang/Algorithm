import java.io.*;
import java.util.*;

class Problem {
    int k, r, c, combo, tird;
    long stardust;
    int[] p, s, magic, base;

    public Problem(int k, int c, int r) {
        this.k = k;
        this.c = c;
        this.r = r;
        combo = 0;
        tird = 0;
        stardust = 0;
        p = new int[k];
        s = new int[k];
        magic = new int[k];
        base = new int[k];
    }
    public boolean makeStardust(int i) {
        if(i == -1)  {
            combo = 0;
            tird -= r;
            if(tird < 0) tird = 0;
            return false;
        }
        tird += p[i];
        stardust +=  base[i] * ((1 + ((double)(combo++) * c / 100)) * (1 + ((double)(magic[i]++) * s[i] / 100)));
        if(tird > 100) return true;
        return false;
    }
    public long solve() {
        return stardust;
    }
}

public class Orange {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Problem problem = new Problem(k, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < k; ++i) {
            problem.base[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < k; ++i) {
            problem.s[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < k; ++i) {
            problem.p[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; ++i) {
            if(problem.makeStardust(Integer.parseInt(br.readLine())-1)){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(problem.solve());
    }
}
