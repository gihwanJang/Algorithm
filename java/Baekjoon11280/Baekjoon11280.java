import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int m;
    private List<List<Integer>> graph;

    private int size;
    private int id;
    private int[] nodes;
    private boolean[] finished;
    private Deque<Integer> stack;
    private boolean cnf;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        size = n * 2 + 1;
        graph = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] notAb = new int[2];

            for (int j = 0; j < 2; ++j) {
                if (ab[j] < 0) {
                    ab[j] = (-ab[j]) * 2;
                    notAb[j] = ab[j] - 1;
                } else {
                    ab[j] = ab[j] * 2 - 1;
                    notAb[j] = ab[j] + 1;
                }
            }

            graph.get(notAb[0]).add(ab[1]);
            graph.get(notAb[1]).add(ab[0]);
        }

        solve();
    }

    private void solve() {
        id = 0;
        cnf = true;
        stack = new ArrayDeque<>();
        nodes = new int[size];
        finished = new boolean[size];

        for (int i = 1; i < size && cnf; ++i) {
            if (nodes[i] == 0) {
                dfs(i);
            }
        }

        System.out.println(cnf ? 1 : 0);
    }

    private int dfs(int node) {
        nodes[node] = ++id;
        stack.push(node);

        int parent = nodes[node];
        for (int next : graph.get(node)) {
            if (nodes[next] == 0) {
                parent = Math.min(parent, dfs(next));
            } else if (!finished[next]) {
                parent = Math.min(parent, nodes[next]);
            }
        }

        if (nodes[node] == parent) {
            Set<Integer> scc = new HashSet<>();
            while (true) {
                int top = stack.pop();
                scc.add(top);
                finished[top] = true;
                if (scc.contains(top + (top % 2 == 0 ? -1 : 1))) {
                    cnf = false;
                }
                if (top == node) {
                    break;
                }
            }
        }
        return parent;
    }
}

public class Baekjoon11280 {
    public static void main(String[] args) {
        new Problem();
    }
}
