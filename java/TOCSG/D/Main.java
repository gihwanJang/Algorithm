import java.io.*;
import java.util.*;

/**
 *
 * 토너먼트 경기에서 고정된 경기 결과 외의 경기들을 시뮬레이션하여
 * 특정 선수가 우승할 수 있는 경우의 수를 백트래킹을 통해 계산한다.
 *
 * - nmk[0] : 참가자 수 N
 * - nmk[1] : 경기 수 M
 * - nmk[2] : 목표 선수 번호 (우승해야 하는 선수)
 *
 * - score[] : 각 참가자의 승리 횟수 저장
 * - schedule : 아직 결과가 정해지지 않은 경기 리스트 (길이 3, [A, B, 0])
 *
 * 시간 복잡도 : O(2^k), k = 결과 미정인 경기 수
 * 소요 시간 : 32분
 *
 * @author : gihwanjang
 *
 */
class Problem {
    private int[] nmk, score;
    private List<int[]> schedule;

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
        nmk = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        score = new int[nmk[0]+1];
        schedule = new ArrayList<>(nmk[1]);
        for (int i = 0; i < nmk[1]; ++i) {
            int[] r = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (r[2] == 1) {
                ++score[r[0]];
            } else if (r[2] == 2) {
                ++score[r[1]];
            } else {
                schedule.add(r);
            }
        }
    }

    private void solve() {
        System.out.println(play(0));
    }

    private int play(int depth) {
        if (depth == schedule.size()) {
            return isWin();
        }

        int cnt = 0;

        for (int i = 0; i < 2; ++i) {
            ++score[schedule.get(depth)[i]];
            schedule.get(depth)[2] = i+1;
            cnt += play(depth+1);
            --score[schedule.get(depth)[i]];
        }
        return cnt;
    }

    private int isWin() {
        int winner = 0;
        int candidate = 0;

        for (int i = 1; i <= nmk[0]; ++i) {
            if (score[i] >= score[winner]) {
                candidate = winner;
                winner = i;
            }
        }
        if (winner == nmk[2] && score[winner] != score[candidate]) {
            return 1;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        new Problem();
    }
}
