import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//14208kb 124ms
public class Baekjun14916 {
    public static int coinChange(int n){
        int[] coins= {2,5};
        int[] table = new int[n+1];
        Arrays.fill(table, 987654321);
        table[0]=0;

        for(int i=0; i<n; ++i)
            if(table[i]!=987654321)
                for(int j=0; j<2; ++j)
                    if(i+coins[j]<=n)
                        table[i+coins[j]]=Integer.min(table[i+coins[j]], table[i]+1);

        return table[n]==987654321 ? -1 : table[n];
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = n<5 ? 0 : n/5-1;
        System.out.println(count+coinChange(n-5*count));
    }
}
/* 14292kb 124ms
public class Baekjun14916 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==1||n==3)
            System.out.println(-1);
        else if(n % 5 % 2 == 0)
            System.out.println(n/5+n%5/2);
        else
            System.out.println(n/5+(n%5+5)/2-1);
    }
}
*/