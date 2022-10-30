import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon11403 {
    public static void DFS(int N, int[][] W,  HashSet<Integer> set, int node, int r){
        for(int c=0; c<N; ++c)
            if(W[r][c]==1&&!set.contains(c)){
                W[node][c]=1;
                set.add(c);
                DFS(N, W, set, node, c);
            }
    }
    public static int[][] solution(int N, int[][] G){
        int[][] W = G;

        for(int r = 0; r<N; ++r){
            HashSet<Integer> set = new HashSet<>((int)(N*1.3));
            DFS(N, W, set, r, r);
        }

        return W;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] G = new int[N][N];

        for(int r=0; r<N; ++r){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; ++c)
                G[r][c]=Integer.parseInt(st.nextToken());
        }

        for(int[] r: solution(N, G)){
            for(int c=0; c<r.length; ++c)
                System.out.print(r[c]+" ");
            System.out.println();
        }
    }    
}
