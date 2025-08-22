import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Edge implements Comparable<Edge> {
    private int n, v;

    public Edge(int n, int v) {
        this.n = n;
        this.v = v;
    }

    public int getNode() {
        return n;
    }

    public int getValue() {
        return v;
    }

    @Override 
    public int compareTo(Edge o) {
        return o.v - v;
    }
}

class Problem {
    private int n;
    private Edge startNode;
    private List<List<Edge>> tree;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        startNode = new Edge(n, 0);
        tree = new ArrayList<>();
        IntStream.range(0, n)
                .forEach(i -> tree.add(new ArrayList<>()));
        for (int i = 1; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());

            tree.get(l).add(new Edge(r, v));
            tree.get(r).add(new Edge(l, v));
            if (startNode.getValue() < v) {
                startNode = new Edge(r, v);
            }
        }
    }

    private void output() {
        System.out.println(dijkstra());
    }

    private int dijkstra() {
        Edge curr;
        int[] distance = new int[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new Edge(startNode.getNode(), 0));
        distance[startNode.getNode()] = 0;
        while (!pq.isEmpty()) {
            curr = pq.poll();

            for (Edge next : tree.get(curr.getNode())) {
                if (curr.getValue() + next.getValue() < distance[next.getNode()]) {
                    distance[next.getNode()] =  curr.getValue() + next.getValue();
                    pq.add(new Edge(next.getNode(), curr.getValue() + next.getValue()));
                }
            }
        }
        //System.out.println(Arrays.toString(distance));
        Arrays.sort(distance);
        return distance[n-2];
    }
}

public class Baekjoon19581 {
    public static void main(String[] args) {
        new Problem();
    }
}
