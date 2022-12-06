public class ProgrammersSplitString {

    private int split(String s){
        int x = 1, nx = 0, ans = 1;

        for(int i = 1; i < s.length(); ++i){
            if(x == nx){
                ans += split(s.substring(i));
                break;
            }

            if(s.charAt(0) == s.charAt(i))++x;
            else ++nx;
        }

        return ans;
    }

    public int solution(String s) {
        return split(s);
    }

    public static void main(String[] args) {
        ProgrammersSplitString problem = new ProgrammersSplitString();

        System.out.println(problem.solution("abracadabra"));
    }
    
}
