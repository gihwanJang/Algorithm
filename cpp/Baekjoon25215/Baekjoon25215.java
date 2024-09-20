import java.io.*;
import java.util.*;

class Problem {
    boolean startIsLowwer;
    List<Integer> charList;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        charList = new ArrayList<>(s.length());
        charList.add(1);
        startIsLowwer = isLowwer(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            if (isLowwer(s.charAt(i-1)) == isLowwer(s.charAt(i))) {
                charList.set(charList.size()-1, charList.get(charList.size()-1) + 1);
            } else {
                charList.add(1);
            }
        }
        solve();
    }

    private boolean isLowwer(char c) {
        return ('a' <= c && c <= 'z');
    }

    private void solve() {
        int count = 0;
        boolean dia = false;
        boolean lowwer = startIsLowwer;

        for (int i = 0; i < charList.size(); ++i) {
            if (charList.get(i) == 1) {
                if (!((lowwer && !dia) || (!lowwer && dia))) {
                    count += 1;
                }
            } else {
                if (!((lowwer && !dia) || (!lowwer && dia))) {
                    count += 1;
                    dia = !dia;
                }
            }

            lowwer = !lowwer;
            count += charList.get(i);
        }

        System.out.println(count);
    }
}

public class Baekjoon25215 {
    public static void main(String[] args) {
        new Problem();
    }
}
