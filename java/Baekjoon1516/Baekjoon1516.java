import java.io.*;
import java.util.*;

class Node {
    int time, in, prev;
    List<Integer> out;

    public Node() {
        this.in = 0;
        this.prev = 0;
        out = new ArrayList<>();
    }

    public void add(int node) {
        out.add(node);
    }
}

class Problem {
    List<Node> buildings;

    public String solve() {
        StringBuilder sb = new StringBuilder();
        build();
        for(Node n : buildings) sb.append(n.time).append("\n");
        return sb.toString();
    }

    private void build() {
        Node curr;
        Queue<Node> que = new ArrayDeque<>();
        for(Node b : buildings)
            if(b.in == 0) que.add(b);

        while(!que.isEmpty()) {
            curr = que.poll();
            curr.time += curr.prev;

            for(int idx : curr.out) {
                buildings.get(idx).prev = Math.max(buildings.get(idx).prev, curr.time);
                if(--buildings.get(idx).in == 0) que.add(buildings.get(idx));
            }
        }
    }
}

public class Baekjoon1516 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        Problem problem = new Problem();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        problem.buildings = new ArrayList<>(n);
        for(int i = 0; i < n; ++i) problem.buildings.add(new Node());
        
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            problem.buildings.get(i).time = Integer.parseInt(st.nextToken());

            while (true) {
                int idx = Integer.parseInt(st.nextToken());
                if(idx == -1) break;
                ++problem.buildings.get(i).in;
                problem.buildings.get(idx-1).add(i);
            }
        }

        System.out.print(problem.solve());
    }
}
