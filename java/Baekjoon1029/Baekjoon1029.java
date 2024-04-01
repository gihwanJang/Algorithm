import java.io.*;
import java.util.*;

class StackInfo {
    int cost;
    int node;
    int visited;

    public StackInfo(int cost, int node, int visited) {
        this.cost = cost;
        this.node = node;
        this.visited = visited;
    }

    @Override
    public boolean equals(Object obj) {
        StackInfo o = (StackInfo) obj;
        return (cost == o.cost && node == o.node && visited == o.visited);
    }

    @Override
    public int hashCode() {
        return cost * 31 * 31 + node * 31 + visited;
    }
}

class Problem {
    private int n;
    private int[][] map;

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
        map = new int[n][n];
        for (int i = 0; i < n; ++i) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        int ans = 1;
        StackInfo curr;
        Stack<StackInfo> stack = new Stack<>();
        HashSet<StackInfo> visited = new HashSet<>();

        stack.add(new StackInfo(0, 0, 1));
        while (!stack.isEmpty()) {
            curr = stack.pop();
            ans = Math.max(ans, getDepth(curr.visited));
            if (!visited.contains(curr)) {
                visited.add(curr);
                for (int i = 0; i < n; ++i) {
                    if ((curr.visited & (1 << i)) == 0 && map[curr.node][i] >= curr.cost) {
                        stack.add(new StackInfo(map[curr.node][i], i, curr.visited | 1 << i));
                    }
                }
            }
        }
        return ans;
    }

    private int getDepth(int visited) {
        int depth = 0;
        for (int i = 0; i < n; ++i) {
            if ((visited & (1 << i)) != 0) {
                ++depth;
            }
        }
        return depth;
    }
}

public class Baekjoon1029 {
    public static void main(String[] args) {
        new Problem();
    }
}
