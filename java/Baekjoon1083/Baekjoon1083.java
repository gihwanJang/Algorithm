import java.io.*;
import java.util.*;

class Problem {
     int n, s;
     int[] nums;

     public Problem(int n) {
        this.n = n;
        nums = new int[n];
     }

     public String solve() {
        StringBuilder sb = new StringBuilder();
        sort();
        for(int i = 0; i < n; ++i) {
            sb.append(nums[i]).append(" ");
        }
        return sb.toString();
     }

     private void sort() {
        for(int i = 0; i < n && s > 0; ++i) {
            int max = nums[i], maxi = i;

            for(int j = i+1; j < n && j <= i+s; ++j) {
                if(max < nums[j]) {
                    max = nums[j];
                    maxi = j;
                }
            }

            int j = maxi;
            if (maxi > i) {
                while(j != i) {
                    swap(j-1, j--);
                }
            }

            s -= maxi - i;
        }
     }

     private void swap(int l_idx, int r_idx) {
        int tmp = nums[l_idx]; 
        nums[l_idx] = nums[r_idx];
        nums[r_idx] = tmp;
     }
}

public class Baekjoon1083 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < problem.n; ++i) {
            problem.nums[i] = Integer.parseInt(st.nextToken());
        }
        problem.s = Integer.parseInt(br.readLine());

        System.out.println(problem.solve());
    }
}
