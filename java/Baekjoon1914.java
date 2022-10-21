import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baekjun1914 {
    public static void solution(int N, int start,  int mid, int end){
        if (N == 1)
            System.out.println(start+" "+end);
        else { 
            solution(N - 1, start, end, mid); 
            System.out.println(start+" "+end);
            solution(N - 1, mid, start, end);
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger count = new BigInteger("2");
        System.out.println(count.pow(N).subtract(new BigInteger("1")));
        if(N<=20)
            solution(N, 1, 2, 3);
    }
}
