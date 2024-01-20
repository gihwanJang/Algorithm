import java.io.*;
import java.util.*;
import java.util.stream.*;

class Problem {
	int n;
	int[] nums;
	int[][] dp;
	
	public Problem (int n) {
		this.n = n;
		this.nums = new int[n];
		this.dp = new int[n][n];
		Arrays.stream(dp)
				.forEach(row -> Arrays.fill(row, -1));
	}
	
	public int solve() {
		return getAppendCnt(0, n - 1);
	}
	
	private int getAppendCnt(int l, int r) {
		if (l >= r) {
			return 0;
		}
		if (dp[l][r] != -1) {
			return dp[l][r];
		}
		if (nums[l] == nums[r]) {
			return dp[l][r] = getAppendCnt(l + 1, r - 1);
		}
		return dp[l][r] = Math.min(getAppendCnt(l + 1, r), getAppendCnt(l, r - 1)) + 1;
	}
}

public class Baekjoon1695 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Problem p = new Problem(Integer.parseInt(br.readLine()));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		IntStream.range(0, p.n)
				.forEach(i -> p.nums[i] = Integer.parseInt(st.nextToken()));
		System.out.print(p.solve());
	}
}
