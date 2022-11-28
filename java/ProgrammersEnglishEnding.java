import java.util.HashSet;
import java.util.Set;

public class ProgrammersEnglishEnding {

    private boolean checkFirstWord(String s){
        return s.length() == 1;
    }

    private boolean checkStartPrevChar(String prev, String curr){
        return prev.charAt(prev.length() - 1) == curr.charAt(0);
    }

    private boolean checkWordDuplicted(Set<String> set, String word){
        if(set.contains(word)) return true;
        
        set.add(word);
        return false;
    }

    private void checkEnding(int n, String[] words, int[] answer){
        Set<String> set = new HashSet<>(words.length);
        set.add(words[0]);

        for(int i = 1; i < words.length; ++i)
            if(words[i].length() == 1 || !checkStartPrevChar(words[i - 1], words[i]) || checkWordDuplicted(set, words[i])){
                answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                answer[1] = i / n + 1;
                break;
            }
    }

    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        if(checkFirstWord(words[0])){
            answer[0] = answer[1] = 1;
            return answer;
        }

        checkEnding(n, words, answer);

        return answer;
    }
    
    public static void main(String[] args) {
        ProgrammersEnglishEnding problem = new ProgrammersEnglishEnding();

        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

        for(int v : problem.solution(5, words))
            System.out.println(v);
    }

}
