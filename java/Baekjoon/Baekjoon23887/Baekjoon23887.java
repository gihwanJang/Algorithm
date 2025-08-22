import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int id;
    private int x;
    private int y;
    private int level;
    private int count;
    private TreeSet<Node> children;

    public Node(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.level = 0;
        this.count = 0;
        this.children = new TreeSet<>();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public TreeSet<Node> getChildren() {
        return children;
    }

    public int compareTo(Node o) {
        if (this.level == o.getLevel()) {
            return this.id - o.getId();
        }
        return this.level - o.getLevel();
    }

    @Override
    public String toString() {
        return "{\n id :" + id + "\nchildren : " + Arrays.toString(children.stream().mapToInt(i->i.getId()).toArray()) + "\n}";
    }
}

class Tree {
    private static final int[] DX = {1,-1,0,0,1,-1,1,-1};
    private static final int[] DY = {0,0,-1,1,1,1,-1,-1};

    private int root;
    private int[][] map;
    private TreeMap<Integer, Node> tree;

    public Tree(int n, int m) {
        this.map = new int[n+1][m+1];
        this.tree = new TreeMap<>();
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public void addNode(int id, int x, int y) {
        tree.put(id, new Node(id, x, y));
        map[x][y] = id;
    }

    public void makeTree() {
        Node curr;
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] visited = new boolean[tree.size() + 1];

        que.add(tree.get(root));
        visited[root] = true;
        while (!que.isEmpty()) {
            curr = que.poll();

            for (int dir = 0; dir < 8; ++dir) {
                int nextX = curr.getX() + DX[dir];
                int nextY = curr.getY() + DY[dir];

                if (isValidate(nextX, nextY) && 
                    map[nextX][nextY] != 0 && 
                    !visited[map[nextX][nextY]]
                    ) {
                    Node node = tree.get(map[nextX][nextY]);

                    node.setLevel(curr.getLevel() + 1);
                    curr.getChildren().add(node);
                    visited[map[nextX][nextY]] = true;
                    que.add(node);
                }
            }
        }
    }

    public String getCount() {
        if (counting(tree.get(root)) != tree.size()) {
            // System.out.println(tree);
            return "-1";
        }
        // System.out.println(tree);
        StringBuilder sb = new StringBuilder();
        for (Node n : tree.values()) {
            sb.append(n.getCount()).append(" ");
        }
        return sb.toString();
    }

    private int counting(Node node) {
        if (node.getChildren().size() == 0) {
            node.setCount(1);
            return 1;
        }

        int count = 1;
        for (Node n : node.getChildren()) {
            count += counting(n);
        }
        node.setCount(count);
        return count;
    }

    private boolean isValidate(int x, int y) {
        return (0 < x && x < map.length
                &&
                0 < y && y < map[0].length);
    }
}

class Problem {
    private Tree tree;

    public Problem() {
        try {
            input();
            tree.makeTree();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tree = new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= k; ++i) {
            st = new StringTokenizer(br.readLine());
            tree.addNode(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        tree.setRoot(Integer.parseInt(br.readLine()));
    }

    private void output() {
        System.out.println(tree.getCount());
    }
}

public class Baekjoon23887 {
    public static void main(String[] args) {
        new Problem();
    }
}
