import java.io.*;

/**
 *
 * 입력받은 수가 0이면 "INSOMNIA" 출력
 * 그렇지 않으면 수에 1, 2, 3, ...을 곱해가며 자릿수에 등장하는 숫자 추적
 * 0~9까지 모든 숫자가 등장한 첫 번째 결과를 출력
 *
 * 시간 복잡도 : O(n * k), n = 입력 개수, k = 등장하는 곱 횟수 (보통 100 이하)
 * 소요 시간 : 28분
 *
 * @author : gihwanjang
 *
 */
class Problem {
    private static final StringBuilder SB = new StringBuilder();

    private int nums[];

    public Problem() {
        try {
            input();
            for (int i = 0; i < nums.length; ++i) {
                solve(i);
            }
            System.out.print(SB.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = new int[Integer.parseInt(br.readLine())];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    }

    private void solve(int seq) {
        SB.append("Case #").append(seq).append(": ");
        if (nums[seq] == 0) {
            SB.append("INSOMNIA").append("\n");
            return;
        }

        int trackCnt = 0;
        boolean[] visited = new boolean[10];

        for (int i = 1; trackCnt < 10; ++i) {
            int name = i * nums[seq];

            for (int digit = name; digit > 0; digit /= 10) {
                if (!visited[digit % 10]) {
                    visited[digit % 10] = true;

                    if (++trackCnt == 10) {
                        SB.append(name).append("\n");
                        return;
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new Problem();
    }
}