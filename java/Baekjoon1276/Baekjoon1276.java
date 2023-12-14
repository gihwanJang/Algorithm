import java.io.*;
import java.util.*;

class Platforms implements Comparable<Platforms> {
    int xL, xR, y;

    public Platforms(int y, int xL, int xR) {
        this.y = y;
        this.xL = xL;
        this.xR = xR;
    }

    @Override
    public int compareTo(Platforms o) {
        return xL - o.xL;
    }
}

class Problem {
    int n;
    Platforms[] platforms;

    public Problem(int n) {
        this.n = n;
        this.platforms = new Platforms[n];
    }

    public int solve() {
        int ans = 0;
        Arrays.sort(platforms);
        for(int i = 0; i < n; ++i) {
            int left = 0;
            int right = 0;

            for(int j = 0; j < n && platforms[j].xL < platforms[i].xR; ++j) {
                if(i == j) continue;
                if(platforms[j].xL <= platforms[i].xL && platforms[i].xL < platforms[j].xR) {
                    if(platforms[j].y < platforms[i].y && left < platforms[j].y)
                        left = platforms[j].y;
                }
                if(platforms[j].xL < platforms[i].xR && platforms[i].xR <= platforms[j].xR) {
                    if(platforms[j].y < platforms[i].y && right < platforms[j].y)
                        right = platforms[j].y;
                }
            }
            
            ans += 2 * platforms[i].y - left - right;
        }
        return ans;
    }
}

public class Baekjoon1276 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        
        for(int i = 0; i < problem.n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            problem.platforms[i] = new Platforms(x, y, len);
        }

        System.out.println(problem.solve());
    }
}
