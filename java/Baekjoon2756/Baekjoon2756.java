import java.io.*;
import java.math.BigDecimal;
import java.util.*;

class Problem {
    private static final StringBuilder SB = new StringBuilder();
    private static final BigDecimal[] BOUNDARY = {
        new BigDecimal(9),
        new BigDecimal(36),
        new BigDecimal(81),
        new BigDecimal(144),
        new BigDecimal(225)
    };

    private String[] dartLocs;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            dartLocs = br.readLine().split(" ");
            solve();
        }
        System.out.print(SB.toString());
    }

    private void solve() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < 6; i += 2) {
            a += getScore(new BigDecimal(dartLocs[i]).multiply(new BigDecimal(dartLocs[i]))
                    .add(new BigDecimal(dartLocs[i+1]).multiply(new BigDecimal(dartLocs[i+1]))));
        }
        for (int i = 6; i < 12; i += 2) {
            b += getScore(new BigDecimal(dartLocs[i]).multiply(new BigDecimal(dartLocs[i]))
                    .add(new BigDecimal(dartLocs[i+1]).multiply(new BigDecimal(dartLocs[i+1]))));
        }

        SB.append("SCORE: ").append(a).append(" to ").append(b).append(", ");
        if (a > b) {
            SB.append("PLAYER 1 WINS.");
        } else if (a < b) {
            SB.append("PLAYER 2 WINS.");
        } else {
            SB.append("TIE.");
        }
        SB.append("\n");
    }

    private int getScore(BigDecimal distance) {
        for (int i = 0; i < 5; ++i) {
            if (BOUNDARY[i].compareTo(distance) >= 0) {
                return 100 - i * 20;
            }
        }
        return 0;
    }
}

public class Baekjoon2756 {
    public static void main(String[] args) {
        new Problem();
    }
}
