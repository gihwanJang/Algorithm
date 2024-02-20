import java.io.*;
import java.util.*;

class Node {
    int seq;
    int value;
    List<Node> children;

    public Node(int seq, int value) {
        this.seq = seq;
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addchild(Node node) {
        children.add(node);
    }
}

class Problem {
    int n;
    int root;
    int[][] memo;
    Node[] nodes;

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

        this.n = Integer.parseInt(st.nextToken());
        this.root = Integer.parseInt(st.nextToken()) - 1;
        this.memo = new int[n][n];
        this.nodes = new Node[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            if (nodes[left].value < nodes[right].value) {
                nodes[left].addchild(nodes[right]);
            } else {
                nodes[right].addchild(nodes[left]);
            }
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        int ret = nodes[root].value;

        for (Node node : nodes[root].children) {
            ret += DFS(root, node.seq);
        }
        return ret;
    }

    private int DFS(int special, int curr) {
        if (memo[special][curr] != 0) {
            return memo[special][curr];
        }

        int isSpecial = nodes[curr].value;
        int isNotSpecial = isSpecial - nodes[special].value;

        for (Node node : nodes[curr].children) {
            isSpecial += DFS(curr, node.seq);
            isNotSpecial += DFS(special, node.seq);
        }
        return memo[special][curr] = Math.min(isSpecial, isNotSpecial);
    }
}

public class Baekjoon1272 {
    public static void main(String[] args) {
        new Problem();
    }
}
