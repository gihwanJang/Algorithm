class Solution {
    public int solution(int[] stones, int k) {
        int lo = 0, hi = 200_000_000, res = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (isValidate(stones, k, mid)) {
                lo = mid + 1;
                res = mid;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }

    private boolean isValidate(int[] stones, int k, int mid) {
        int count = 0;

        for (int i = 0; i < stones.length; ++i) {
            if (stones[i] < mid) {
                ++count;
                if (count >= k)
                    return false;
            } else {
                count = 0;
            }
        }

        return true;
    }
}

public class SteppingStone {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
        System.out.println(solution.solution(stones, 3));
    }
}