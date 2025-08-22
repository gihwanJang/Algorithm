import java.io.*;
import java.util.*;

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Point o) {
        int subX = o.x - x;
        int subY = o.y - y;
        return subX * subX + subY * subY;
    }

    public static Comparator<Point> compareWithX() {
        return new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        };
    }

    public static Comparator<Point> compareWithY() {
        return new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        };
    }

}

class Problem {

    int n;
    Point[] points;

    public Problem(int n) {
        this.n = n;
        this.points = new Point[n];
    }

    public int solve() {
        Arrays.sort(points, Point.compareWithX());
        return closestPair(0, n - 1);
    }

    private int closestPair(int l, int r) {
        if (r - l < 3) {
            int min = Integer.MAX_VALUE;

            for(int i = l; i < r; ++i) {
                for(int j = i + 1; j <= r; ++j) {
                    min = Math.min(min, points[i].getDistance(points[j]));
                }
            }
            return min;
        }

        int mid = l + (r - l) / 2;
        int min = Math.min(closestPair(l, mid), closestPair(mid + 1, r));
        int stripMin = stripClosest(l, r, mid, min);

        return Math.min(min, stripMin);
    }

    private int stripClosest(int l, int r, int mid, int min) {
        List<Point> stripList = new ArrayList<>();

        for (int i = mid; i >= l && doublePow(points[mid].x - points[i].x) < min; --i) {
            stripList.add(points[i]);
        }
        for (int i = mid+1; i <= r && doublePow(points[i].x - points[mid].x) < min; ++i) {
            stripList.add(points[i]);
        }
        Collections.sort(stripList, Point.compareWithY());
        for (int i = 0; i < stripList.size(); ++i) {
            for (int k = i + 1; k < stripList.size() && doublePow(stripList.get(k).y - stripList.get(i).y) < min; ++k) {
                min = Math.min(min, stripList.get(i).getDistance(stripList.get(k)));
            }
        }
        return min;
    }

    private int doublePow(int n) {
        return n * n;
    }

}

public class Baekjoon2261 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));

        for (int i = 0; i < p.n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            p.points[i] = new Point(x, y);
        }

        System.out.print(p.solve());
    }

}
