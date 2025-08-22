import java.io.*;
import java.util.*;

class Problem {
    private int n, l, r;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
    }

    private void output() {
        System.out.println("");
    }

    private int DFS(int depth) {
        
        return 0;
    }
}

public class Baekjoon1328 {
    public static void main(String[] args) {
        new Problem();
    }
}

/*
 * comb(n, l)
 * comb()
 */