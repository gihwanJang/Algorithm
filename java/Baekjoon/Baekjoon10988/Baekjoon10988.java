import java.io.*;

public class Baekjoon10988 {
    public static int solve(String s) {
        for(int lo = 0, hi = s.length()-1; lo <= hi; ++lo, --hi)
            if(s.charAt(lo) != s.charAt(hi)) return 0;
        return 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(br.readLine()));
    }
}
