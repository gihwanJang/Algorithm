import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int l;
    private int[] cnt = new int[2];
    private int[][] V = new int[2][12];
    private int[][] distance;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        distance = new int[n][n];
        for (int i = 0; i < n; ++i) {
            distance[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        if (n == 2) {
            System.out.println(distance[0][1] * 2 == l ? "possible" : "impossible");
        }

        for (int m = 1; m < n; ++m) {
            if (partition(m)) {
                System.out.println("possible");
            }
        }
        System.out.println("impossible");
    }

    private boolean partition(int m) {
        int pos = 1;

        if (pos == n) {
            
        }
        return true;
    }

    private boolean nextPermutation(int[] array, int n) {
        int firstDecreasing = n - 2;
        while (firstDecreasing >= 0 && array[firstDecreasing] >= array[firstDecreasing + 1]) {
            firstDecreasing--;
        }
        if (firstDecreasing == -1) {
            return false;
        }

        int nextBigger = n - 1;
        while (array[firstDecreasing] >= array[nextBigger]) {
            nextBigger--;
        }
        swap(array, firstDecreasing, nextBigger);
        reverse(array, firstDecreasing + 1, n - 1);

        return true;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
}

public class Baekjoon10526 {
    public static void main(String[] args) {
        new Problem();
    }
}
