import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class UnionFind {
    int[] parent;

    public UnionFind(int cnt) {
        parent = new int[cnt];
        IntStream.range(0, cnt)
                .forEach(i -> parent[i] = i);
    }

    public int find(int  node) {
        if (node == parent[node]) {
            return node;
        }
        return (parent[node] = find(parent[node]));
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootB] = rootA; 
    }
}

class Problem {
    private int n, m;
    private boolean[][] map;
    private UnionFind unionFind;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][n];
        unionFind = new UnionFind(n);
        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            for (int j = 0; j < n; ++j) {
                if (line.charAt(j) == 'Y') {
                    map[i][j] = true;
                }
            }
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private String solve() {
        int count = 0;
        int[] counts = new int[n];
        StringBuilder sb = new StringBuilder();

        Arrays.fill(counts, 0);
        for (int r = 0; r < n; ++r) {
            for (int c = r + 1; c < n; ++c) {
                if (map[r][c] && (unionFind.find(c) != unionFind.find(r))) {
                    ++count;
                    unionFind.union(r, c);
                    map[r][c] = false;
                    ++counts[r];
                    ++counts[c];
                }
            }
        }
        //System.out.println(Arrays.toString(unionFind.parent));
        if (count != n-1) {
            return "-1";
        } else if (count == m) {
            for (int i = 0; i < n; ++i) {
                sb.append(counts[i]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        for (int r = 0; r < n; ++r) {
            for (int c = r+1; c < n; ++c) {
                if (map[r][c]) {
                    ++count;
                    ++counts[r];
                    ++counts[c];
                }
                if (count == m) {
                    for (int i = 0; i < n; ++i) {
                        sb.append(counts[i]).append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    return sb.toString();
                }
            }
        }
        return "-1";
    }
}

public class Baekjoon1045 {
    public static void main(String[] args) {
        new Problem();
    }
}
