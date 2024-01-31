import java.io.*;
import java.util.*;

class Item {
    int value;
    int weight;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class Problem {
    int k;
    int[][] memo;
    Item[] items;

    public Problem(int n, int k) {
        this.k = k;
        this.memo = new int[n + 1][k + 1];
        this.items = new Item[n];
    }

    public int solve() {
        return DFS(items.length, k);
    }

    private int DFS(int itemIdx, int remainingWeight) {
        if (itemIdx == 0 || remainingWeight == 0) {
            return 0;
        }

        if (memo[itemIdx][remainingWeight] != 0) {
            return memo[itemIdx][remainingWeight];
        }

        if (items[itemIdx - 1].weight <= remainingWeight) {
            int includeCurrent = items[itemIdx - 1].value + DFS(itemIdx - 1, remainingWeight - items[itemIdx - 1].weight);
            int excludeCurrent = DFS(itemIdx - 1, remainingWeight);

            memo[itemIdx][remainingWeight] = Math.max(includeCurrent, excludeCurrent);
            return memo[itemIdx][remainingWeight];
        } else {
            memo[itemIdx][remainingWeight] = DFS(itemIdx - 1, remainingWeight);
            return memo[itemIdx][remainingWeight];
        }
    }
}

public class Baekjoon12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < p.items.length; ++i) {
            st = new StringTokenizer(br.readLine());
            p.items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(p.solve());
    }
}
