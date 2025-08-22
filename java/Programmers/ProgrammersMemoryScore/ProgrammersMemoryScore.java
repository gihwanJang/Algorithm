import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        ArrayList<Integer> answer = new ArrayList<>(Collections.nCopies(photo.length, 0)); 
        HashMap<String, Integer> map = new HashMap<>(name.length * 2);

        for(int i = 0; i < name.length; ++i)
            map.put(name[i], yearning[i]);

        for(int i = 0; i < photo.length; ++i)
            for(int j = 0; j < photo[i].length; ++j)
                if(map.containsKey(photo[i][j]))
                    answer.set(i, answer.get(i) + map.get(photo[i][j]));

        return answer.stream().mapToInt(i -> i).toArray();
    }
}

public class ProgrammersMemoryScore {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        int[] ans = solution.solution(name, yearning, photo);

        for(int i = 0; i < ans.length; ++i)
            System.out.println(ans[i]);
    }
}