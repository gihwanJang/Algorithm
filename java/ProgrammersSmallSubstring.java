public class ProgrammersSmallSubstring{

    private int countSubString(String t, String p){
        int ans = 0;

        for(int i = 0; i <= t.length() - p.length(); ++i)
            if(Double.valueOf(t.substring(i, i + p.length())) <= Double.valueOf(p))
                ++ans;

        return ans;
    }

    public int solution(String t, String p) {
        return countSubString(t, p);
    }

    public static void main(String[] args) {
        ProgrammersSmallSubstring problem = new ProgrammersSmallSubstring();
        System.out.println(problem.solution("500220839878","7"));
    }

}