import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjun11047 {
    public static int solution(int[] coins, int K){
        int[] table = new int[K+1];
        Arrays.fill(table, 987654321);
        table[0] = 0;

        for(int i=0; i<K; ++i)
            if(table[i]!=987654321)
                for(int j=0; j<coins.length; ++j)
                    if(i+coins[j]<=K)
                        table[i+coins[j]]=Integer.min(table[i+coins[j]], table[i]+1);

        return table[K];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];

        for(int i=0; i<N; ++i)
            coins[i] = Integer.parseInt(br.readLine());
        
        System.out.println(solution(coins, K));
    }
}
