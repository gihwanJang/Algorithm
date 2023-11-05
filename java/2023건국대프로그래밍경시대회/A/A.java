import java.io.*;
import java.util.*;

public class A {
    int n, m;
    String[] strings;

    private int countLine(String s) {
        int num = s.charAt(0) == '1' ? 1 : 0;
        for(int i = 1; i < m; ++i)
            if(s.charAt(i-1) == '0' && s.charAt(i) == '1')
                ++num;
        return num;
    }

    public String solve() {
        int lineNum = 0;
        int stringNum = 0;
        StringBuilder sb = new StringBuilder(); 
        for(String s : strings) {
            int lineCnt = countLine(s);
            if(lineCnt > lineNum) {
                lineNum = lineCnt;
                stringNum = 1;
            }else if(lineCnt == lineNum) {
                ++stringNum;
            }
        }
        return sb.append(lineNum + " " + stringNum).toString();
    }

    public static void main(String[] args) throws IOException {
        A problem = new A();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        problem.n = Integer.parseInt(st.nextToken());
        problem.m = Integer.parseInt(st.nextToken());
        problem.strings = new String[problem.n];
        for(int i = 0 ; i < problem.n; ++i)
            problem.strings[i] = br.readLine();
        System.out.println(problem.solve());
    }
}
