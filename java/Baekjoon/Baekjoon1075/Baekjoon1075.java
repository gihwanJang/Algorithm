import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1075{
    private static String solution(int n, int f){
        int ans = 0;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < 100; ++i){
            n /= 100;
            n *= 100;
            n += i;
            if(n % f == 0){
                ans = i;
                break;
            }
        }

        sb.append(ans < 10 ? "0" + Integer.toString(ans) : Integer.toString(ans));
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, F));
    }
}