import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon13305 {
    public static long solution(int N, int[] lengths, int[] costs){
        long cost=0, length=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N-1; ++i)
        pq.add(costs[i]);
        
        for(int i=N-2; i>=0; --i){
            length+=lengths[i];
            if(costs[i]==pq.peek()){
                cost+=length*costs[i];
                length=0;
            }
            pq.remove(costs[i]);
        }

        return cost;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lengths = new int[N];
        int[] costs = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; ++i)
            lengths[i]=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; ++i)
            costs[i]=Integer.parseInt(st.nextToken());
        
        System.out.println(solution(N, lengths, costs));
    }
}
