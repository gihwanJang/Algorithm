import java.util.ArrayList;
import java.util.List;

public class ProgrammersStockPrice {

    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>(prices.length);
        for(int i = 0; i < prices.length; ++i){
            int count = 0;
            for(int j = i + 1; j < prices.length; ++j){
                ++count;
                if(prices[i] > prices[j])
                    break;
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        ProgrammersStockPrice problem = new ProgrammersStockPrice();
        int prices[] = {1, 2, 3, 2, 3};
        for(int v : problem.solution(prices))
            System.out.println(v);
    }
    
}
