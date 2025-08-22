import java.io.*;
import java.util.*;

class Problem {
    private double n;

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
        n = Integer.parseInt(br.readLine());
    }

    private void output() {
        double time = 0;
        if (n <= 30) {
            time += n / 2;
        } else {
            n -= 30;
            time += n * 3 / 2 + 15;
        }
        System.out.println(time);
    }
}

public class A {
    public static void main(String[] args) {
        new Problem();
    }
}
