import java.util.Arrays;

public class ProgrammersDivideNumberCards {

    private int GCD(int a, int b){
        if(b == 0)  return a;
        return GCD(b, a % b);
    }

    private int getArrayGCD(int[] array){
        Arrays.sort(array);
        int gcd = array[0];

        for(int i = 1; i < array.length; ++i)
            gcd = GCD(array[i], gcd);

        return gcd;
    }

    private int checkIsDivide(int[] array, int gcd){
        if(gcd == 1) return 0;

        for(int i = 0; i < array.length; ++i)
            if(array[i] / gcd != 0 && array[i] % gcd == 0)
                return 0;

        return gcd;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = getArrayGCD(arrayA);
        int gcdB = getArrayGCD(arrayB);

        System.out.println("arrayA GCD : "+gcdA);
        System.out.println("arrayB GCD : "+gcdB);

        gcdA = checkIsDivide(arrayB, gcdA);
        gcdB = checkIsDivide(arrayA, gcdB);

        return Math.max(gcdA, gcdB);
    }

    public static void main(String[] args) {
        ProgrammersDivideNumberCards problem = new ProgrammersDivideNumberCards();

        int arrayA[] = {14, 35, 119};
        int arrayB[] = {18, 30, 102};

        System.out.println(problem.solution(arrayA, arrayB));
    }
    
}
