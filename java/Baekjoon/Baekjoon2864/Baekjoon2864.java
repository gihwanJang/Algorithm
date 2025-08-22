import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2864 {

    private static int getMin(String num){
        return Integer.valueOf(num.replace("6", "5"));
    }

    private static int getMax(String num){
        return Integer.valueOf(num.replace("5", "6"));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numberStrings = br.readLine().split(" ");

        
        System.out.print(getMin(numberStrings[0]) + getMin(numberStrings[1]) + " ");
        System.out.print(getMax(numberStrings[0]) + getMax(numberStrings[1]) + "\n");
    }
    
}
