import java.util.ArrayList;
import java.util.List;

public class ProgrammersLongJump {

    private int moduler(int a, int b){
        return (a % 1234567 + b % 1234567) % 1234567;
    }

    private long jump(int n){
        List<Integer> table = new ArrayList<>(n);

        table.add(1);
        table.add(2);
        for(int i = 2; i < n; ++i)
            table.add(moduler(table.get(i - 2), table.get(i - 1)));

        return table.get(n - 1);
    }

    public long solution(int n) {
        return jump(n);
    }

    public static void main(String[] args) {
        ProgrammersLongJump problem = new ProgrammersLongJump();

        System.out.println(problem.solution(4));
    }
    
}
