import java.io.*;
import java.util.*;

public class Baekjoon1233 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 0;
        int[] dice = new int[3];
        int[] table = new int[81];

        for(int i = 0; i < 3; ++i) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= dice[0]; ++i) {
            for(int j = 1; j <= dice[1]; ++j) {
                for(int k = 1; k <= dice[2]; ++k) {
                    ++table[i+j+k];
                }
            }
        }
        for(int i = 0; i < 81; ++i) {
            if(table[ret] < table[i]) {
                ret = i;
            }
        }

        System.out.println(ret);
    }
}
