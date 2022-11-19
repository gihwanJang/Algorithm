public class ProgrammersTemplarsWeapon {

    private int countNumberOfDivisors(int number){
        int numberOfDivisors = 0;

        for(int i = 1; i * i <= number; ++i)
            if(number % i == 0){
                ++numberOfDivisors;
                if(i * i < number)
                    ++numberOfDivisors;
            }

        return numberOfDivisors;
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i = 1, p; i <= number; ++i){
            p = countNumberOfDivisors(i);
            answer += p;
            if(p > limit)
                answer += power - p;
        }

        return answer;
    }

    public static void main(String[] args) {
        ProgrammersTemplarsWeapon problem = new ProgrammersTemplarsWeapon();

        System.out.println(problem.solution(10, 3, 2));
    }
    
}
