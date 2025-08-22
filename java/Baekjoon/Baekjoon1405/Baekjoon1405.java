import java.io.*;
import java.util.*;

class Problem {
    int n;
    double total;
    double[] persents;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public Problem(int n) {
        this.n = n;
        total = 0;
        persents = new double[4];
    }

    public double solve() {
        boolean[][] visited = new boolean[30][30];
        visited[14][14] = true;
        DFS(14, 14, 0, 1, visited);
        return total;
    }

    private void DFS(int x, int y, int d, double p, boolean[][] visited) {
        if(d == n) {
            total += p;
            return;
        }
        for(int i = 0; i < 4; ++i) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(!visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                DFS(nextX, nextY, d+1, p * persents[i], visited);
                visited[nextX][nextY] = false;
            }
        }
    }
}

public class Baekjoon1405 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Integer.parseInt(st.nextToken()));

        for(int i = 0; i < 4; ++i) {
            problem.persents[i] = Double.parseDouble(st.nextToken()) / 100;
        }

        System.out.println(problem.solve());
    }
}
