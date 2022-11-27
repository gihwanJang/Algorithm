import java.util.ArrayList;
import java.util.List;

public class ProgrammersFibonacciNum {

    private int moduler(int a, int b){
        return (a % 1234567 + b % 1234567) % 1234567;
    }

    private int Fibonacci(int n){
        List<Integer> fiboTable = new ArrayList<>(n + 1);

        fiboTable.add(0);
        fiboTable.add(1);
        for(int i = 2; i <= n; ++i)
            fiboTable.add(moduler(fiboTable.get(i - 1), fiboTable.get(i - 2)));

        return fiboTable.get(n);
    }

    public int solution(int n) {
        return Fibonacci(n);
    }

    public static void main(String[] args) {
        ProgrammersFibonacciNum problem = new ProgrammersFibonacciNum();

        System.out.println(problem.solution(5));
    }
    
}
