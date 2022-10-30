import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1003{
    public static void solution(int N){
        int[] table = new int[N<1 ? 2 : N+1];
        table[N]=1;

        for(int i=N; i>1; --i)
            for(int j=1; j<3; ++j)
                table[i-j]+=table[i];

        System.out.println(table[0]+" "+table[1]);
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=Integer.parseInt(br.readLine()); i>0; --i)
            solution(Integer.parseInt(br.readLine()));
    }
}