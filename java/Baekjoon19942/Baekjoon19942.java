import java.io.*;
import java.util.*;

class Answer {
    int price;
    int[] select;

    public Answer(int price, int[] select) {
        this.price = price;
        this.select = select;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (select != null) {
            sb.append(price).append("\n");
            for (int i = 0; i < select.length; ++i) {
                sb.append(select[i]).append(" ");
            }
        } else {
            return "-1";
        }
        return sb.toString();
    }
}

class Problem {
    private int n;
    private int[] need;
    private int[][] ingredents;
    private Answer ans;

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
        this.n = Integer.parseInt(br.readLine());

        need = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

        ingredents = new int[n][5];
        for (int i = 0; i < n; ++i) {
            ingredents[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
        }

        ans = new Answer(Integer.MAX_VALUE, null);
    }

    private void output() {
        int[] select = new int[n];

        DFS(select, 0, 0);
        System.out.println(ans);
    }

    private void DFS(int[] select, int depth, int start) {
        int price = canChoice(depth, select);
        if (0 < price) {
            if (price < ans.price) {
                int[] newSelect = new int[depth];
                for (int i = 0; i < depth; ++i) {
                    newSelect[i] = select[i] + 1;
                }
                ans = new Answer(price, newSelect);
            }
            return;
        }

        for (int i = start; i < n; ++i) {
            select[depth] = i;
            DFS(select, depth + 1, i + 1);
        }
    }

    private int canChoice(int depth, int[] select) {
        int[] res = new int[5];

        for (int i = 0; i < depth; ++i) {
            for (int j = 0; j < 5; ++j) {
                res[j] += ingredents[select[i]][j];
            }
        }
        for (int i = 0; i < 4; ++i) {
            if (res[i] < need[i]) {
                return -1;
            }
        }
        return res[4];
    }
}

public class Baekjoon19942 {
    public static void main(String[] args) {
        new Problem();
    }
}
