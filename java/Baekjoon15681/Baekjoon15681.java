import java.io.*;
import java.util.*;

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();

    private int n;
    private int q;
    private int root;
    private int[] subNodes;
    private List<List<Integer>> tree;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        n = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken()) - 1;
        q = Integer.parseInt(st.nextToken());
        subNodes = new int[n];

        // make tree
        tree = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // count sub tree
        makeSubNode(root);

        // make answer
        for (int i = 0; i < q; ++i) {
            ANSWER.append(subNodes[Integer.parseInt(br.readLine()) - 1]).append("\n");
        }
        System.out.print(ANSWER.toString());
    }

    private int makeSubNode(int node) {
        subNodes[node] = 1;
        for (int child : tree.get(node)) {
            if (subNodes[child] == 0) {
                subNodes[node] += makeSubNode(child);
            }
        }
        return subNodes[node];
    }
}

public class Baekjoon15681 {
    public static void main(String[] args) {
        new Problem();
    }
}
