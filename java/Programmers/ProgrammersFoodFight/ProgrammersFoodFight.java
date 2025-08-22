import java.lang.StringBuilder;

class Solution {
    public String solution(int[] food) {
        String sbStirng;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < food.length; ++i)
            for(int j = 0; j < food[i]/2; ++j)
                sb.append(String.valueOf(i));

        sbStirng = sb.toString();
        sb.reverse();

        return sbStirng + "0" + sb.toString();
    }
}

public class ProgrammersFoodFight{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int food[] = {1,2,3,5};
        System.out.println(sol.solution(food));
    }
}