import java.util.LinkedList;
import java.util.List;

public class ProgrammersMakeHamberger {
    private boolean checkIngredient(List<Integer> ingredients){
        if(ingredients.size() < 4) return false;

        boolean check = false;

        for(int i = ingredients.size() - 4, j = 1; j < 4; ++i, ++j){
            if(ingredients.get(i) == j)
                check = true;
            else{
                check = false;
                break;
            }
        }

        if(check)
            for(int i = 0; i < 4; ++i)
                ingredients.remove(ingredients.size()-1);

        return check;
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> ingredients = new LinkedList<>();

        for(int i = 0; i < ingredient.length; ++i){
            ingredients.add(ingredient[i]);
            if(ingredient[i] == 1)
                if(checkIngredient(ingredients))
                    ++answer;
        }
        
        return answer;
    }
    public static void main(String[] args) {
        ProgrammersMakeHamberger s = new ProgrammersMakeHamberger();
        int ingredient[] = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        System.out.println(s.solution(ingredient));
    }
}
