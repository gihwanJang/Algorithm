import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ProgrammersFruitVendor{
    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        ArrayList<Integer> scores = new ArrayList<>(Arrays.stream(score).boxed().collect(Collectors.toList()));

        scores.sort(Comparator.reverseOrder());

        for(int box = m - 1; box < scores.size(); box += m)
            answer += scores.get(box) * m;

        return answer;
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(3,4, nums));
    }
}