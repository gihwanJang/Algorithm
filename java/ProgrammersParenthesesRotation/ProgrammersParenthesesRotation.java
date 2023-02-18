import java.util.Stack;

public class ProgrammersParenthesesRotation {

    private String rotationParentheses(String parentheses, int count){
        StringBuilder sb = new StringBuilder();

        for(int cnt = 0; cnt < parentheses.length(); ++cnt){
            sb.append(parentheses.charAt(count));
            count = (count + 1) % parentheses.length();
        }

        return sb.toString();
    }

    private boolean checkIsCorrect(char f, char b){
        if(f == '(' && b == ')')
            return true;
        if(f == '{' && b == '}')
            return true;
        if(f == '[' && b == ']')
            return true;
        return false;
    }

    private boolean checkCorrectParentheses(String parentheses){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < parentheses.length(); ++i){
            if(stack.isEmpty()){
                stack.add(parentheses.charAt(i));
                continue;
            }
            if(!checkIsCorrect(stack.peek(), parentheses.charAt(i))){
                stack.add(parentheses.charAt(i));
                continue;
            }
            stack.pop();
        }

        return stack.isEmpty();
    }

    public int solution(String s) {
        int answer = 0;

        for(int count = 0; count < s.length(); ++count)
            if(checkCorrectParentheses(rotationParentheses(s, count)))
                ++answer;
        
        return answer;
    }

    public static void main(String[] args) {
        ProgrammersParenthesesRotation problem = new ProgrammersParenthesesRotation();

        System.out.println(problem.solution("[](){}"));
        System.out.println(problem.solution("}]()[{"));
        System.out.println(problem.solution("[)(]"));
        System.out.println(problem.solution("}}}"));
    }
    
}
