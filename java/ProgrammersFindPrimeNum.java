import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgrammersFindPrimeNum {

    private List<Boolean> getPrimeNum(int length){
        int n = (int)Math.pow(10, length);
        List<Boolean> prime = new ArrayList<>(Collections.nCopies(n, false));

        prime.set(0, true);
        prime.set(1, true);
        for(int i =2 ; i*i < n; ++i)
            if(!prime.get(i))
            	for(int j = i*i; j < n; j += i)
                    prime.set(j,true);

        return prime;
    }

    private void insertSet(String numbers, Set<Integer> set, List<Boolean> visited, int curr, int depth){
        if(depth == numbers.length()) return;
        curr *= 10;
        
        for(int i = 0; i < numbers.length(); ++i)
            if(!visited.get(i)){
                visited.set(i, true);
                set.add(curr+numbers.charAt(i)-48);
                insertSet(numbers, set, visited, curr+numbers.charAt(i)-48, depth+1);
                visited.set(i, false);
            }

        return;
    }

    public int solution(String numbers) {
        int ans = 0;
        List<Boolean> prime = getPrimeNum(numbers.length());
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(numbers.length(), false));
        Set<Integer> set = new HashSet<>();

        insertSet(numbers, set, visited, 0, 0);

        for(int i : set){
            if(!prime.get(i)){
                System.out.println(i);
                ++ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ProgrammersFindPrimeNum problem = new ProgrammersFindPrimeNum();
        System.out.println(problem.solution("011"));
    }
    
}
