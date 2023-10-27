import java.io.*;
import java.util.*;

class Shark {
    boolean live = true;
    int x, y, speed, dir, size;
    static int[][] dircs = {{ -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }};

    private void turn() {
        switch(dir) {
            case 0: dir = 1; break;
            case 1: dir = 0; break;
            case 2: dir = 3; break;
            case 3: dir = 2; break;
        }
    }

    public void move(Map map) {
        int x_speed = speed%(2 * (map.r-1));
        int y_speed = speed%(2 * (map.c-1));

        for(int i = 0; i < x_speed; ++i) {
            x += dircs[dir][0];
            if(x == -1) {
                x = 1;
                turn();
            }
            if(x == map.r) {
                x = map.r-2;
                turn();
            }
        }
        for(int i = 0; i < y_speed; ++i) {
            y += dircs[dir][1];
            if(y == -1) {
                y = 1;
                turn();
            }
            if(y == map.c) {
                y = map.c-2;
                turn();
            }
        }
    }
}

class Map {
    int r, c;
    int[][] locs;

    private int fishing(int c_c, Shark[] sharks) {
        int size = 0;
        for(int x = 0; x < r; ++x) {
            if(locs[x][c_c] != -1) {
                sharks[locs[x][c_c]].live = false;
                size = sharks[locs[x][c_c]].size;
                locs[x][c_c] = -1;
                return size;
            }
        }
        return size;
    }

    private void makeNextMap(Shark[] sharks) {
        int[][] temp = new int[r][c];

        for(int i = 0; i < r; ++i) {
            Arrays.fill(temp[i], -1);
        }

        for(int x = 0; x < r; ++x) {
            for(int y = 0; y < c; ++y) {
                if(locs[x][y] != -1) {
                    sharks[locs[x][y]].move(this);
                    // 다른 상어가 있을 경우
                    if(temp[sharks[locs[x][y]].x][sharks[locs[x][y]].y] != -1) {
                        if(sharks[temp[sharks[locs[x][y]].x][sharks[locs[x][y]].y]].size < sharks[locs[x][y]].size) {
                            sharks[temp[sharks[locs[x][y]].x][sharks[locs[x][y]].y]].live = false;
                            temp[sharks[locs[x][y]].x][sharks[locs[x][y]].y] = locs[x][y];
                        }
                        else {
                            sharks[locs[x][y]].live = false;
                        }
                    } // 다른 상어 없음
                    else {
                        temp[sharks[locs[x][y]].x][sharks[locs[x][y]].y] = locs[x][y];
                    }
                }
            }
        }
        locs = temp;
    }

    public int step(int c_c, Shark[] sharks) {
        int size = fishing(c_c, sharks);
        makeNextMap(sharks);
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<map>\n");
        for(int i = 0; i < r; ++i){
            for(int j = 0; j < c; ++j)
                sb.append(locs[i][j] == -1 ? "-" : locs[i][j]).append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class Baekjoon17143 {
    Map map;
    Shark[] sharks;
    
    public int solve() {
        int size = 0;

        for(int i = 0; i < map.c; ++i){ 
            //System.out.println(map);
            size += map.step(i, sharks); 
        }

        return size;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon17143 problem = new Baekjoon17143();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        problem.map = new Map();
        problem.map.r = Integer.parseInt(st.nextToken());
        problem.map.c = Integer.parseInt(st.nextToken());
        problem.map.locs = new int[problem.map.r][problem.map.c];
        problem.sharks = new Shark[Integer.parseInt(st.nextToken())];

        for(int i = 0; i < problem.map.r; ++i) {
            Arrays.fill(problem.map.locs[i], -1);
        }

        for(int i = 0; i < problem.sharks.length; ++i) {
            st = new StringTokenizer(br.readLine());
            problem.sharks[i] = new Shark();
            problem.sharks[i].x = Integer.parseInt(st.nextToken())-1;
            problem.sharks[i].y = Integer.parseInt(st.nextToken())-1;
            problem.sharks[i].speed = Integer.parseInt(st.nextToken());
            problem.sharks[i].dir = Integer.parseInt(st.nextToken())-1;
            problem.sharks[i].size = Integer.parseInt(st.nextToken());
            problem.map.locs[problem.sharks[i].x][problem.sharks[i].y] = i;
        }

        System.out.println(problem.solve());
    }
}