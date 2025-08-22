import java.io.*;
import java.util.*;

class Problem {
    int[][] map;
    int r1, c1, r2, c2;
    public Problem(String r1, String c1, String r2, String c2) {
        this.r1 = Integer.parseInt(r1);
        this.c1 = Integer.parseInt(c1);
        this.r2 = Integer.parseInt(r2);
        this.c2 = Integer.parseInt(c2);
        map = new int[this.r2-this.r1+1][this.c2-this.c1+1];
    }
    public String solve() {
        int count = 1;
        long max = 10;
        StringBuilder sb = new StringBuilder();
        for(int r = r1; r <= r2; ++r) {
            for(int c = c1; c <= c2; ++c) {
                map[r-r1][c-c1] = getLocationValue(r, c);
                while(map[r-r1][c-c1] >= max) {
                    ++count;
                    max *= 10;
                }
            }
        }
        for(int r = 0; r < map.length; ++r) {
            for(int c = 0; c < map[0].length; ++c) {
                String v = String.valueOf(map[r][c]);
                for(int i = 0; i < count - v.length(); ++i) {
                    sb.append(' ');
                }
                sb.append(v).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
    private int getLocationValue(int r, int c) {
        int currR = Math.max(Math.abs(r), Math.abs(c));
        int currC = currR;
        int seq = 2*currC+1;
        int value = seq*seq;

        for(int i = 0; i < 2; ++i) {
            if(r == currR) {
                return value - Math.abs(currC - c);
            } else {
                value -= seq-1;
                currC *= -1;
            }

            if(c == currC) {
                return value - Math.abs(currR - r);
            } else {
                value -= seq-1;
                currR *=-1;
            }
        }
        return -1;
    }
}

public class Baekjoon1022 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
        System.out.print(p.solve());
    }
}
