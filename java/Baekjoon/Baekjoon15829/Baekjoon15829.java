import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baekjoon15829{
    static int hashCode(int n, String s){
        BigInteger h = new BigInteger("0");
        BigInteger r = new BigInteger("31");

        for(int i = 0; i < n; ++i){
            h = h.add(new BigInteger(String.valueOf(s.charAt(i)-96)).multiply(r.pow(i)));
            h = h.mod(new BigInteger("1234567891"));
        }

        return h.intValue();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(hashCode(n, s));
    }
}