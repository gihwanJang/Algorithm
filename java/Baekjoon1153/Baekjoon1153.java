import java.io.*;
import java.util.*;

class Problem {
    int n;
    boolean[] primes;

    public Problem(int n) {
        this.n = n;
        primes = new boolean[n+1];
        setPrimes();
    }

    public String solve() {
        if(n < 8) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for(int e : getAns(n%2)) {
            sb.append(e).append(" ");
        }
        return sb.toString();
    }

    private List<Integer> getAns(int isOdd) {
        List<Integer> ans = new ArrayList<>(4);
        ans.add(2);
        ans.add(2 + isOdd);
        for(int i = 2; i <= n; ++i){
            if(!primes[i] && !primes[n-(4+isOdd)-i]){
                ans.add(i);
                ans.add(n-(4+isOdd)-i);
                break;
            }
        }
        return ans;
    }

    private void setPrimes() {
        primes[0] = primes[1] = true;
        for(int i = 2 ; i * i <= n; ++i) {
            if(!primes[i]) {
                for(int j = i*i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }
    }
}

public class Baekjoon1153 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));
        System.out.println(p.solve());
    }
}
