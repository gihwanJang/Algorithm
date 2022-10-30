import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon1026 {
    public static int solution(int N, int[] A, Integer[] B){
        Arrays.sort(A);
        Arrays.sort(B,Collections.reverseOrder());
        int s=0;

        for(int i=0; i<N; ++i)s+=A[i]*B[i];

        return s;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) A[i]=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) B[i]=Integer.parseInt(st.nextToken());

        System.out.println(solution(N, A, B));
    }
}
