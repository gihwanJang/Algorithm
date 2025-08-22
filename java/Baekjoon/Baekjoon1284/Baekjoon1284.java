import java.io.*;

public class Baekjoon1284 {

    public static void main(String[] args) throws Exception {
        int cnt;
        String s;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (!(s = br.readLine()).equals("0")) {
            cnt = s.length() * 4 + 1;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '1') {
                    cnt -= 1;
                } else if (s.charAt(i) == '0') {
                    cnt += 1;
                }
            }
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
