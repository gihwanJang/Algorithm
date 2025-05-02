import java.io.*;

/**
 *
 * a-z까지의 visited 배열을 사용하여 사용된 문자 판별 및 카운팅
 * StringBuilder를 사용하여 문자열 가공
 *
 * 시간 복잡도 : O(n)
 * 소요 시간 : 12분
 *
 * @author : gihwanjang
 *
 */
class Problem {
    private String[] in;

    public Problem() {
        try {
            input();
            solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine().split(" ");
    }

    private void solve() {
        int duplicatedCnt = 0;
        boolean[] charTable = new boolean[26];
        StringBuilder sb = new StringBuilder(in[0]);

        for (char c : in[1].toCharArray()) {
            if (charTable[c - 'a']) {
                ++duplicatedCnt;
            } else {
                charTable[c - 'a'] = true;
                sb.append(c);
            }
        }
        sb.append(duplicatedCnt);
        sb.reverse();
        System.out.println("ilovenam_" + sb.toString());
    }
}

public class Main {
    public static void main(String[] args) {
        new Problem();
    }
}
