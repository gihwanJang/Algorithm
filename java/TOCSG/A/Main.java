import java.io.*;
import java.math.*;

/**
 *
 * 투포인터를 사용하여 시작점 끝점에서 부터 가리키는 값이 같은지 비교하며 유효한지 판단
 * 제약 조건이 없으므로 BigInteger를 사용하여 Long 범위 밖의 입력 값도 처리 할 수 있도록 구현
 *
 * 시간 복잡도 O(n)
 * 소요 시간 16분
 *
 * @author : gihwanjang
 *
 */
class Problem {
    private BigInteger n;

    public Problem() {
        try {
            input();
            solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        n = new BigInteger(new BufferedReader(new InputStreamReader(System.in)).readLine());
    }

    private void solve() {
        StringBuilder sb = new StringBuilder();

        for (BigInteger num = new BigInteger("1"); num.compareTo(n) <= 0; num = num.add(BigInteger.ONE)) {
            if (isValid(num.toString())) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(num);
            }
        }
        System.out.println(sb.toString());
    }

    private boolean isValid(String num) {
        for (int l = 0, r = num.length()-1; l <= r; l++, r--) {
            if (num.charAt(l) != num.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] argc) {
        new Problem();
    }
}
