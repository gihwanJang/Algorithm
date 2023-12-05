import java.io.*;
import java.util.*;

class Problem {
    int n, size, start_r, start_c, len_r, len_c;

    public Problem(int n, int r1, int c1, int r2, int c2) {
        this.n = n;
        size = 2*n-1;
        start_r = r1;
        start_c = c1;
        len_r = r2 - r1 + 1;
        len_c = c2 - c1 + 1;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int r = 0; r < len_r; ++r) {
            for(int c = 0; c < len_c; ++c) {
                sb.append(getChar(r, c));
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    private char getChar(int r, int c) {
        int c_r = (start_r + r) % size;
        int c_c = (start_c + c) % size;
        int n_r = c_r < n ? c_r : size - c_r - 1; 
        int n_c = c_c < n ? c_c : size - c_c - 1; 
        int sum = n_r + n_c;

        if(n-2 < sum) return (char)('a' + (size - sum - 1) % 26);
        return '.';
    }
}

public class Baekjoon1262 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(
            Integer.parseInt(st.nextToken()), 
            Integer.parseInt(st.nextToken()), 
            Integer.parseInt(st.nextToken()), 
            Integer.parseInt(st.nextToken()), 
            Integer.parseInt(st.nextToken()));

        System.out.print(problem.solve());
    }
}