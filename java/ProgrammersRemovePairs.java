public class ProgrammersRemovePairs {

    private boolean checkPairs(String s){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); ++i){
            if(sb.length() == 0)
                sb.append(s.charAt(i));
            else if(sb.charAt(sb.length() - 1) == s.charAt(i))
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(s.charAt(i));
        }

        return sb.length() == 0;
    }

    public int solution(String s) {
        return checkPairs(s) ? 1 : 0;
    }

    public static void main(String[] args) {
        ProgrammersRemovePairs problem = new ProgrammersRemovePairs();

        System.out.println(problem.solution("baabaa"));
    }
    
}
