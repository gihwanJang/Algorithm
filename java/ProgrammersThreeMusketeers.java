public class ProgrammersThreeMusketeers {
    public int solution(int[] number) {
        int answer = 0;

        for(int i = 0; i < number.length; ++i)
            for(int j = i + 1; j < number.length; ++j)
                for(int k = j + 1; k < number.length; ++k)
                    if(number[i] + number[j] == -number[k])
                        ++answer;

        return answer;
    }
    public static void main(String[] args) {
        ProgrammersThreeMusketeers threeMusketeers = new ProgrammersThreeMusketeers();
        int number[] = {-2, 3, 0, 2, -5};
        System.out.println(threeMusketeers.solution(number));
    }
}
