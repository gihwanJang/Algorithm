import java.io.*;
import java.util.*;

class Problem {
    int n, m, r = 0, c = 0;
    char[][] paper;

    public Problem(int n, int m) {
        this.n = n;
        this.m = m;
        paper = new char[3*n][8*m];
    }

    public void solve() {
        int a, b, k, ans;
        while(r != 3*n) {
            a = paper[r+1][c+1] - '0';
            b = paper[r+1][c+3] - '0';
            k = a+b;
            ans = -1;

            if(paper[r+1][c+5] != '.') {
                ans = (paper[r+1][c+5] - '0');
            }
            if(paper[r+1][c+6] != '.') {
                if(ans == -1) {
                    ans = 0;
                }
                ans *= 10;
                ans += paper[r+1][c+6] - '0';
            }
            if(k == ans) {
                makeCorrect(ans > 9 ? 2 : 1);
            } else {
                makeWrong();
            }

            moveNext();
        }
    }

    private void makeCorrect(int digit) {
        paper[r+1][c] = '*';
        for(int i = 1; i < 6; ++i) {
            paper[r][c+i] = '*';
            paper[r+2][c+i] = '*';
        }
        if(digit == 1) {
            paper[r+1][c+6] = '*';
        } else {
            paper[r][c+6] = '*';
            paper[r+1][c+7] = '*';
            paper[r+2][c+6] = '*';
        }
    }

    private void makeWrong() {
        paper[r][c+3] = '/';
        paper[r+1][c+2] = '/';
        paper[r+2][c+1] = '/';
    }

    private void moveNext() {
        c += 8;
        if(8*m <= c) {
            c = 0;
            r += 3;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < paper.length; ++i) {
            for(int j = 0; j < paper[i].length; ++j) {
                sb.append(paper[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        for(int i = 0; i < problem.n*3; ++i) {
            String s = br.readLine();
            for(int j = 0; j < s.length(); ++j) {
                problem.paper[i][j] = s.charAt(j);
            }
        }

        problem.solve();

        System.out.print(problem);
    }    
}
