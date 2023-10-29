import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start, end, value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return value - o.value;
    }
}

class UnionFind {
    int size;
    int[] nodes;

    public UnionFind(int n) {
        this.size = n;
        nodes = new int[n];
        for(int i = 0; i < n; ++i)
            nodes[i] = i;
    }

    public int find(int n) {
        if (nodes[n] == n) return n;
        return nodes[n] = find(nodes[n]);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        nodes[rootA] = rootB;
    }
}

public class Baekjoon2887 {
    UnionFind set;
    PriorityQueue<Edge> pq;

    public Baekjoon2887(List<int[]> points) {
        pq = new PriorityQueue<>();
        set = new UnionFind(points.size());
        makeEdge(points);
    }

    private void makeEdge(List<int[]> points) {
        for(int i = 1; i < 4; ++i) {
            int v = i;
            Collections.sort(points, (o1,o2) -> (o1[v] - o2[v]));
            for(int j = 1; j < points.size(); ++j) {
				int[] p1 = points.get(j-1);
				int[] p2 = points.get(j);
				int dis = Math.abs(p1[v]-p2[v]);
			
				pq.add(new Edge(p1[0], p2[0], dis));
			}
        }
    }

    public int solve() {
        int cost = 0;

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();

            if(set.find(curr.start) != set.find(curr.end)) {
                set.union(curr.start, curr.end);
                cost += curr.value;
            }
        }

        return cost;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon2887 problem;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> points = new ArrayList<>(n);

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] point = new int[4];
            point[0] = i;
            point[1] = Integer.parseInt(st.nextToken());
            point[2] = Integer.parseInt(st.nextToken());
            point[3] = Integer.parseInt(st.nextToken());
            points.add(point);
        }

        problem = new Baekjoon2887(points);
        System.out.println(problem.solve());
    }
}