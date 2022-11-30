public class ProgrammersNLeastCommonMultiples {

    private int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }

    private int LCM(int a, int b){
        return a * b / GCD(a, b);
    }

    private int getNLCM(int[] arr){
        int lcm = LCM(arr[0], arr[1]);

        for(int i = 2; i < arr.length; ++i)
            lcm = lcm * arr[i] / GCD(lcm, arr[i]);

        return lcm;
    }

    public int solution(int[] arr) {
        if(arr.length == 1)
            return arr[0];
        return getNLCM(arr);
    }

    public static void main(String[] args) {
        ProgrammersNLeastCommonMultiples problem = new ProgrammersNLeastCommonMultiples();

        int arr[] = {  1,2,3  };

        System.out.println(problem.solution(arr));
    }
    
}
