import java.io.*;
import java.util.*;


class Problem {
    public Problem() {
        try {
            input();
        } catch (Exception e) {
        }
    }

    private void input() throws IOException {
        String n = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.println(n.compareTo("2") == 0 ? 3 : n);
    }
}

public class Baekjoon32246 {
    public static void main(String[] args) {
        new Problem();
    }
}
