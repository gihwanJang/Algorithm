import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class KoreaTech1005 {
    private static int lowerBound(long nums[], int lo, int hi, long key) {
        int mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] < key)
                lo = mid + 1;
            else
                hi = mid;
        }
        return hi;
    }

    public static long getSetCount(long nums[], int n) {
        long sum;
        Set<String> threeNumSet = new HashSet<>(n);

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; ++i)
            for (int j = i + 1; j < n - 1; ++j) {
                sum = nums[i] + nums[j];
                int lower = lowerBound(nums, j + 1, n, sum * -1);

                if(lower < n && sum + nums[lower] == 0) {
                    long threeNum[] = {nums[i],nums[j],nums[lower]};
                    threeNumSet.add(Arrays.toString(threeNum));
                }
            }

        return threeNumSet.size();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long nums[] = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            nums[i] = Long.parseLong(st.nextToken());

        System.out.println(getSetCount(nums, n));
    }
}