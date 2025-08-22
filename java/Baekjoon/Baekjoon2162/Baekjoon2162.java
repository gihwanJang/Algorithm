import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x, y;
    @Override
    public int compareTo(Point o) {
        if(x == o.x) return y - o.y;
        return x - o.x; 
    }
}

class Line {
    Point p1, p2;
    private int CCW(Point p3) {
        int ccw = ( p1.x*(p2.y - p3.y) + p2.x*(p3.y - p1.y) + p3.x*(p1.y - p2.y) );
        if(ccw > 0) return 1;
        if(ccw < 0) return -1;
        return 0;
    }
    public boolean isCrossed(Line o) {
        int basedThis = CCW(o.p1) * CCW(o.p2);
        int basedOther = o.CCW(p1) * o.CCW(p2);

        if(basedThis == 0 && basedOther == 0) {
            Point thisLo = p1.compareTo(p2) < 0 ? p1 : p2;
            Point thisHi = p1.compareTo(p2) < 0 ? p2 : p1;
            Point otherLo = o.p1.compareTo(o.p2) < 0 ? o.p1 : o.p2;
            Point otherHi = o.p1.compareTo(o.p2) < 0 ? o.p2 : o.p1;

            return (thisLo.compareTo(otherHi) <= 0 && otherLo.compareTo(thisHi) <= 0);
        }
        
        return (basedThis <= 0 && basedOther <= 0);
    }
}

class UnionFine {
    int[] nodes, count;
    public UnionFine(int n) {
        nodes = new int[n];
        count = new int[n];
        for(int i = 0; i < n; ++i) {
            nodes[i] = i;
        }
        Arrays.fill(count, 1);
    }
    public int find(int n) {
        if(nodes[n] == n) return n;
        return nodes[n] = find(nodes[n]);
    }
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;
        nodes[rootA] = rootB;
        count[rootB] += count[rootA];
    }
}

public class Baekjoon2162 {
    int size;
    UnionFine group;
    List<Line> lines;

    public Baekjoon2162(int n) {
        size = n;
        group = new UnionFine(n);
        lines = new ArrayList<>(n);
    }

    public void makeGroup() {
        for(int i = 0; i < size; ++i) {
            for(int j = i+1; j < size; ++j) {
                if(lines.get(i).isCrossed(lines.get(j))) {
                    group.union(i, j);
                }
            }
        }
    }

    public String solve() {
        int maxCount = 0;
        int groupCount = 0;
        StringBuilder sb = new StringBuilder();

        makeGroup();
        for(int i = 0; i < size; ++i) {
            if(group.nodes[i] == i) {
                ++groupCount;
                maxCount = Math.max(maxCount, group.count[i]);
            }
        }

        sb.append(groupCount);
        sb.append("\n");
        sb.append(maxCount);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Baekjoon2162 problem = new Baekjoon2162(Integer.parseInt(br.readLine()));
        
        for(int i = 0; i < problem.size; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problem.lines.add(new Line());

            problem.lines.get(i).p1 = new Point();
            problem.lines.get(i).p1.x = Integer.parseInt(st.nextToken());
            problem.lines.get(i).p1.y = Integer.parseInt(st.nextToken());

            problem.lines.get(i).p2 = new Point();
            problem.lines.get(i).p2.x = Integer.parseInt(st.nextToken());
            problem.lines.get(i).p2.y = Integer.parseInt(st.nextToken());
        }

        System.out.println(problem.solve());
    }
}