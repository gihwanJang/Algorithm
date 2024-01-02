import java.io.*;
import java.util.*;

class Schedule implements Comparable<Schedule> {
    int s, e;
    public Schedule(int s, int e) {
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Schedule o) {
        if(s == o.s) {
            return e - o.e;
        }
        return s - o.s;
    }
}

class Problem {
    int n;
    Schedule[] schedules;
    PriorityQueue<Integer> pq;
    public Problem(int n) {
        this.n = n;
        schedules = new Schedule[n];
        pq = new PriorityQueue<>();
    }
    public int solve() {
        int curr;
        Arrays.sort(schedules);
        pq.add(schedules[0].e);
        for(int i = 1; i < n; ++i) {
            curr = pq.poll();
            if(curr <= schedules[i].s) {
                curr = schedules[i].e;
            } else {
                pq.add(schedules[i].e);
            }
            pq.add(curr);
        }
        return pq.size();
    }
}

public class Baekjoon11000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));
        for(int i = 0; i < p.n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            p.schedules[i] = new Schedule(s, e);
        }
        System.out.println(p.solve());
    }
}
