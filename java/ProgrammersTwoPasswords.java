import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammersTwoPasswords{

    private List<Boolean> makeSkipList(String skip){
        List<Boolean> skipList = new ArrayList<>(Collections.nCopies(26, false));

        for(int i = 0; i < skip.length(); ++i)
            skipList.set(skip.charAt(i) - 97, true);

        return skipList;
    }

    private char decodeChar(char c, List<Boolean> skipList, int index){
        for(int i = 0; i < index; ++i){
            ++c;
            if(c > 122)
                c -= 26;
            while(skipList.get(c - 97)){
                ++c;
                if(c > 122)
                    c -= 26;
            }
        }

        return c;
    }

    public String solution(String s, String skip, int index) {
        List<Boolean> skipList = makeSkipList(skip);
        String ans = "";

        for(int i = 0; i < s.length(); ++i)
            ans += decodeChar(s.charAt(i), skipList, index);

        return ans;
    }

    public static void main(String[] args) {
        ProgrammersTwoPasswords problem = new ProgrammersTwoPasswords();

        System.out.println(problem.solution("aukks", "wbqd", 5));
    }

}