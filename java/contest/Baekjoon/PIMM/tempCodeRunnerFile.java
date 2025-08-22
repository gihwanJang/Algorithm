import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int q;
    private int iter;
    private int[] nums;
    private int[][] querys;

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

        iter = 0;
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        nums[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; ++i) {
            nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());
        }
        querys = new int[q][3];
        for (int i = 0; i < q; ++i) {
            st = new StringTokenizer(br.readLine());
            querys[i][0] = Integer.parseInt(st.nextToken());
            querys[i][1] = Integer.parseInt(st.nextToken());
            if (querys[i][0] == 3) {
                querys[i][2] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < q; ++j) {
            if (querys[j][0] == 2) {
                iter = (iter + querys[j][1]) % n;
            } else if (querys[j][0] == 1) {
                iter = (iter + n - querys[j][1]) % n;
            } else {
                int start = (iter + n + querys[j][1] - 1) % n;
                int end = (iter + querys[j][2] - 1) % n;

                if (start <= end) {
                    if (start == 0) {
                        sb.append(nums[end]).append("\n");
                    } else {
                        sb.append(nums[end] - nums[start - 1]).append("\n");
                    }
                } else {
                    sb.append(nums[end] + nums[n-1] - nums[start - 1]).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
    /*
     * 1 2 3  4  5
     * 1 3 6 10 15
     * 
     * 1 3
     */
}

public class D {
    public static void main(String[] args) {
        new Problem();
    }
}