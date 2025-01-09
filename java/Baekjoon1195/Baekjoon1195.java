import java.io.*;
import java.util.*;

class Problem {
    private int[] upGear;
    private int[] downGear;

    public Problem() {
        try {
            input();
            solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        upGear = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        downGear = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void solve() {
        int min = upGear.length + downGear.length;

        for (int j = 0; j < 2; ++j) {
            for (int i = 0; i < downGear.length; ++i) {
                min = Math.min(min, getMatch(i));
            }
            swap();
        }
        
        System.out.println(min);
    }

    private int getMatch(int start) {
        int upPointer = 0;
        int downPointer = 0;
        List<Integer> temp = new ArrayList<>();

        while (upPointer < upGear.length && downPointer < downGear.length) {
            int value = start <= downPointer ? upGear[upPointer++] : 0;
            value += downGear[downPointer++];
            if (value == 4) {
                return Integer.MAX_VALUE;
            }
            temp.add(value);
        }

        while (upPointer < upGear.length) {
            temp.add(upGear[upPointer++]);
        }
        while (downPointer < downGear.length) {
            temp.add(downGear[downPointer++]);
        }
        return temp.size();
    }

    private void swap() {
        int[] temp = upGear;
        upGear = downGear;
        downGear = temp;
    }
}

public class Baekjoon1195 {
    public static void main(String[] args) {
        new Problem();
    }
}
