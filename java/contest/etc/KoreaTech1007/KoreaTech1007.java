import java.util.*;
import java.io.*;

public class KoreaTech1007 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (0 < T--) {
            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>(n);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; ++i) {
                int pairNum = Integer.parseInt(st.nextToken());
                
                if(set.contains(pairNum))set.remove(pairNum);
                else set.add(pairNum);
            }

            for(Integer i : set)
                System.out.println(i);
        }
    }
}
