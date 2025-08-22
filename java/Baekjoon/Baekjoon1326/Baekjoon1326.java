import java.io.*;
import java.util.*;

class Location {
    int idx, cnt;

    public Location(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}

class Problem {
    int n, start, end;
    int[] nums, distance;

    public Problem(int n) {
        this.n = n;
        nums = new int[n];
        distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
    }

    public int solve() {
        Location curr;
        Queue<Location> que = new ArrayDeque<>();

        que.add(new Location(start, 0));

        while(!que.isEmpty()) {
            curr = que.poll();

            if(curr.cnt < distance[curr.idx]) {
                distance[curr.idx] = curr.cnt;
                
                for(int i = 1; i < 10_000; ++i) {
                    if(curr.idx + i * nums[curr.idx] < n) {
                        que.add(new Location(curr.idx + i * nums[curr.idx], curr.cnt+1));
                    }
                    if(curr.idx - i * nums[curr.idx] >= 0) {
                        que.add(new Location(curr.idx - i * nums[curr.idx], curr.cnt+1));
                    }
                }
            }
        }

        return distance[end] == Integer.MAX_VALUE ? -1 : distance[end];
    }
}

public class Baekjoon1326 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < problem.n; ++i) {
            problem.nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        problem.start = Integer.parseInt(st.nextToken())-1;
        problem.end = Integer.parseInt(st.nextToken())-1;

        System.out.println(problem.solve());
    }
}
