import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjun1789 {
    public static int solution(long N){
        int count=0;

        for(long i=1;N>0;++i)
            if(N-i>i||N-i==0){
                N-=i;
                ++count;
            }

        return count;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        
        System.out.println(solution(N));
    }
}
