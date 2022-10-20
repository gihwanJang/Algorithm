import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjun2579 {
    public static int solution(int N, int[] stairs){
        int[][] table = new int[N+1][2];
        table[1][0]=stairs[0];
        table[1][1]=stairs[0];

        for(int i=1;i<N;++i){
            int f = i%2==0? 0:1, s = i%2==0? 1:0;
            table[i+1][f]=stairs[i]+table[i][f];
            table[i+1][s]=stairs[i]+Integer.max(table[i-1][s],table[i-1][f]);
        }

        return Integer.max(table[N][0], table[N][1]);
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N];
        
        for(int i=0; i<N; ++i)
            stairs[i]=Integer.parseInt(br.readLine());
        
        System.out.println(solution(N, stairs));
    }
}
