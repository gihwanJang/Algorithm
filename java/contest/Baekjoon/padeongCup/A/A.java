import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;

        for(int i = 0; i < n; ++i) {
            sum += Integer.parseInt(st.nextToken());
        }

        if(t > sum) {
            System.out.println("Padaeng_i Cry");
        } else {
            System.out.println("Padaeng_i Happy");
        }
    }
}
