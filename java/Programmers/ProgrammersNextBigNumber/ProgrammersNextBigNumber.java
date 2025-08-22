public class ProgrammersNextBigNumber {

    private int findNextBingNum(int current){
        int next = current + 1;
        int nextOneCount = 0;
        int currentOneCount = countBinaryOfOne(current);

        for(; currentOneCount != nextOneCount; ++next)
            nextOneCount = countBinaryOfOne(next);
        
        return next - 1;
    }

    private int countBinaryOfOne(int n){
        int oneCount = 0;

        for(; n > 0; n /= 2)
            if(n % 2 == 1)
                ++oneCount;

        return oneCount;
    }

    public int solution(int n) {
        return findNextBingNum(n);
    }

    public static void main(String[] args) {
        ProgrammersNextBigNumber problem = new ProgrammersNextBigNumber();

        System.out.println(problem.solution(15));
    }

}
