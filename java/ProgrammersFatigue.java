import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammersFatigue {

    private int travle(int[][] dungeons, List<Boolean> visited, int k, int depth){
        int count = depth;

        for(int i = 0; i < dungeons.length; ++i)
            if(!visited.get(i) && k >= dungeons[i][0]){
                visited.set(i, true);
                count = Math.max(count, travle(dungeons, visited, k-dungeons[i][1], depth+1));
                visited.set(i, false);
            }

        return count;
    }

    public int solution(int k, int[][] dungeons) {
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(dungeons.length, false));
        return travle(dungeons, visited, k, 0);
    }

    public static void main(String[] args) {
        ProgrammersFatigue problem = new ProgrammersFatigue();
        int dungeons[][] = {{80,20},{50,40},{30,10}};
        System.out.println(problem.solution(80, dungeons));
    }
    
}
