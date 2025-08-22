import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Problem {
	int n;
	int[] sub;
	int[] sum;
	
	public Problem(int n) {
		this.n = n;
		this.sub = new int[n];
		this.sum = new int[n];
	}
	
	public int solve() {
		Arrays.sort(sub);
		Arrays.sort(sum);
		return Math.max(sub[n-1] - sub[0], sum[n - 1] - sum[0]);
	}
}

public class Baekjoon2381 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Problem p = new Problem(Integer.parseInt(br.readLine()));
		
		for(int i = 0; i < p.n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			p.sub[i] = x - y;
			p.sum[i] = x + y;
		}
		
		System.out.print(p.solve());
	}
}
