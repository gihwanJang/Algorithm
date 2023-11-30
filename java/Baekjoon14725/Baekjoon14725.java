import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    String name;
    TreeMap<String, Node> children;

    public Node(String name) {
        this.name = name;
        children = new TreeMap<>();
    }

    @Override
    public int compareTo(Node o) {
        return name.compareTo(o.name);
    }
}

class Problem {
    int n;
    Node root;
    List<List<String>> map;

    public Problem(int n) {
        this.n = n;
        map = new ArrayList<>(n);
        root = new Node("root");
        for(int i = 0; i  < n; ++i) {
            map.add(new ArrayList<>());
        }
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        makeTree();
        for(Node n : root.children.values()) {
            travle(n, sb, 0);
        }
        return sb.toString();
    }

    private void makeTree() {
        Node parent, curr;
        for(int r = 0; r < n; ++r) {
            parent = root;

            for(int c = 0; c < map.get(r).size(); ++c) {
                curr = new Node(map.get(r).get(c));
                if(parent.children.containsKey(curr.name)){
                    curr = parent.children.get(curr.name);
                } else {
                    parent.children.put(curr.name, curr);
                }
                parent = curr;
            }
        }
    }

    private void travle(Node n, StringBuilder sb, int depth) {
        sb.append("--".repeat(depth)).append(n.name).append("\n");
        for(Node node : n.children.values()) {
            travle(node, sb, depth+1);
        }
    }
}

public class Baekjoon14725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));

        for(int i = 0; i < problem.n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = Integer.parseInt(st.nextToken()); j > 0; --j) {
                problem.map.get(i).add(st.nextToken());
            }
        }

        System.out.println(problem.solve());
    }
}
