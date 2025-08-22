import java.io.*;
import java.util.*;
import java.math.*;

class Problem {
    BigInteger a, b;
    public Problem(long a, long b) {
        this.a = new BigInteger(String.valueOf(a));
        this.b = new BigInteger(String.valueOf(b));
    }
    public String solve() {
        StringBuilder sb = new StringBuilder();
        for(long i = a.gcd(b).longValue(); i > 0; --i) {
            sb.append('1');
        }
        return sb.toString();
    }
}

public class Baekjoon1850 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        System.out.println(p.solve());
    }
}
