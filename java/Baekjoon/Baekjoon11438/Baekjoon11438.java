import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem {
    private int maxLevel;
    private int n, m;
    private int[] levels;
    private int[][] qureys;
    private int[][] parents;
    private List<List<Integer>> tree;
    private StringBuilder sb;

    public Problem() {
        try {
            input();
            setTree();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        maxLevel = 21;
        levels = new int[n + 1];
        parents = new int[n + 1][maxLevel];
        tree = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; ++i) {
            int[] edge = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        m = Integer.parseInt(br.readLine());
        qureys = new int[m][2];
        for (int i = 0; i < m; ++i) {
            qureys[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        sb = new StringBuilder();
        for (int[] qurey : qureys) {
            sb.append(lCA(qurey[0], qurey[1])).append("\n");
        }
        System.out.print(sb.toString());
    }

    private void dFS(int node, int level) {
        levels[node] = level;
        for (int child : tree.get(node)) {
            if (parents[node][0] != child) {
                parents[child][0] = node;
                dFS(child, level + 1);
            }
        }
    }

    private void setTree() {
        dFS(1, 0);
        for(int i = 1; i < maxLevel; ++i) {
            for(int j = 1; j <= n; ++j) {
                parents[j][i] = parents[parents[j][i-1]][i-1];
            }
        }
    }

    private int lCA(int a, int b) {
        if (a == 1 || b == 1) {
            return 1;
        }

        int target = a;
        int compare = b;
        if (levels[a] < levels[b]) {
            target = b;
            compare = a;
        }

        if (levels[target] != levels[compare]) {
            for (int i = maxLevel-1; i >= 0; i--) {
                if (levels[parents[target][i]] >= levels[compare]) {
                    target = parents[target][i];
                }
            }
        }
        int ret = target;
        if (target != compare) {
            for (int i = maxLevel-1; i >= 0; i--) {
                if (parents[target][i] != parents[compare][i]) {
                    target = parents[target][i];
                    compare = parents[compare][i];
                }
                ret = parents[target][i];
            }
        }
        return ret;
    }
}

public class Baekjoon11438 {
    public static void main(String[] args) {
        new Problem();
    }
}
