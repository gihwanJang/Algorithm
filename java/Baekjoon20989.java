import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjun20989 {
    public static int tsp(int[][] G, int[][] table, int curr, int visited){
        if (visited == (1 << G.length) - 1) {
            if (G[curr][0] == 0)
			    return 987654321;
			return G[curr][0];
		}

		if (table[curr][visited] != 987654321)
			return table[curr][visited];

		for (int i = 0; i < G.length; ++i)
			if ((visited & (1 << i)) == 0 && G[curr][i] != 0)
			    table[curr][visited] = Integer.min(table[curr][visited], tsp(G, table, i, visited | (1 << i)) + G[curr][i]);
        
        return table[curr][visited];
    }
    public static int solution(int N, int[][] G){
        int[][] table = new int[N][(1 << N) - 1];
        for (int i = 0; i < N; ++i)
			Arrays.fill(table[i], 987654321);
        return tsp(G, table, 0, 1);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] G = new int[N][N];

        for(int r=0; r<N; ++r){
            st= new StringTokenizer(br.readLine());
            for(int c=0; c<N; ++c)
                G[r][c] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, G));
    }
}
