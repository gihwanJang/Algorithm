import java.io.*;
import java.util.*;

class Schedule implements Comparable<Schedule> {
    int s, e, idx;

    public Schedule(String idx, String s, String e) {
        this.idx = Integer.parseInt(idx);
        this.s = Integer.parseInt(s);
        this.e = Integer.parseInt(e);
    }

    @Override
    public int compareTo(Schedule o) {
        return s - o.s;
    }
}

class Room implements Comparable<Room> {
    int idx, e;

    public Room(int idx, int e) {
        this.idx = idx;
        this.e = e;
    }

    @Override
    public int compareTo(Room o) {
        return e - o.e;
    }
}

class Problem {
    int n;
    int[] batch;
    Schedule[] schedules;

    public Problem(int n) {
        this.n = n;
        batch = new int[n+1];
        schedules = new Schedule[n];
    }

    public String solve() {
        Arrays.sort(schedules);
        return getRet(batchSchedule());
    }

    private int batchSchedule() {
        Room curr;
        int roomNum = 1;
        PriorityQueue<Room> pq = new PriorityQueue<>();

        pq.add(new Room(roomNum, schedules[0].e));
        batch[schedules[0].idx] = roomNum;
        for(int i = 1; i < n; ++i) {
            curr = pq.poll();

            if(curr.e <= schedules[i].s) {
                pq.add(new Room(curr.idx, schedules[i].e));
                batch[schedules[i].idx] = curr.idx;
            } else {
                pq.add(curr);
                pq.add(new Room(++roomNum, schedules[i].e));
                batch[schedules[i].idx] = roomNum;
            }
        }

        return pq.size();
    }

    private String getRet(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num).append("\n");
        for(int i = 1; i <= n; ++i) {
            sb.append(batch[i]).append("\n");
        }
        return sb.toString();
    }
}

public class Baekjoon1379 {
    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));

        for(int i = 0; i < p.n; ++i) {
            st = new StringTokenizer(br.readLine());
            p.schedules[i] = new Schedule(st.nextToken(), st.nextToken(), st.nextToken());
        }

        System.out.print(p.solve());
    }
}