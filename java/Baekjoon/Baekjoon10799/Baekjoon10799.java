import java.io.*;
import java.util.*;

class Problem {
    String s;

    Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
    }

    int sove() {
        int res = 0;
        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (sb.charAt(sb.length()-1) == '(') {
                    sb.deleteCharAt(sb.length()-1);
                    sb.append('0');
                } else {
                    res += stacking(sb);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return res;
    }

    int stacking(StringBuilder sb) {
        int count = 1;
        for (int i = sb.length()-1; i >= 0; --i) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                break;
            }
            ++count;
        }
        return count;
    }

    void output() {
        System.out.println(sove());
    }
}

public class Baekjoon10799 {
    public static void main(String[] args) {
        new Problem();
    }
}
