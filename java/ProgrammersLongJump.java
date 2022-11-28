import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammersLongJump {

    private int moduler(int a, int b){
        return (a % 1234567 + b % 1234567) % 1234567;
    }

    private long jump(int n){
        List<Integer> table = new ArrayList<>(Collections.nCopies(n + 1, 0));

        table.set(0, 1);
        for(int i = 0; i < n; ++i){
            table.set(i + 1, moduler(table.get(i), table.get(i + 1)));
            if(i + 2 <= n)
                table.set(i + 2, moduler(table.get(i), table.get(i + 2)));
        }

        return table.get(n);
    }

    public long solution(int n) {
        return jump(n);
    }

    public static void main(String[] args) {
        ProgrammersLongJump problem = new ProgrammersLongJump();

        System.out.println(problem.solution(123));
    }
    
}
