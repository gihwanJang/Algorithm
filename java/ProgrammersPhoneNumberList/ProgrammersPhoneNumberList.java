import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ProgrammersPhoneNumberList{

    private boolean findPrefix(String number, Set<String> indexList){
        if(indexList.contains(number))
            return true;

        for(int i = 1; i <= number.length(); ++i)
            indexList.add(number.substring(0, i));

        return false;
    }

    private boolean mapping(String[] phone_book){
        List<Set<String>> indexList = new ArrayList<>(10);
        for(int i = 0; i < 10; ++i)
            indexList.add(new HashSet<String>(100));

        for(int i = 0; i < phone_book.length; ++i)
            if(findPrefix(phone_book[i], indexList.get(phone_book[i].charAt(0) - 48)))
                return false;
        
        return true;
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (String s1, String s2) -> s2.length() - s1.length());
        return mapping(phone_book);
    }

    public static void main(String[] args) {
        ProgrammersPhoneNumberList problem = new ProgrammersPhoneNumberList();
        String nums[] = {"12", "123", "1235", "567", "88"};
        System.out.println(problem.solution(nums));
    }

}