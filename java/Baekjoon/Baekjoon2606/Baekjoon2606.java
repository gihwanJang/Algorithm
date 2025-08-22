import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon2606{

    private static int DFS(List<List<Boolean>> graph, int n){
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(n + 1, false));
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        stack.push(1);
        while(!stack.isEmpty()){
            int curr = stack.pop();
            visited.set(curr, true);
            for(int i = 2; i <= n; ++i)
                if(graph.get(curr).get(i) && !visited.get(i))
                    stack.add(i);
        }

        for(int i = 2; i <= n; ++i)
            if(visited.get(i))
                ++count;

        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;  

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Boolean>> graph = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; ++i)
            graph.add(new ArrayList<>(Collections.nCopies(n + 1, false)));
        
        for(int i = 0; i < m; ++i){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v).set(w, true);
            graph.get(w).set(v, true);
        }
        
        System.out.println(DFS(graph, n));
    }

}