import java.io.*;
import  java.util.*;

class Problem {
    private double[] param;

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
        param = Arrays.stream(br.readLine().split(" "))
                .mapToDouble(Integer::parseInt)
                .toArray();
    }

    private void output() {
        if ((param[1] == param[0])) {
            System.out.println(-1);
            return;
        } else if (param[2] == 0) {
            System.out.println(0);
            return;
        } else if (param[0] > param[1]) {
            double tmp = param[0];
            param[0] = param[1];
            param[1] = tmp;
        }
        double longHeight = param[1] / (param[1] - param[0]) * param[2];
        double longHypotenuse = getHypotenuseLength(longHeight, param[1]);
        double shortHypotenuse = getHypotenuseLength(longHeight - param[2], param[0]);
        System.out.println(getCirculerArea(longHypotenuse) - getCirculerArea(shortHypotenuse));
    }

    private double getHypotenuseLength(double a, double b) {
        return (a * a + b * b);
    }

    private double getCirculerArea(double rSquare) {
        return (Math.PI * rSquare);
    }
}

public class B {
    public static void main(String[] args) {
        new Problem();
    }
}