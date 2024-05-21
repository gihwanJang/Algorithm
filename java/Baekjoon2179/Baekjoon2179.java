import java.io.*;
import java.util.*;
import java.util.Map;

class Node {
    private int count;
    private Map<Character, Node> child;

    public Node() {
        count = 0;
        child = new HashMap<>();
    }

    public int getCount() {
        return count;
    }

    public void counting() {
        ++count;
    }

    public Map<Character, Node> getChild() {
        return child;
    }
}

class Problem {
    private Node root;
    private String[] strings;

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
        strings = new String[Integer.parseInt(br.readLine())];

        root = new Node();
        for (int i = 0; i < strings.length; ++i) {
            Node node = root;
            strings[i] = br.readLine();
            for (char c : strings[i].toCharArray()) {
                if (!node.getChild().containsKey(c)) {
                    node.getChild().put(c, new Node());
                }
                node = node.getChild().get(c);
                node.counting();
            }
        }
    }

    private void output() {
        System.out.print(solve());
    }   

    private String solve() {
        Map.Entry<Integer, Node> max = Map.entry(0, root);
        Node[] counting = new Node[strings.length];
        for (int i = 0; i < strings.length; ++i) {
            Map.Entry<Integer, Node> branch = count(root.getChild().get(strings[i].charAt(0)), root, strings[i], 0);
            counting[i] = branch.getValue();
            if (branch.getKey() > max.getKey()) {
                max = branch;
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length && count < 2; ++i) {
            if (counting[i] == max.getValue()) {
                sb.append(strings[i]).append("\n");
                ++count;
            }
        }
        return sb.toString();
    }

    private Map.Entry<Integer, Node> count(Node curr, Node prev, String s, int idx) {
        if (curr.getCount() == 1) {
            return Map.entry(idx, prev);
        } else if (idx == s.length()-1) {
            return Map.entry(idx + 1, curr);
        }
        return count(curr.getChild().get(s.charAt(idx+1)), curr, s, idx+1);
    }
}

public class Baekjoon2179 {
    public static void main(String[] args) {
        new Problem();
    }
}
