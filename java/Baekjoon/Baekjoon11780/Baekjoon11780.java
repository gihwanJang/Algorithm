import java.io.*;
import java.util.*;

class RouteInfo {
    int distance;
    List<Integer> nodes;

    public RouteInfo(int distance) {
        this.distance = distance;
        this.nodes = new ArrayList<>();
    }

    public RouteInfo(int distance, List<Integer> nodes) {
        this.nodes = nodes;
        this.distance = distance;
    }
}

class Problem {
    private int n;
    private int m;
    private RouteInfo[][] routeTable;

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
        m = Integer.parseInt(br.readLine());
        routeTable = new RouteInfo[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                routeTable[i][j] = new RouteInfo(987654321);
            }
        }
        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (routeTable[start][end].distance > distance) {
                routeTable[start][end].nodes.clear();
                routeTable[start][end].nodes.add(start);
                routeTable[start][end].nodes.add(end);
                routeTable[start][end].distance = distance;
            }
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();

        floydWarshall();
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                sb.append(routeTable[i][j].distance == 987654321 ? 0 : routeTable[i][j].distance).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                sb.append(routeTable[i][j].nodes.size()).append(" ");
                for (int k = 0; k < routeTable[i][j].nodes.size(); ++k) {
                    sb.append(routeTable[i][j].nodes.get(k)).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    private void floydWarshall() {
        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (i != j && routeTable[i][j].distance > routeTable[i][k].distance + routeTable[k][j].distance) {
                        routeTable[i][j].distance = routeTable[i][k].distance + routeTable[k][j].distance;
                        routeTable[i][j].nodes.clear();
                        for (int node : routeTable[i][k].nodes) {
                            routeTable[i][j].nodes.add(node);
                        }
                        for (int idx = 1; idx < routeTable[k][j].nodes.size(); ++idx) {
                            routeTable[i][j].nodes.add(routeTable[k][j].nodes.get(idx));
                        }
                    }
                }
            }
        }
    }
}

public class Baekjoon11780 {
    public static void main(String[] args) {
        new Problem();
    }
}
