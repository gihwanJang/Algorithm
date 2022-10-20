import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun1182 {
    public static int solution(int N, int S, int[] nums){
        int count=0;
        for(int i=0; i<(1<<N);++i){
            int sum=0;
            for(int j=0; j<N; ++j)
                if((i & 1 << j) != 0)
                    sum+=nums[j];
            if(S==sum)++count;
        }
        return S==0 ? count-1:count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, S, nums));
    }
}
