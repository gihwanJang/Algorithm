import java.io.*;
import java.util.*;

public class Baekjoon16566 {
    int n, m, k;
    boolean[] used;
    List<Integer> myCards;
    List<Integer> yourCards;

    private int getCanUsingIdx(int idx) {
        while(used[idx]==true){++idx;}
        return idx;
    }

    private int binarySearch(Integer target) {
        int lo = 0, hi = myCards.size(), mid;

        while(lo < hi) {
            mid = (lo + hi) / 2;
            if(myCards.get(mid) <= target) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        myCards.sort(null);
        for(int i = 0, idx; i < k; ++i) {
            idx = getCanUsingIdx(binarySearch(yourCards.get(i)));
            sb.append(myCards.get(idx)).append("\n");
            used[idx] = true;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon16566 problem = new Baekjoon16566();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        problem.n = Integer.parseInt(st.nextToken());
        problem.m = Integer.parseInt(st.nextToken());
        problem.k = Integer.parseInt(st.nextToken());
        problem.used = new boolean[problem.m];
        problem.myCards = new ArrayList<>(problem.m);
        problem.yourCards = new ArrayList<>(problem.k);

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < problem.m; ++i)
            problem.myCards.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < problem.k; ++i)
            problem.yourCards.add(Integer.parseInt(st.nextToken()));

        System.out.print(problem.solve());
    }
}