import java.io.*;
import java.util.*;

class Problem  {
    private int[] lkc;
    private int[] nums;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lkc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve();
    }

    private void solve() {
        Arrays.sort(nums);

        int firstCutPoint = -1;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(lkc[0]);
        for (int i = 0; i < lkc[2]; ++i) {
            int curr = pq.poll();

            int[] cutPoints = findNearNumber(curr/2);
            // System.out.println(curr  + Arrays.toString(cutPoints));
            if (cutPoints.length == 1 && nums[cutPoints[0]] < curr) {
                pq.add(nums[cutPoints[0]]);
                pq.add(curr - nums[cutPoints[0]]);
            } else {
                if (nums[cutPoints[1]] < curr) {
                    if (Math.abs(nums[cutPoints[0]] - curr/2) == Math.abs(nums[cutPoints[1]] - curr/2) ||
                        Math.abs(nums[cutPoints[0]] - curr/2) < Math.abs(nums[cutPoints[1]] - curr/2)
                    ) {
                        pq.add(nums[cutPoints[0]]);
                        pq.add(curr - nums[cutPoints[0]]);
                    } else {
                        pq.add(nums[cutPoints[1]]);
                        pq.add(curr - nums[cutPoints[1]]);
                        if (i == 0) {
                            firstCutPoint = nums[cutPoints[1]];
                        }
                    }
                } else if (nums[cutPoints[0]] < curr) {
                    pq.add(nums[cutPoints[0]]);
                    pq.add(curr - nums[cutPoints[0]]);
                } else {
                    pq.add(curr);
                }
            }

            if (firstCutPoint == -1) {
                firstCutPoint = nums[cutPoints[0]];
            }
        }
        sb.append(pq.poll()).append(' ').append(firstCutPoint);
        System.out.println(sb.toString());
    }

    private int[] findNearNumber(int target) {
        int lo = 0;
        int hi = lkc[1] - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < target) {
                lo = mid+1;
            } else if (nums[mid] > target) {
                hi = mid-1;
            } else {
                return new int[]{mid};
            }
        }
        if (hi < 0) {
            return new int[]{lo};
        } else if (lo > lkc[1] - 1) {
            return new int[]{hi};
        } else {
            return new int[]{hi, lo};
        }
    }
}

public class Baekjoon1114 {
    public static void main(String[] args) {
        new Problem();
    }
}
