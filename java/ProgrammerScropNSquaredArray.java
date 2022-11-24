import java.util.ArrayList;
import java.util.List;

public class ProgrammerScropNSquaredArray {

    private List<Integer> makeSubMatrix(int n,  long left, long right){
        List<Integer> subMatrix = new ArrayList<>((int)(right - left + 1));

        for(long r = left / n; r <= right / n; ++r)
            for(int c = 0; c < n; ++c)
                if(left <= r * n + c && r * n + c <= right)
                    subMatrix.add(Math.max((int)r + 1, c + 1));

        return subMatrix;
    }

    public int[] solution(int n, long left, long right) {
        return makeSubMatrix(n, left, right).stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        ProgrammerScropNSquaredArray problem = new ProgrammerScropNSquaredArray();

        for(int i : problem.solution(4, 7, 14))
            System.out.print(i + ", ");
    }
    
}
