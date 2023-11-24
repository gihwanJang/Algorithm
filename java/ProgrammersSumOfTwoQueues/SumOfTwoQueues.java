import java.util.*;

class Solution {
    long f, s;
    Deque<Integer> que1;
    Deque<Integer> que2;

    public int solution(int[] queue1, int[] queue2) {
        init(queue1, queue2);
        return makeSame();
    }

    private void init(int[] queue1, int[] queue2) {
        f = s = 0;
        que1 = new ArrayDeque<>();
        que2 = new ArrayDeque<>();

        for (int i = 0; i < queue1.length; ++i) {
            f += queue1[i];
            que1.add(queue1[i]);

            s += queue2[i];
            que2.add(queue2[i]);
        }
    }

    private int makeSame() {
        for (int cnt = 0; f != 0 && s != 0; ++cnt) {
            if (cnt > (que1.size() + que2.size()) * 2)
                return -1;

            if (f > s) {
                que2.add(que1.pollFirst());
                f -= que2.peekLast();
                s += que2.peekLast();
            } else if (f < s) {
                que1.add(que2.pollFirst());
                f += que1.peekLast();
                s -= que1.peekLast();
            } else {
                return cnt;
            }
        }
        return -1;
    }
}

public class SumOfTwoQueues {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] queue1 = { 3, 2, 7, 2 };
        int[] queue2 = { 4, 6, 5, 1 };
        System.out.println(solution.solution(queue1, queue2));
    }
}
