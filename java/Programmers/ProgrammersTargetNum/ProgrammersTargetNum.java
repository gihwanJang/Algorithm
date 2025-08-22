public class ProgrammersTargetNum {

    private int bruteForce(int[] numbers, int target, int depth){
        if(numbers.length == depth)
            return (target == 0 ? 1 : 0);

        int count = 0;

        count += bruteForce(numbers, target + numbers[depth], depth + 1);
        count += bruteForce(numbers, target - numbers[depth], depth + 1);

        return count;
    }

    public int solution(int[] numbers, int target) {
        return bruteForce(numbers, target, 0);
    }

    public static void main(String[] args) {
        ProgrammersTargetNum problem = new ProgrammersTargetNum();

        int numbers[] = {4,1,2,1};

        System.out.println(problem.solution(numbers, 2));
    }
    
}
