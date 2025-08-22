import java.io.*;
import java.util.*;

class SectionValue implements Comparable<SectionValue> {
    int lo, hi, cnt;
    long point;

    public SectionValue(int lo, int hi, int cnt) {
        int sub = hi - lo - 1;
        this.lo = lo;
        this.hi = hi;
        this.cnt = cnt;
        this.point = (long)cnt * (sub - cnt + 1) - 1;
    }

    public int[] getNext() {
        return new int[]{lo + cnt, hi - cnt};
    }

    @Override
    public int compareTo(SectionValue o) {
        if (point == o.point)
            return lo - o.lo;
        else {
            if(point > o.point) return 1;
            else return -1;
        }
    }
}

class Problem {
    int l;
    int[] nums;
    PriorityQueue<SectionValue> pq;

    public Problem(int l) {
        this.l = l;
        nums = new int[l + 1];
        pq = new PriorityQueue<>();
    }

    public String solve(int n) {
        SectionValue value;
        StringBuilder sb = new StringBuilder();
        Arrays.sort(nums);

        for(int i = 1; i <= l && n > 0; ++i, --n) {
            if(nums[i] - nums[i-1] == 2) {
                sb.append(nums[i] - 1).append(" ");
                --n;
            }
            if(n > 0) {
                sb.append(nums[i]).append(" ");
            }
        }

        makeSection();
        while(n > 0 && !pq.isEmpty()) {
            value = pq.poll();
            int[] next = value.getNext();
            //System.out.println("value : " + next[0] + "," + next[1] + " point : " + value.point);
            for(int i = (next[0] == next[1] ? 1 : 0); i < 2 && n > 0; ++i, --n) {
                sb.append(next[i]).append(" ");
            }
            if(next[1] - next[0] > 1){
                pq.add(new SectionValue(value.lo, value.hi, value.cnt+1));
            }
        }

        for(int i = nums[l] + 1; n > 0; ++i, --n) {
            sb.append(i).append(" ");
        }

        return sb.toString();
    }

    private void makeSection() {
        for(int i = 0; i < l; ++i) {
            if(nums[i+1] - nums[i] > 2)
                pq.add(new SectionValue(nums[i], nums[i+1], 1));
        }
    }
}

public class Baekjoon1060 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= problem.l; ++i) {
            problem.nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(problem.solve(Integer.parseInt(br.readLine())));
    }
}
