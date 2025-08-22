import java.io.*;
import java.util.*;

public class Baekjoon18409 {
    public static void main(String[] args) throws Exception {
        HashSet<Character> set = new HashSet<>(List.of('a','e','i','o','u'));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ret = 0;
        String s = br.readLine();
        
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                ++ret;
            }
        }
        System.out.println(ret);
    }
}
