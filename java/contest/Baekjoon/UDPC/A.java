import java.io.*;
import java.util.*;

class Problem {
    private int hp;
    private int[][] players;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        players = new int[3][2];
        for (int i = 0; i < 3; ++i) {
            players[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        hp = Integer.parseInt(br.readLine());
    }

    private void output() {
        System.out.println(getTime());
    }

    private int getTime() {
        int time = 0;
        while (hp > 0) {
            for (int[] player : players) {
                if (time % player[0] == 0) {
                    hp -= player[1];
                }
            }
            if (hp <= 0) {
                return time;
            } else {
                ++time;
            }
        }
        return time;
    }
}

public class A {
    public static void main(String[] args) {
        new Problem();        
    }
}
