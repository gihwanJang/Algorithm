import java.io.*;
import java.util.*;

class Problem {
    private String ip;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ip = br.readLine();
    }

    private void output() {}

    private String solve() {
        String[] ipSection = new String[8];
        return null;
    }
}

public class Baekjoon3107 {
    public static void main(String[] args) {
        new Problem();
    }
}
