import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11053 {
    public static int solution(int N, int[] A){
        int max = 0;
        int[] table = new int[N];
        Arrays.fill(table, 1);

        for(int i=0; i<N; ++i){
            for(int j=i+1; j<N; ++j)
                if(A[i]<A[j])
                    table[j]=Integer.max(table[j], table[i]+1);
            max = Integer.max(max, table[i]);
        }

        return max;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, A));
    }
}
