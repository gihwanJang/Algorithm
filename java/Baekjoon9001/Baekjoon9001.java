import java.io.*;
import java.util.*;

class Square {
    private int[] x;
    private int[] y;

    public Square(int[] p) {
        x = new int[]{p[0], p[2]};
        y = new int[]{p[1], p[3]};
    }

    public int getX(int idx) {
        return x[idx];
    }

    public int getY(int idx) {
        return y[idx];
    }

    public boolean isOverlap(Square o) {
        if (isOverlap(o.getX(0), o.getY(0))
            || isOverlap(o.getX(1), o.getY(1))
            || isOverlap(o.getX(0), o.getY(1))
            || isOverlap(o.getX(1), o.getY(0))) {
                return true;
        } else if (((x[0] <= o.getX(0) && o.getX(0) <= x[1]) || (x[0] <= o.getX(1) && o.getX(1) <= x[1]))
            && ((o.getY(0) <= y[0] && y[0] <= o.getY(1))|| (o.getY(0) <= y[1] && y[1] <= o.getY(1)))) {
            return true;
        } else if (((y[0] <= o.getY(0) && o.getY(0) <= y[1]) || (y[0] <= o.getY(1) && o.getY(1) <= y[1])) 
            && ((o.getX(0) <= x[0] && x[0] <= o.getX(1)) || (o.getX(0) <= x[1] && x[1] <= o.getX(1)))) {
            return true;
        }
        return false;
    }

    private boolean isOverlap (int px, int py) {
        return (x[0] <= px && px <= x[1]
                && y[0] <= py && py <= y[1]);
    }

    @Override
    public String toString() {
        return "[" + "x : " + Arrays.toString(x) + ", y : " + Arrays.toString(y) + "]";
    }
}

class UnionFind {
    private int[] perent;

    public UnionFind(int n) {
        perent = new int[n];
        for (int i = 0; i < n; ++i) {
            perent[i] = i;
        }
    }

    public int find(int i) {
        if (perent[i] == i) {
            return i;
        }
        return perent[i] = find(perent[i]);
    }

    public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        perent[aRoot] = bRoot;
    }

    public int getGroupCount() {
        int count = 0;
        for (int i = 0; i < perent.length; ++i) {
            if (perent[i] == i) {
                ++count;
            }
        }
        return count;
    }
}

class Problem {
    private int n;
    private StringBuilder sb;
    private Square[] squares;
    private UnionFind group;

    public Problem() {
        sb = new StringBuilder();
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            n = Integer.parseInt(br.readLine().trim());
            squares = new Square[n];
            group = new UnionFind(n);
            for (int i = 0; i < n; ++i) {
                squares[i] = new Square(Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray());
            }
            sb.append(solve()).append("\n");
        }
    }

    private int solve() {
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (squares[i].isOverlap(squares[j]) || squares[j].isOverlap(squares[i])) {
                    group.union(i, j);
                }
            }
        }
        return group.getGroupCount();
    }

    private void output() {
        System.out.print(sb.toString());
    }
}

public class Baekjoon9001 {
    public static void main(String[] args) {
        new Problem();
    }
}
