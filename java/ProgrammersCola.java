public class ProgrammersCola {
    public static int solution(int a, int b, int n) {
        int answer = 0, tmp;
        while(n >= a){
            tmp = (n / a) * b;
            answer += tmp;
            n -= a * (n /a) - tmp;

        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(3, 1, 20));
    }
}
