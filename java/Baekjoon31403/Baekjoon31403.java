import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Problem {
    private String a;
    private String b;
    private String c;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        c = br.readLine();

        solve();
    }

    private void solve() {
        System.out.println(new BigInteger(a).add(new BigInteger(b)).subtract(new BigInteger(c)));
        System.out.println(new BigInteger(a + b).subtract(new BigInteger(c)));
    }
}

public class Baekjoon31403 {
    public static void main(String[] args) {
        new Problem();
    }
}
