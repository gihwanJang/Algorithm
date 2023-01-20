import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProgrammersPrinter {

    public int solution(int[] priorities, int location) {
        List<List<Integer>> result = new ArrayList<>(priorities.length);
        Queue<List<Integer>> prints = new LinkedList<>();
        for(int i = 0; i < priorities.length; ++i)
            prints.add(List.of(priorities[i], i));

        Arrays.sort(priorities);

        for(int i = priorities.length - 1; i >= 0; --i){
            while(prints.peek().get(0) != priorities[i])
                prints.add(prints.poll());
            
            result.add(prints.poll());
        }

        for(int i = 0; i < result.size(); ++i)
            if(result.get(i).get(1) == location)
                return i + 1;
        
        return 0;
    }

    public static void main(String[] args) {
        ProgrammersPrinter problem = new ProgrammersPrinter();
        int priorities[] = {2,1,3,2};
        System.out.println(problem.solution(priorities, 2));
    }
    
}
