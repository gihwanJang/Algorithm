import java.io.*;
import java.math.*;

public class Baekjoon8437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger sum = new BigInteger(br.readLine());
        BigInteger sub = new BigInteger(br.readLine());

        System.out.println((sum.add(sub)).divide(new BigInteger("2")));
        System.out.println((sum.subtract(sub)).divide(new BigInteger("2")));
    }
}
