import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProgrammersFunctionDevelopment{

    private class Process{
        private int p, s;

        public Process(int p, int s){
            this.p = p;
            this.s = s;
        }

        public int getP(){
            return p;
        }

        public int getS(){
            return s;
        }

        public void setP(int p){
            this.p = p;
        }
    }

    private void work(Queue<Process> que, List<Integer> ans){
        int count = 0;
        for(Process pc : que)
            pc.setP(pc.getP() + pc.getS());
        
        while(!que.isEmpty() && que.peek().getP() >= 100){
            que.poll();
            ++count;
        }

        if(count > 0)
            ans.add(count);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new LinkedList<>();
        Queue<Process> que = new LinkedList<>();

        for(int i = 0; i < progresses.length; ++i)
            que.add(new Process(progresses[i], speeds[i]));

        while(!que.isEmpty())
            work(que, ans);
        
        return ans.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        ProgrammersFunctionDevelopment problem = new ProgrammersFunctionDevelopment();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        for(int i : problem.solution(progresses, speeds))
            System.out.println(i);
    }

}