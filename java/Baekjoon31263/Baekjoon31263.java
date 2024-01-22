import java.io.*;

class Problem {

    int n;
    String s;

    public Problem(int n, String s) {
        this.n = n;
        this.s = s;
    }

    public int solve() {
        int cnt = 0;

        while(n > 0) {
            int p = 0;
            for(int i = 1; i <= 3 && n - i >= 0; ++i) {
                if (s.charAt(n - i) != '0' && canCount(Integer.parseInt(s.substring(n - i, n)))) {
                    p = i;                    
                }
            }
            n -= p;
            ++cnt;
        }

        return cnt;
    }

    private boolean canCount(int n) {
        return (1 <= n && n <= 641); 
    }

}

public class Baekjoon31263 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()), br.readLine());

        System.out.println(p.solve());
    }

}
