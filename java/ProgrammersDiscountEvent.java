import java.util.HashMap;
import java.util.Map;

public class ProgrammersDiscountEvent {

    private Map<String,Integer> mapping(String[] want, int[] number){
        Map<String,Integer> map = new HashMap<>(13);
        for(int i = 0; i < want.length; ++i)
            map.put(want[i], number[i]);
        return map;
    }

    private boolean compareDiscountItem(Map<String, Integer> map, String[] discount, int idx){
        Map<String,Integer> discountMap = new HashMap<>(13);
        for(int i = 0; i < 10; ++i){
            if(map.containsKey(discount[i+idx])){
                if(discountMap.containsKey(discount[i+idx]))
                    discountMap.put(discount[i+idx], discountMap.get(discount[i+idx])+1);
                else
                    discountMap.put(discount[i+idx], 1);
            }
            else{
                return false;
            }
        }
        for(String s : map.keySet())
            if(map.get(s) != discountMap.get(s))
                return false;
        return true;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int ans = 0;
        Map<String, Integer> map = mapping(want, number);
        for(int i = 0; i <= discount.length - 10; ++i)
            if(compareDiscountItem(map, discount, i))
                ++ans;
        return ans;
    }

    public static void main(String[] args) {
        ProgrammersDiscountEvent problem = new ProgrammersDiscountEvent();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        
        System.out.println(problem.solution(want, number, discount));
    }
    
}
