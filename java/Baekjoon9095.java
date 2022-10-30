import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9095 {
    public static int solution(int N){
        int[] values = {1,2,3};
        int[] table = new int[N+1];
        table[0]=1;

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < 3; ++j)
                if (i + values[j] <= N)
                    table[i + values[j]] += table[i];

        return table[N];
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=Integer.parseInt(br.readLine()); i>0; --i){
            int N = Integer.parseInt(br.readLine());
            
            System.out.println(solution(N));
        }
    }
}
