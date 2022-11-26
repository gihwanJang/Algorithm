public class ProgrammersRepeatBinaryConversion {

    private int countZero(String s){
        int zero = 0;
        for(int i = 0; i < s.length(); ++i)
            if(s.charAt(i) == '0')
                ++zero;
        return zero;
    }

    private String convertBinary(int length){
        StringBuilder sb = new StringBuilder();
        for(; length > 0; length /= 2)
            sb.append(length % 2);
        
        return sb.toString();
    }

    private void binaryConversion(int[] answer, String s){
        if(s.equals("1")) return;

        int zero = countZero(s);
        ++answer[0];
        answer[1] += zero;

        binaryConversion(answer, convertBinary(s.length() - zero));
    }

    public int[] solution(String s) {
        int[] answer = {0, 0};

        binaryConversion(answer, s);

        return answer;
    }

    public static void main(String[] args) {
        ProgrammersRepeatBinaryConversion problem = new ProgrammersRepeatBinaryConversion();

        for(int i : problem.solution("01110"))
            System.out.println(i);
    }
    
}
