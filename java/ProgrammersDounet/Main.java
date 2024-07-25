import java.util.*;
import java.util.Map.Entry;

class Node {
    private int fanIn;
    private int fanOut;
    
    public Node() {
        this.fanIn = 0;
        this.fanOut = 0;
    }
    
    public int getFanIn() {
        return fanIn;
    }
    
    public int getFanOut() {
        return fanOut;
    }
    
    public void increaseFanIn() {
        ++fanIn;
    }
    
    public void increaseFanOut() {
        ++fanOut;
    }
}

class Solution {
    private int[] types;
    private boolean[] visited;
    private HashMap<Integer, Node> nodes;
    private HashMap<Integer, List<Integer>> edges;
    
    public int[] solution(int[][] edges) {
        types = new int[4];
        nodes = new HashMap<>(edges.length);
        this.edges = new HashMap<>(edges.length);

        Arrays.stream(edges)
                .forEach(e -> {
                    if (!nodes.containsKey(e[0])) {
                        nodes.put(e[0], new Node());
                        this.edges.put(e[0], new ArrayList<>());
                    }
                    if (!nodes.containsKey(e[1])) {
                        nodes.put(e[1], new Node());
                        this.edges.put(e[1], new ArrayList<>());
                    }
                    this.edges.get(e[0]).add(e[1]);
                    nodes.get(e[0]).increaseFanOut();
                    nodes.get(e[1]).increaseFanIn();
                });
        visited = new boolean[nodes.size() + 1];
        for (Entry<Integer, Node> n : nodes.entrySet()) {
            if (nodes.get(n.getKey()).getFanIn() == 0
                && 
                nodes.get(n.getKey()).getFanOut() > 1) {
                types[0] = n.getKey();
            }
        }
        for (int start : this.edges.get(types[0])) {
            ++types[getType(start)];
        }
        return types;
    }

    private int getType(int start) {
        int curr;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.add(start);
        while (!stack.isEmpty()) {
            curr = stack.pollLast();

            if (!visited[curr]) {
                visited[curr] = true;
                for (int next : edges.get(curr)) {
                    stack.add(next);
                }
            } else {
                if (stack.isEmpty()) {
                    return 1;
                }
                return 3;
            }
        }
        return 2;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] edge = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, 
        {9, 6}, 
        {10, 11}, 
        {6, 10}, 
        {3, 5}, 
        {11, 1}, 
        {5, 3}, 
        {11, 9}, 
        {3, 8}};
        System.out.println(Arrays.toString(new Solution().solution(edge)));
    }
}
