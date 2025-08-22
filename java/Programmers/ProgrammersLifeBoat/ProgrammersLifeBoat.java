import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProgrammersLifeBoat{

    private int countingBoat(List<Integer> people, int limit){
        List<Integer> boats = new LinkedList<>();
        boats.add(0);

        for(Integer w : people){
            boolean riding = false;
            for(int i = 0; i < boats.size(); ++i)
                if(boats.get(i) + w <= limit){
                    boats.set(i, boats.get(i) + w);
                    riding = true;
                    break;
                }
            if(!riding)
                boats.add(w);
        }

        return boats.size();
    }

    public int solution(int[] people, int limit) {
        List<Integer> weight = new ArrayList<>(people.length);

        for(int i = 0; i < people.length; ++i)
            weight.add(people[i]);

        weight.sort(Comparator.reverseOrder());
        
        return countingBoat(weight, limit);
    }

    public static void main(String[] args) {
        ProgrammersLifeBoat problem = new ProgrammersLifeBoat();

        int people[] = {70, 50, 80, 60, 50, 40};
        int limit = 100;
        
        System.out.println(problem.solution(people, limit));
    }

}