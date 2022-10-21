import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjun2217 {
    public static int solution(int N, int[] ropes){
        int max=0;
        Arrays.sort(ropes);

        for(int i=0; i<N; ++i)
            max=Integer.max(max, ropes[i]*(N-i));

        return max;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];

        for(int i=0; i<N; ++i)ropes[i]=Integer.parseInt(br.readLine());

        System.out.println(solution(N, ropes));
    }
}
