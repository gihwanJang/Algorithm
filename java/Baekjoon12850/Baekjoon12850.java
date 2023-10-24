import java.io.*;

public class Baekjoon12850 {
    long div = 1_000_000_007;
    long[][] map = {
        { 0, 1, 1, 0, 0, 0, 0, 0 }, /*정보*/
        { 1, 0, 1, 1, 0, 0, 0, 0 }, /*전산*/
        { 1, 1, 0, 1, 1, 0, 0, 0 }, /*미래*/
        { 0, 1, 1, 0, 1, 1, 0, 0 }, /*신양*/
        { 0, 0, 1, 1, 0, 1, 1, 0 }, /*한경*/
        { 0, 0, 0, 1, 1, 0, 0, 1 }, /*진리*/
        { 0, 0, 0, 0, 1, 0, 0, 1 }, /*형남*/
        { 0, 0, 0, 0, 0, 1, 1, 0 }, /*학생*/
    };
    
    public long[][] multiply(long[][] a, long[][] b) {
        long[][] ret = new long[8][8];

        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                for(int k = 0; k < 8; ++k) {
                    ret[i][j] += a[i][k] * b[k][j];
                    ret[i][j] %= div;
                }
                ret[i][j] %= div;
            }
        }

        return ret;
    }
    public long solve(long d) {
        long[][] res = new long[8][8];
        for(int i = 0; i < 8; ++i) {res[i][i] = 1;}

        while(d != 0) {
            if((d & 1) == 1){
                res = multiply(res, map);
                d -= 1;
            }
            map = multiply(map, map);
            d /= 2;
        }
        
        return res[0][0];
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon12850 problem = new Baekjoon12850();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long d = Long.parseLong(br.readLine());
        System.out.println(problem.solve(d));
    }
}
