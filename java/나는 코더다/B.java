import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    long x, y;

    public Point(long[] p) {
        x = p[0];
        y = p[1];
    }

    public long getDistance(Point o) {
        return (x - o.x) * (x - o.x) + (y - o.y) * (y - o.y);
    }

    @Override
    public int compareTo(Point o) {
        if (x > o.x) {
            return 1;
        } else if (x < o.x) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Problem {
    int n;
    Point[] points;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        points = new Point[n];
        for (int i = 0; i < n; ++i) {
            points[i] = new Point(Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray());
        }
    }

    private int solve() {
        int res = -1;
        Arrays.sort(points);

        int[] curr = {0,0};
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        Queue<int[]> que = new ArrayDeque<>();

        while (que.isEmpty()) {
            curr = que.poll();

            for () {
                
            }
        }
        return res;
    }

    private void output() {
        System.out.println(solve());
    }
}

public class B {
    public static void main(String[] args) {
        new Problem();
    }
}
