import java.io.*;
import java.util.*;

class Problem {
    private long ans;
    private int length, width, height;
    private boolean flag;
    private int[] cubes;

    public Problem() {
        try {
            intput();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void intput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = 0;
        flag = true;
        cubes = new int[20];
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        for (int i = Integer.parseInt(br.readLine()); i > 0; --i) {
            st = new StringTokenizer(br.readLine());
            cubes[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
    }

    private void output() {
        solve(length, width, height);
        System.out.println(flag ? ans : -1);
    }

    private void solve(int l, int w, int h) {
        if (l == 0 || w == 0 || h == 0) {
            return;
        }

        int priorityNum = getPriorityNum(threeMin(l, w, h));
        if (cubes[priorityNum] != 0) {
            int len = getLength(priorityNum);

            solve(l - len, w, h);
            solve(len, w - len, h);
            solve(len, len, h - len);
        } else {
            flag = false;
        }
    }

    private int getLength(int priorityNum) {
        ans += 1;
        cubes[priorityNum] -= 1;
        return 1 << priorityNum;
    }

    private int getPriorityNum(int v) {
        for (int i = 19; i >= 0; --i) {
            if (1 << i <= v && cubes[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    private int threeMin(int l, int w, int h) {
        return Math.min(Math.min(l, w), h);
    }
}

public class Baekjoon1493 {
    public static void main(String[] args) {
        new Problem();
    }
}
