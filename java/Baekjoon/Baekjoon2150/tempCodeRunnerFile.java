import java.io.*;
import java.util.*;

class Problem {
    private int v;
    private int e;
    private List<List<Integer>> graph;

    private int id;
    private int[] nodes;
    private boolean[] finished;
    private Deque<Integer> stack;
    private List<List<Integer>> sccList;

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
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(v);
        for (int i = 0; i < v; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; ++i) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken()) - 1).add(Integer.parseInt(st.nextToken()) - 1);
        }

        solve();
    }

    private void solve() {
        StringBuilder sb = new StringBuilder();

        id = -1;
        nodes = new int[v];
        finished = new boolean[v];
        stack = new ArrayDeque();
        sccList = new ArrayList<>();

        for (int i = 0; i < v; ++i) {
            if (!finished[i]) {
                dfs(i);
            }
        }
        sb.append(sccList.size()).append("\n");
        sccList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });
        for (List<Integer> scc : sccList) {
            scc.sort(null);
            for (int node : scc) {
                sb.append(node + 1).append(" ");
            }
            sb.append(-1).append("\n");
        }
        System.out.print(sb.toString());
    }

    private int dfs(int node) {
        nodes[node] = ++id;
        stack.push(node);

        int parent = nodes[node];
        for (int child : graph.get(node)) {
            if(nodes[child] == 0) {
                parent = Math.min(parent, dfs(child));
            } else if (!finished[child]) {
                parent = Math.min(parent, nodes[child]);
            }
        }

        if (parent == nodes[node]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int top = stack.pop();
                scc.add(top);
                finished[top] = true;
                if (top == node) {
                    break;
                }
            }
            sccList.add(scc);
        }
        return parent;
    }
}

public class Baekjoon2150 {
    public static void main(String[] args) {
        new Problem();
    }
}
