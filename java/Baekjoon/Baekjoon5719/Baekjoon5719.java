import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int node;
    int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return (cost - o.cost);
    }
}

class Problem {
    private static final int DELETED = -1;
    private static final int INF = 987654321;

    private int end;
    private int start;
    private StringBuilder answer;
    private List<List<Integer>> prev;
    private List<List<Edge>> edgeList;

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
        answer = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());

            if (nodeSize == 0 && edgeSize == 0) {
                return;
            }
            prev = new ArrayList<>();
            edgeList = new ArrayList<>();
            for (int i = 0; i < nodeSize; ++i) {
                prev.add(new ArrayList<>());
                edgeList.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for (int i = 0; i < edgeSize; ++i) {
                st = new StringTokenizer(br.readLine());
                edgeList.get(Integer.parseInt(st.nextToken()))
                        .add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            makeAnswer();
        }
    }

    private void makeAnswer() {
        dijkstra();
        boolean[] visited = new boolean[edgeList.size()];
        deleteEdges(visited, end);
        int ans = dijkstra();
        if(ans == INF)  {
            answer.append(-1).append("\n");
        } else {
            answer.append(ans).append("\n");
        }
    }

    private int dijkstra() {
        Edge curr;
        int[] dist = new int[edgeList.size()];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            curr = pq.poll();

            for (Edge e: edgeList.get(curr.node)) {
                if (e.cost != DELETED) {
                    if (dist[curr.node] + e.cost < dist[e.node]) {
                        dist[e.node] = dist[curr.node] + e.cost;
                        prev.get(e.node).clear();
                        prev.get(e.node).add(curr.node);
                        pq.add(new Edge(e.node, dist[e.node]));
                    } else if (dist[curr.node] + e.cost == dist[e.node]) {
                        prev.get(e.node).add(curr.node);
                    }
                }
            }
        }
        return dist[end];
    }

    private void deleteEdges(boolean[] visited, int curr) {
        if (!visited[curr]) {
            visited[curr] = true;
            for (int pre : prev.get(curr)) {
                for (int i = 0; i < edgeList.get(pre).size(); ++i) {
                    if (edgeList.get(pre).get(i).node == curr) {
                        edgeList.get(pre).get(i).cost = DELETED;
                        deleteEdges(visited, pre);
                    }
                }
            }
        }
    }

    private void output() {
        System.out.print(answer.toString());
    }
}

public class Baekjoon5719 {
    public static void main(String[] args) {
        new Problem();
    }
}
