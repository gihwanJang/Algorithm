import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 14212kb 124ms
public class Baekjoon5585 {
    public static int coinChange(int n){
        int[] coins = {1,5,10,50,100,500};
        int[] table = new int[n+1];
        Arrays.fill(table, 987654321);
        table[0]=0;

        for(int i=0;i<n;++i)
            if(table[i]!=987654321)
                for(int j=0; j<6; ++j)
                    if(i+coins[j]<=n)
                        table[i+coins[j]]=Integer.min(table[i+coins[j]], table[i]+1);

        return table[n];
    }
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(coinChange(1000-n));
    }
}
