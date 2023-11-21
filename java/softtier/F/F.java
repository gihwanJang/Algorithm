import java.io.*;
import java.util.*;

class Problem {
	int n, k;
	int[] maxValue;
	int[] defalutValue;
	
	public Problem(int n) {
		this.n = n;
        maxValue = new int[n];
        defalutValue = new int[n];
	}
    public String solve() {
        StringBuilder sb = new StringBuilder();

        if(!isValidate()) return "-1";
        for(int i = 0; i < k; ++i) count();
        for(int i = 0; i < n; ++i) sb.append(defalutValue[i]);

        return sb.toString();
    }

    private void count() {
        if(++defalutValue[n-1] > maxValue[n-1])
            nextStep(n-1);
    }
    private void nextStep(int idx) {
        defalutValue[idx] = 0;

        if(idx > 0)
            if(++defalutValue[idx-1] > maxValue[idx-1]) 
                nextStep(idx-1);
    }
    private boolean isValidate() {
        for(int i = 0; i < n; ++i)
            if(defalutValue[i] > maxValue[i] || defalutValue[i] < 0)
                return false;
        return true;
    }
}

public class F {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < problem.n; ++i)
            problem.maxValue[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < problem.n; ++i)
            problem.defalutValue[i] = Integer.parseInt(st.nextToken());
        problem.k = Integer.parseInt(br.readLine());

		System.out.println(problem.solve());
	}
}