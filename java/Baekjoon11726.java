import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjun11726 {
    public static int solution(int n){
        int[] table = new int[n+2];
        table[1] = 1;
        table[2] = 2;
        for (int i = 3; i <= n; ++i)
            table[i] = (table[i-1] + table[i-2])%1007;

        return table[n];
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
}
