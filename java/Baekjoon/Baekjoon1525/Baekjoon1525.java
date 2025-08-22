import java.io.*;
import java.util.*;

class QueInfo {
    int r, c;
    int depth;
    int map;

    public QueInfo(int depth, int map, int r, int c) {
        this.depth = depth;
        this.map = map;
        this.r = r;
        this.c = c;
    }
}

class Problem {
    private final int[] DX = {-1,1,0,0};
    private final int[] DY = {0,0,-1,1};

    private int fR, fC;
    private int map;
    private Set<Integer> visited;

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

        map = 0;
        for (int i = 0; i < 3; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < 3; ++j) {
                int num = Integer.parseInt(st.nextToken());

                map *= 10;
                map += num;
                if (num == 0) {
                    fR = i;
                    fC = j;
                }
            }
        }
        visited = new HashSet<>();
    }

    private void output() {
        System.out.println(BFS());
    }

    private int BFS() {
        QueInfo curr;
        Queue<QueInfo> que = new ArrayDeque<>();

        que.add(new QueInfo(0, map, fR, fC));
        visited.add(map);
        while (!que.isEmpty()) {
            curr = que.poll();
            if (curr.map == 123456780) {
                return curr.depth;
            }
            for (int i = 0; i < 4; ++i) {
                int nextR = curr.r + DX[i];
                int nextC = curr.c + DY[i];

                if (isValidate(nextR, nextC)) {
                    int nextMap = getNextMap(curr.map, nextR, nextC, curr.r, curr.c);

                    if (!visited.contains(nextMap)) {
                        que.add(new QueInfo(curr.depth + 1, nextMap, nextR, nextC));
                        visited.add(nextMap);
                    }
                }
            }
        }
        return -1;
    }

    private int getNextMap(int currMap, int nextR, int nextC, int r, int c) {
        int tmp;
        int nextMap = 0;
        int[] newMap = new int[9];

        for (int i = 8; currMap > 0; --i) {
            newMap[i] = currMap % 10;
            currMap /= 10;
        }
        tmp = newMap[nextR * 3 + nextC];
        newMap[nextR * 3 + nextC] = 0;
        newMap[r * 3 + c] = tmp;
        for (int i = 0; i < 9; ++i) {
            nextMap *= 10;
            nextMap += newMap[i];
        }
        return nextMap;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < 3
                &&
                0 <= c && c < 3);
    }
}

public class Baekjoon1525 {
    public static void main(String[] args) {
        new Problem();
    }
}
