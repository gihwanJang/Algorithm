import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer subSt = new StringTokenizer(br.readLine(),"\\-");
        int sum=Integer.MAX_VALUE;

        while(subSt.hasMoreTokens()){
            int tmp=0;
            StringTokenizer sumSt = new StringTokenizer(subSt.nextToken(),"\\+");
            while(sumSt.hasMoreTokens()){
                tmp+=Integer.parseInt(sumSt.nextToken());
            }
            if(sum==Integer.MAX_VALUE)sum=tmp;
            else sum-=tmp;
        }

        System.out.println(sum);
    }
}
