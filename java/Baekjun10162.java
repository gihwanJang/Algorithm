import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjun10162 {
    public static void solution(int T){
        int[] time = {300,60,10};
        int[] count = {0,0,0};

        for(int i=0; i<3; ++i){
            count[i]=T/time[i];
            T-=time[i]*count[i];
            System.out.print(count[i]+" ");
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        if(T%10!=0)
            System.out.println(-1);
        else
            solution(T);
    }
}
