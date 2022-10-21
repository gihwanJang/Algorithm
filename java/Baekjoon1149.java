import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun1149 {
    public static int solution(int N, int[][] rgb){
        int[][] table = new int[N+1][3];

        for(int i=0; i<N; ++i){
            table[i+1][0]=Integer.min(rgb[i][0]+table[i][1], rgb[i][0]+table[i][2]);
            table[i+1][1]=Integer.min(rgb[i][1]+table[i][0], rgb[i][1]+table[i][2]);
            table[i+1][2]=Integer.min(rgb[i][2]+table[i][0], rgb[i][2]+table[i][1]);
        }

        return Integer.min(Integer.min(table[N][0], table[N][1]), table[N][2]);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];

        for(int i=0; i<N; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; ++j)
                rgb[i][j]=Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, rgb));
    }
}
