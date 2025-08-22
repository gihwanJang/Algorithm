import java.util.*;
import java.io.*;

public class KoreaTech1006 {
    public static int[] getChangeArr(int c, int r) {
        int change[] = new int[8];
        int totalChange = r - c;

        for(int i = 0, div = 50000; i  < 8; ++i) {
            change[i] = totalChange / div;
            totalChange -= change[i] * div;

            div /= (i % 2 == 0) ? 5 : 2;
        }

        return change;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (0 < T--) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            for (int i : getChangeArr(c, r))
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
