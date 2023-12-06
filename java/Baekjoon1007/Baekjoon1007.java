import java.io.*;
import java.util.*;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance() {
        return x*x + y*y;
    }
}

class Problem {
    int n;
    Point[] points;
    boolean[] startPoint;

    public Problem(int n) {
        this.n = n;
        points = new Point[n];
        startPoint = new boolean[n];
    }

    public double solve() {
        Point[] vector = new Point[1];
        vectorSum(vector, 0, 0);
        return Math.sqrt(vector[0].getDistance());
    }

    private void vectorSum(Point[] vector, int depth, int start) {
        if(depth == n/2) {
            Point sumVector = getSumVector();
            if(vector[0] == null || sumVector.getDistance() < vector[0].getDistance())
                vector[0] = sumVector;
            return;
        }

        for(int i = start; i < n; ++i) {
            if(!startPoint[i]) {
                startPoint[i] = true;
                vectorSum(vector, depth+1, i+1);
                startPoint[i] = false;
            }
        }
    }

    private Point getSumVector() {
        double x = 0, y = 0;

        for(int i = 0; i < n; ++i) {
            if (startPoint[i]) {
                x += points[i].x;
                y += points[i].y;
            } else {
                x -= points[i].x;
                y -= points[i].y;
            }
        }

        return new Point(x, y);
    }
}

public class Baekjoon1007 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            Problem problem = new Problem(Integer.parseInt(br.readLine()));

            for(int i = 0; i < problem.n; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());
                problem.points[i] = new Point(x, y);
            }

            System.out.println(problem.solve());
        }
    }
}
