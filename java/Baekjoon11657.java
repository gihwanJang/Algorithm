import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjun11657 {
    static int INF = 987654321;
    public static class Edge{
        int start, end, cost;
        public Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static boolean bellman_ford(int N, int M, Edge[] edges, long[] distence, int start){
        distence[start] = 0;

        for(int i=1; i<N; ++i)
            for(int j=0; j<M; ++j)
                if(distence[edges[j].start]!=INF)
                    distence[edges[j].end]=Long.min(distence[edges[j].end], distence[edges[j].start]+edges[j].cost);

        for(int i=0; i<M; ++i)
            if(distence[edges[i].start]!=INF && distence[edges[i].end]>distence[edges[i].start]+edges[i].cost)
                return true;

        return false;
    }
    public static String solution(int N, int M, Edge[] edges){
        StringBuilder sb = new StringBuilder();
        long[] distence = new long[N+1];
        Arrays.fill(distence, INF);

        if(bellman_ford(N, M, edges, distence, 1))
            sb.append("-1\n");
        else{
            for(int i=2; i<=N; ++i)
                sb.append(distence[i]==INF ? "-1\n" : distence[i]+"\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M];

        for(int i=0; i<M; ++i){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, cost);
        }

        System.out.print(solution(N, M, edges));
    }
}
