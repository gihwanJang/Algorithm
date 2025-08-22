import java.io.*;
import java.util.*;

class Problem {
    private int maxLevel;
    private int n, m;
    private int[] levels;
    private int[][] querys;
    private int[][][] parents;
    private List<List<int[]>> tree;

    public Problem() {
        try {
            input();
            initParents();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        maxLevel = 21;
        levels = new int[n + 1];
        parents = new int[n + 1][maxLevel][2];
        tree = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; ++i) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; ++i) {
            int[] edge = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            tree.get(edge[0]).add(new int[]{edge[1], edge[2]});
            tree.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        m = Integer.parseInt(br.readLine());
        querys = new int[m][2];
        for (int i = 0; i < m; ++i) {
            querys[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();
        // for (int r = 0; r <= n; ++r) {
        //     for (int l = 0; l < maxLevel; ++l) {
        //         System.out.print(parents[r][l][1] + ", ");
        //     }
        //     System.out.println("");
        // }
        for (int[] qurey: querys) {
            sb.append(lCA(qurey[0], qurey[1])).append("\n");
        }
        System.out.print(sb.toString());
    }

    private void dFS(int[] node, int level) {
        levels[node[0]] = level;
        for (int[] child : tree.get(node[0])) {
            if (parents[node[0]][0][0] != child[0]) {
                parents[child[0]][0][0] = node[0];
                parents[child[0]][0][1] = child[1];
                dFS(child, level + 1);
            }
        }
    }

    private void initParents() {
        dFS(new int[]{1, 0}, 0);
        for (int i = 1; i < 21; ++i) {
            for (int j = 1; j <= n; ++j) {
                parents[j][i][0] = parents[parents[j][i-1][0]][i-1][0];
                parents[j][i][1] = parents[j][i-1][1] + parents[ parents[j][i-1][0] ][i-1][1];
            }
        }
    }

    private int lCA(int a, int b) {
        int distance = 0;
        int target = a;
        int compare = b;

        if (levels[a] < levels[b]) {
            target = b;
            compare = a;
        }
        if (levels[target] != levels[compare]) {
            for (int i = maxLevel - 1; i >= 0; --i) {
                if (levels[parents[target][i][0]] >= levels[compare]) {
                    distance += parents[target][i][1];
                    target = parents[target][i][0];
                }
            }
        }
        if (target != compare) {
            for (int i = maxLevel - 1; i >= 0; --i) {
                if (parents[target][i][0] != parents[compare][i][0]) {
                    distance += parents[target][i][1];
                    distance += parents[compare][i][1];

                    target = parents[target][i][0];
                    compare = parents[compare][i][0];
                }
            }
            distance += parents[target][0][1];
            distance += parents[compare][0][1];
        }
        return distance;
    }
}

public class Baekjoon1761 {
    public static void main(String[] args) {
        new Problem();
    }
}
