import java.io.*;
import java.util.*;;

class Problem {
    private int[] input;

    public Problem() {
        try {
            input();
            output();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void output() {
        System.out.println(solve(input[0], input[2]));
    }

    private int solve(int total, int target) {
        int dead = input[1] % total;
        if(dead == 0) {
            dead = total;
        }
        if(dead == target || total == 1) {
            return 1;
        }
        if(target < dead) {
            target = (total - dead) + target;
        } else {
            target = target - dead;
        }
        return 1 + solve(total - 1, target);
    }
}

public class Baekjoon1242 {
    public static void main(String[] args) {
        new Problem();
    }
}
