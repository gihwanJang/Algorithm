import java.io.*;

public class Baekjoon1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String keyword = br.readLine();

        int count = 0;
        int length = word.length() - keyword.length();

        for (int i = 0; i <= length; ++i) {
            if(word.substring(i, i + keyword.length()).equals(keyword)) {
                i += keyword.length() - 1;
                ++count;
            }
        }
        System.out.println(count);
    }
}
