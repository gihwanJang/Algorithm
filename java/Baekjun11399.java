import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjun11399{
    public static int minTime(int N, int[] P){
        int min=0;
        Arrays.sort(P);

        for(int i=1; i<=N; ++i)
            for(int j=0; j<i; ++j)
                min+=P[j];

        return min;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            P[i]=Integer.parseInt(st.nextToken());
        
        System.out.println(minTime(N, P));
    }
}