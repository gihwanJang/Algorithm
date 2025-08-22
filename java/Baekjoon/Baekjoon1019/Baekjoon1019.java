import java.io.*;

class Problem {
    int n;
    int[] talbe;
    
    public Problem(int n) {
        this.n = n;
        talbe = new int[10];
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        makeTable();
        for(int i = 0; i < 10; ++i) {
            sb.append(talbe[i]).append(" ");
        }
        return sb.toString();
    }

    private void makeTable() {
        int add = 0;
        for(int i = 1; n != 0; i *= 10) {
            int curr = n % 10;
            n /= 10;

            talbe[0] -= i;
            for(int j=0; j<curr; j++) {
                talbe[j] += (n+1)*i;
            }
            talbe[curr] += n*i + 1 + add;
            for(int j=curr+1; j<=9; j++) {
                talbe[j] += n*i;
            }
            add += curr*i;
        }
    }
}

public class Baekjoon1019 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        System.out.println(problem.solve());
    }
}
