import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int m;
    private int size;
    private List<List<Integer>> graph;

    private int id;
    private boolean cnf;
    private int[] nodes;
    private boolean[] finished;
    private Deque<Integer> stack;
    private List<Set<Integer>> sccList;

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
        
        size = 2 * n + 1;
        graph = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            int[] notAb = new int[2];
            int[] ab = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

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
        nodes = new int[size];
        finished = new boolean[size];
        stack = new ArrayDeque<>();
        sccList = new ArrayList<>();

        for (int i = 1; i < size && cnf; ++i) {
            if (nodes[i] == 0) {
                dfs(i);
            }
        }

        if (cnf) {
            StringBuilder sb = new StringBuilder();
            sb.append(1).append("\n");
            
            int[] visitied = new int[n];
            Arrays.fill(visitied, -1);
            for (int i = sccList.size() - 1; i > -1; --i) {
                for (Integer node : sccList.get(i)) {
                    int curr = (node - 1) / 2;
                    if (visitied[curr] == -1) {
                        if (node % 2 == 0) {
                            visitied[curr] = 1;
                        } else {
                            visitied[curr] = 0;
                        }
                    }
                } 
            }
            for (int i = 0; i < n; ++i) {
                sb.append(visitied[i]).append(" ");
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(0);
        }
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

        if (parent == nodes[node]) {
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
            sccList.add(scc);
        }
        return parent;
    }
}

public class Baekjoon11281 {
    public static void main(String[] args) {
        new Problem();
    }
}
