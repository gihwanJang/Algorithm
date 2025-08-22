import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double n = Integer.parseInt(st.nextToken());
        double m = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(Math.max(n, m), Math.min(n, m) / a * 2));
    }
}
