import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon15481 {
    public static class Edge implements Comparable<Edge>{
        int u,v,w;
        public Edge(int u, int v, int w){
            this.u=u;
            this.v=v;
            this. w=w;
        }
        @Override
        public int compareTo(Edge e){
            return e.w-this.w;
        }
    }
    static int[] group;
 
    static int find(int v) {
        if(group[v] == v) return v;
        return group[v] = find(group[v]);
    }
     
    static boolean union(int u, int v) {
        u = find(u); v = find(v);
        if(u == v) return false;
        group[v] = u;
        return true;
    }

    public static int solution(List<Edge> edges, int N, int M){
        int cost=0,edge=0;
        group = new int[N];
        for (int i = 0; i < N; i++)
            group[i] = i;

        for(int i=M; i>-1; --i){
            if(edge == N - 1)break;
            Edge E = edges.get(i);
            if(union(E.u, E.v)){
                cost += E.w;
                edge += 1;
            }
        }
        
        return cost;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M];
        List<Edge> sortedEdges =  new ArrayList<>(M);

        for(int i=0; i<M; ++i){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken())-1;
            int v=Integer.parseInt(st.nextToken())-1;
            int w=Integer.parseInt(st.nextToken());
            edges[i]=new Edge(u, v, w);
            sortedEdges.add(edges[i]);
        }

        sortedEdges.sort(null);

        for(int i=0; i<M; ++i){
            sortedEdges.add(edges[i]);
            System.out.println(solution(sortedEdges, N, M));
            sortedEdges.remove(M);
        }
        
    }    
}
