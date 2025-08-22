import java.io.*;
import java.util.*;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Problem {
    int n;
    Point[] points;

    public Problem(int n) {
        this.n = n;
        points = new Point[n];
    }

    public double solve() {
        double res = 0;

        for(int f = 0; f < n; ++f)
            for(int s = f+1; s < n; ++s)
                for(int t = s+1; t < n; ++t)
                    res = Math.max(res, getArea(f, s, t));

        return res;
    }

    private double getArea(int f, int s, int t) {
        double r = points[f].x*points[s].y + points[s].x*points[t].y + points[t].x*points[f].y;
        double l = points[s].x*points[f].y + points[t].x*points[s].y + points[f].x*points[t].y;
        return Math.abs(r-l) / 2;
    }
}

public class Baekjoon1198 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
