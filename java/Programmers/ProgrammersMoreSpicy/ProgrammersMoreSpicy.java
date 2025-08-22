import java.util.PriorityQueue;

public class ProgrammersMoreSpicy {

    private int makeSpicy(PriorityQueue<Integer> pq, int k){
        int count = 0;

        for(; pq.size() > 1 && pq.peek() < k; ++count)
            pq.add(pq.poll() + 2* pq.poll());

        return pq.peek() < k ? -1 : count;
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(scoville.length);
        for(int i = 0; i < scoville.length; ++i)
            pq.add(scoville[i]);

        return makeSpicy(pq, K);
    }

    public static void main(String[] args) {
        ProgrammersMoreSpicy problem = new ProgrammersMoreSpicy();
        int[] scoville ={1, 2, 3, 9, 10, 12};

        System.out.println(problem.solution(scoville, 7));
    }
    
}
