import java.io.*;
import java.util.*;

class Edge {
    int e, v;

    public Edge(int e, int v) {
        this.e = e;
        this.v = v;
    }
}

class Problem {
	int n, k;
	List<List<Edge>> graph;
	
	public Problem(int n, int k) {
        this.n = n;
        this.k = k;
        graph = new ArrayList<>(n);
        for(int i = 0; i < n; ++i)
            graph.add(new ArrayList<>());
	}
	
	public String solve() {
		StringBuilder sb = new StringBuilder();
        return sb.toString();
	}

    private void travle() {
        
    }
}

public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int edges = Integer.parseInt(br.readLine());

        for(int i = 0; i < edges; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = st.nextToken().charAt(0) - 'A';
            int e = st.nextToken().charAt(0) - 'A';
            int v = Integer.parseInt(st.nextToken());

            problem.graph.get(s).add(new Edge(e, v));
        }

		System.out.println();
	}
}