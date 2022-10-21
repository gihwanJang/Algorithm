import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjun1463 {
    public static int solution(int num){
        int[] table = new int[num+1];
        Arrays.fill(table, 987654321);
        table[num]=0;

        for(int i=num; i>0; --i)
            if(table[i]!=987654321){
                if(i%3==0)
                    table[i/3]=Integer.min(table[i/3],table[i]+1);
                if(i%2==0)
                    table[i/2]=Integer.min(table[i/2],table[i]+1);
                table[i-1]=Integer.min(table[i-1],table[i]+1);
            }

        return table[1];
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(solution(num));
    }
}
