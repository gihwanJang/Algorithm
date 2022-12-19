import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ProgrammersTuple {

    private List<Set<Integer>> makeSetList(String s){
        String firstTrans[] = s.substring(1, s.length()-2).split("},");
        List<Set<Integer>> setList = new ArrayList<>(firstTrans.length);

        for(String str : firstTrans){
            String secondTrans[] = str.substring(1, str.length()).split(",");
            Set<Integer> newSet = new HashSet<>(secondTrans.length * 2);
            for(String num : secondTrans)
                newSet.add(Integer.valueOf(num));
            setList.add(newSet);
        }

        return setList;
    }

    private List<Integer> makeTuple(String s){
        List<Set<Integer>> setList = makeSetList(s);
        List<Integer> tuple = new LinkedList<>();

        setList.sort(new Comparator<Set<Integer>>() {
            public int compare(Set<Integer> o1, Set<Integer> o2){
                return Integer.compare(o1.size(), o2.size());
            }
        });

        for(Set<Integer> set : setList)
            for(Integer v : set)
                if(!tuple.contains(v))
                    tuple.add(v);

        return tuple;
    }

    public int[] solution(String s) {
        return makeTuple(s).stream().mapToInt(i->i).toArray();
    }
    
    public static void main(String[] args) {
        ProgrammersTuple problem = new ProgrammersTuple();

        for(int v : problem.solution("{{123}}"))
            System.out.print(v + ", ");
    }

}
