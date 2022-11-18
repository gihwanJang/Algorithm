import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammersNumberPair {
    private void checkNumber(StringBuilder number){
        if(number.length() == 0)
            number.append("-1");
        
        if(number.charAt(0) == '0' && number.length() > 1)
            number.delete(1, number.length());
    }

    private void countNumber(String number, List<Integer> numbersCount){
        for(int i = 0; i < number.length(); ++i){
            int index = number.charAt(i) - '0';
            numbersCount.set(index, numbersCount.get(index) + 1);
        }
    }

    private String makeMaxNumber(List<Integer> xNumbersCount, List<Integer> yNumbersCount){
        StringBuilder number = new StringBuilder();

        for(int i = 9; i > -1; --i)
            if(xNumbersCount.get(i) != 0 && yNumbersCount.get(i) != 0)
                for(int pairCount = Math.min(xNumbersCount.get(i), yNumbersCount.get(i)); pairCount > 0; --pairCount)
                number.append(String.valueOf(i));

        checkNumber(number);

        return number.toString();
    }

    public String solution(String X, String Y) {
        List<Integer> xNumbersCount = new ArrayList<>(Collections.nCopies(10, 0));
        List<Integer> yNumbersCount = new ArrayList<>(Collections.nCopies(10, 0));

        countNumber(Y, yNumbersCount);
        countNumber(X, xNumbersCount);

        return makeMaxNumber(xNumbersCount, yNumbersCount);
    }

    public static void main(String[] args) {
        ProgrammersNumberPair problem = new ProgrammersNumberPair();

        System.out.println(problem.solution("100", "123450"));
    }

}
