import java.io.*;
import java.util.*;

class Problem {
    int size, dp[][];
    List<List<Integer>> adj, graph;

    public Problem(int n) {
        size = n;

        dp = new int[2][size];
        adj = new ArrayList<>(size);
        graph = new ArrayList<>(size);

        setList(adj);
        setList(graph);
    }
    public int solve() {
        makeAdj(0, -1);
        return Math.min(findRes(0, 0), findRes(0, 1));
    }

    private void setList(List<List<Integer>> list) {
        for(int i = 0; i < size; ++i)
            list.add(new ArrayList<>());
    }
    private void makeAdj(int curr, int prev) {
        for(int next : graph.get(curr))
            if(next != prev){
                adj.get(curr).add(next);
                makeAdj(next, curr);
            }
    }
    private int findRes(int curr, int type) {
        if(dp[type][curr] != 0) return dp[type][curr];
        int res = 0;

        if (type == 1)
            for (int next : adj.get(curr))
                res += Math.min(findRes(next, 0), findRes(next, 1));
        else
            for(int next : adj.get(curr))
                res += findRes(next, 1);

        return dp[type][curr] = res + type;
    }
}

public class Baekjoon2533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Integer.parseInt(st.nextToken()));

        for(int i = 1, s, e; i < problem.size; ++i) {
            st = new StringTokenizer( br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            problem.graph.get(s).add(e);
            problem.graph.get(e).add(s);
        }

        System.out.println(problem.solve());
    }
}