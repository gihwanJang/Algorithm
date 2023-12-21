import java.io.*;

public class Baekjoon5747 {
    public static void main(String[] args) throws Exception {
        String s;
        int[] num;
        StringBuilder sb = new StringBuilder();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n != 0) {
            num = new int[2];

            s = br.readLine();
            for(int i = 0; i < n; ++i) {
                ++num[(s.charAt(i*2) - '0')%2];
            }

            s = br.readLine();
            for(int i = 0; i < n; ++i) {
                --num[1 - (s.charAt(i*2) - '0')%2];
            }

            sb.append(Math.max(Math.abs(num[0]), Math.abs(num[1]))).append("\n");
            n = Integer.parseInt(br.readLine());
        }

        System.out.print(sb.toString());
    }
}