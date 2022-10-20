import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjun10610 {
    public static String solution(String N){
        StringBuilder sb = new StringBuilder();
        int sum=0;
        int[] nums = new int[N.length()];
        for(int i=0; i<N.length(); ++i){
            nums[i]=N.charAt(i)-'0';
            sum+=nums[i];
        }
        Arrays.sort(nums);
        
        if(nums[0]!=0||sum%3!=0)
            return "-1";
        
        for(int i=N.length()-1; i>=0; --i)
            sb.append(nums[i]);
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        System.out.println(solution(N));
    }
}
