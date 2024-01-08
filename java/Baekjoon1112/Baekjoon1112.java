import java.io.*;
import java.util.*;

class Problem {
    int x, b;

    public Problem(String x, String b) {
        this.x = Integer.parseInt(x);
        this.b = Integer.parseInt(b);
    }

    public String solve() {
        if(b > 0) {
            return Integer.toString(x, b);
        }
        return toNegativeBase(x, b);
    }

    private String toNegativeBase(int n, int negBase) {
        if (n == 0)
            return "0";
    
        StringBuilder converted = new StringBuilder();
        while (n != 0) {
            int remainder = n % negBase;
            n /= negBase;
    
            if (remainder < 0) {
                remainder += (-negBase);
                n += 1;
            }
    
            converted.append(remainder);
        }
        converted.reverse();
        return converted.toString();
    }
}

public class Baekjoon1112 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(st.nextToken(), st.nextToken());
        System.out.println(p.solve());
    }
}
