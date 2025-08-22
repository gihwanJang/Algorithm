import java.io.*;
import java.util.*;

class Problem {
    int[] count;
    boolean[] visitied;
    List<Integer>[] map;
    public Problem(int n) {
        this.count = new int[n];
        this.map = new List[n];
        this.visitied = new boolean[n];
        for(int i = 0; i < n; ++i) {
            map[i] = new ArrayList<>();
        }
    }
    public String solve() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count.length; ++i) {
            Arrays.fill(visitied, false);
            BFS(i);
        }
        int max = getMax();
        for(int i = 0; i < count.length; ++i) {
            if(max == count[i]) {
                sb.append(i+1).append(" ");
            }
        }
        return sb.toString();
    }

    private void BFS(int start) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visitied[start] = true;

        while(!que.isEmpty()) {
            int curr = que.poll();

            for(int next : map[curr]) {
                if(!visitied[next]) {
                    ++count[next];
                    visitied[next] = true;
                    que.add(next);
                }
            }
        }
    }
    private int getMax() {
        int max = 0;
        for(int i = 0; i < count.length; ++i) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}

public class Baekjoon1325 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(Integer.parseInt(st.nextToken()));

        for(int i = Integer.parseInt(st.nextToken()); i > 0; --i)  {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            p.map[a].add(b);
        }

        System.out.println(p.solve());
    }
}
