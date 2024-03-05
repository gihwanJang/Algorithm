import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private StringBuilder sb;
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;

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
        
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        minHeap = new PriorityQueue<>(n);
        maxHeap = new PriorityQueue<>(n, Collections.reverseOrder());
        for (int i = 0; i < n; ++i) {
            sb.append(getMidValue(Integer.parseInt(br.readLine()))).append("\n");
        }
    }

    private void output() {
        System.out.print(sb.toString());
    }

    private int getMidValue(int v) {
        maxHeap.offer(v);

        if (0 < minHeap.size() && 0 < maxHeap.size()) {
            while (maxHeap.peek() > minHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(minHeap.poll());
            }
        }
        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
            return minHeap.peek();
        }
        return maxHeap.peek();
    }
}

public class Baekjoon1655 {
    public static void main(String[] args) {
        new Problem();
    }
}
