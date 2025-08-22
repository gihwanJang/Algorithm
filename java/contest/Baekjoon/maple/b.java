import java.io.*;
import java.util.Arrays;

public class b {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] abc = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int A = abc[0];
        int B = abc[1];
        int C = abc[2];

        int[] sv = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int S = sv[0];
        int V = sv[1];

        int level = Integer.parseInt(br.readLine());

        int requiredExp = (250 - level) * 100;
        int time = 0;

        int[][] tickets = {
            {C, V},
            {B, S}
        };

        for (int[] t : tickets) {
            int expPerMin = t[0];
            int count = t[1];
            for (int i = 0; i < count; i++) {
                int gain = expPerMin * 30;
                if (requiredExp <= gain) {
                    int minutesNeeded = (requiredExp + expPerMin - 1) / expPerMin;
                    time += minutesNeeded;
                    System.out.println(time);
                    return;
                } else {
                    requiredExp -= gain;
                    time += 30;
                }
            }
        }

        int minutesNeeded = (requiredExp + A - 1) / A;
        time += minutesNeeded;

        System.out.println(time);
    }
}
