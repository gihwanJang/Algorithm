import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammersNearestLetter {

    private void updateNearestLetter(List<Integer> set, List<Integer> nearestLetter, String s, int i){
        if(set.get(s.charAt(i) - 97) == -1)
            nearestLetter.add(-1);
        else
            nearestLetter.add(i - set.get(s.charAt(i) - 97));
        set.set(s.charAt(i) - 97, i);
    }

    private List<Integer> findNearestLetter(String s){
        List<Integer> set = new ArrayList(Collections.nCopies(26, -1));
        List<Integer> nearestLetter = new ArrayList<>(s.length());

        for(int i = 0; i < s.length(); ++i)
            updateNearestLetter(set, nearestLetter, s, i);

        return nearestLetter;
    }

    public int[] solution(String s) {
        return findNearestLetter(s).stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        ProgrammersNearestLetter problem = new ProgrammersNearestLetter();

        for(int v : problem.solution("foobar"))
            System.out.print(v + ", ");
    }
    
}
