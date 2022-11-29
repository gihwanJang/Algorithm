import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammersBiggestNum {

    private List<String> convertToString(int[] numbers){
        List<String> numS = new ArrayList<>(numbers.length);
        for(int i = 0; i < numbers.length; ++i)
            numS.add(Integer.toString(numbers[i]));

        Collections.sort(numS, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        return numS;
    }

    private String makeNumber(List<String> numbers){
        if(numbers.get(0).equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numbers.size(); ++i)
            sb.append(numbers.get(i));

        return sb.toString();
    }

    public String solution(int[] numbers) {
        return makeNumber(convertToString(numbers));
    }
 
    public static void main(String[] args) {
        ProgrammersBiggestNum problem = new ProgrammersBiggestNum();

        int numbers[] = {2,1,3};

        System.out.println(problem.solution(numbers));
    }

}
