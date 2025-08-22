import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon16496{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");

        Arrays.sort(nums,(o1, o2) -> {
            long str1= Long.parseLong(o2+o1);
            long str2= Long.parseLong(o1+o2);
            return str1>str2?1:-1;
        });

        if (nums[0].compareTo("0")!=0) {
            for (int i = 0; i < N; ++i)
                System.out.print(nums[i]);
            System.out.println();
        }
       else System.out.println(0);
    }
}