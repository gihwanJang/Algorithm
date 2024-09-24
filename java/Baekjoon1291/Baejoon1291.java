import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Problem {
    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solve(Integer.parseInt(br.readLine()));
    }

    private void solve(int n) {
        boolean lee = isLeemyeonsu(n);
        boolean leam = isLeamhyeonsu(n);

        // if (lee) {
        //     System.out.println("이면수 입니다.");
        // }
        // if (leam) {
        //     System.out.println("임현수 입니다.");
        // }

        if (lee) {
            if (leam) {
                System.out.println(4);
                return;
            }
            System.out.println(1);
            return;
        } else if (leam) {
            System.out.println(2);
            return;
        }
        System.out.println(3);
    }

    private boolean isLeemyeonsu(int n) {
        if (n < 6) {
            return false;
        }
        int digitSum = 0;

        for (int num = n; num > 0; num /= 10) {
            digitSum += (num % 10);
        }
        return (digitSum % 2 == 1);
    }

    private boolean isLeamhyeonsu(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n == 4) {
            return true;
        } else if (BigInteger.valueOf(n).isProbablePrime(3000)) {
            return false;
        }

        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (n % i == 0 && BigInteger.valueOf(i).isProbablePrime(3000)) {
                while (n % i != 0) {
                    n /= i;
                }
                ++count;
            }
        }

        return (count % 2 == 0);
    }
}

public class Baejoon1291 {
    public static void main(String[] args) {
        new Problem();
    }
}
