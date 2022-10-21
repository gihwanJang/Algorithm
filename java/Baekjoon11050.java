import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun11050 {
    public static int solution(int N, int K){
        int B[][] = new int[N+1][K+1];

        for(int i=0; i<=N; ++i)
            for(int j=0; j<=Integer.min(i,K); ++j){
                if(j==0||j==i) B[i][j] = 1;
                else B[i][j] = B[i-1][j-1]+B[i-1][j];
            }

        return B[N][K];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }   
}
