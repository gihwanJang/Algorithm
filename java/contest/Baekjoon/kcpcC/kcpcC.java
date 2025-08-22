import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class kcpcC{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()), s, t;
        long n, currLen;
        BigInteger currTime;

        for(; T > 0; --T){
            n = Long.parseLong(br.readLine());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            currLen = 1;
            currTime = new BigInteger(String.valueOf(s));

            while(currLen * 2 <= n){
                currTime = currTime.add(currLen * s >= t ? new BigInteger(String.valueOf(t)) : new BigInteger(String.valueOf(currLen * s)));
                currLen *= 2;
            }

            System.out.println(currTime.add(new BigInteger(String.valueOf((n - currLen) * s))));
        }
    }
}