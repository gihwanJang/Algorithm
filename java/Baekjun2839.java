import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjun2839{
    public static int solution(int N){
        int[] contains = {3,5};
        int[] table = new int[N+1];
        Arrays.fill(table, 987654321);
        table[0]=0;

        for(int i=0; i<N; ++i)
            if(table[i]!=987654321)
                for(int j=0; j<2; ++j)
                    if(i+contains[j]<=N)
                        table[i+contains[j]]=Integer.min(table[i+contains[j]], table[i]+1);

        return table[N]==987654321 ? -1 : table[N];
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }
}