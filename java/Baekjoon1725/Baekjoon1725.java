import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] histogram;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.n = Integer.parseInt(br.readLine());
        this.histogram = new int[n];
        for (int i = 0; i < n; ++i) {
            histogram[i] = Integer.parseInt(br.readLine());
        }
    }

    private void output() {
        System.out.println(divide(0, n - 1));
    }

    private int divide(int s, int e) {
        if (s == e) {
            return histogram[s];
        }
        int m = s + (e - s) / 2;

        return Math.max(marge(s, e, m), Math.max(divide(s, m), divide(m + 1, e)));
    }

    private int marge(int s, int e, int m) {
        int toLeft = m;
	    int toRight = m;
        int height = histogram[m];
        int maxArea = height;

        while(s < toLeft && toRight < e) {
            if(histogram[toLeft - 1] < histogram[toRight + 1]) {
                height = Math.min(height, histogram[++toRight]);	
            } else {
                height = Math.min(height, histogram[--toLeft]);
            }
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1)); 
        }
        while (toRight < e) {
            height = Math.min(height, histogram[++toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }
        while (s < toLeft) {
            height = Math.min(height, histogram[--toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }
        return maxArea;
    }
}

public class Baekjoon1725 {
    public static void main(String[] args) {
        new Problem();
    }
}
