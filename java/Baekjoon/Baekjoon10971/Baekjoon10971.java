import java.util.*;
import java.io.*;

class TravleInfo {
    int[][] graph;
    int size;
    int value;
    int visited;

    public TravleInfo(int[][] graph, int size, int value, int visited) {
        this.graph = graph;
        this.size = size;
        this.value = value;
        this.visited = visited;
    }

    public boolean isVisited(int i) {
        return (((1 << i) & visited) > 0);
    }

    public void visit(int i) {
        visited |= 1 << i;
    }

    public void notVisit(int i) { 
        visited &= ~(1 << i);
    }
}

public class Baekjoon10971 {
    public int travle(TravleInfo info, int start, int curr) {
        if(info.visited == (1 << info.size) - 1 && info.graph[curr][start] != 0)
            return info.value + info.graph[curr][start];

        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i < info.size; ++i)
            if(!info.isVisited(i) && info.graph[curr][i] != 0) {
                info.visit(i);
                info.value += info.graph[curr][i];
                minValue = Math.min(minValue, travle(info, start, i));
                info.value -= info.graph[curr][i];
                info.notVisit(i);
            }

        return minValue;
    }

    public int solve(int[][] graph, int n) {
        int minValue = Integer.MAX_VALUE;
        TravleInfo info = new TravleInfo(graph, n, 0, 0);

        for(int i = 0; i < n; ++i) {
            info.visit(i);
            minValue = Math.min(minValue, travle(info, i, i));
            info.notVisit(i);
        }

        return minValue; 
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        StringTokenizer st;
        Baekjoon10971 problem = new Baekjoon10971();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];

        for(int r = 0; r < n; ++r) {
            st = new StringTokenizer(br.readLine());

            for(int c = 0; c < n; ++c)
                graph[r][c] = Integer.parseInt(st.nextToken());
        }

        System.out.println(problem.solve(graph, n));
    }
}
