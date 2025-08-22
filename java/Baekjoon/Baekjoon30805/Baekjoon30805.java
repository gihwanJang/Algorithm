import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int m;
    private int[] a;
    private int[] b;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = Integer.parseInt(br.readLine());
        b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve();
    }

    private void solve() {
        int[] idxArr = {-1, -1};
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            idxArr = getMaxIdx(idxArr);
            if (idxArr[0] == -1) {
                break;
            }

            ++count;
            sb.append(a[idxArr[0]] + " ");
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }

    private int[] getMaxIdx(int[] idxArr) {
        int max = -1;
        int[] maxIdx = {-1, -1};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = idxArr[0]+1; i < n; ++i) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], i);
            }
        }
        for (int i = idxArr[1]+1; i < m; ++i) {
            if (map.containsKey(b[i]) && b[i] > max) {
                max = b[i];
                maxIdx[0] = map.get(b[i]);
                maxIdx[1] = i;
            }
        }
        return maxIdx;
    }
}

public class Baekjoon30805 {
    public static void main(String[] args) {
        new Problem();
    }
}
