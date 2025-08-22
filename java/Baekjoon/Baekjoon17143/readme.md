# (17143) 낚시왕
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/17143)
## 문제
낚시왕이 상어 낚시를 하는 곳은 크기가 R×C인 격자판으로 나타낼 수 있다. 격자판의 각 칸은 (r, c)로 나타낼 수 있다. r은 행, c는 열이고, (R, C)는 아래 그림에서 가장 오른쪽 아래에 있는 칸이다. 칸에는 상어가 최대 한 마리 들어있을 수 있다. 상어는 크기와 속도를 가지고 있다.

![IMG1](https://upload.acmicpc.net/85c2ccad-e4b8-4397-9bd6-0ec73b0f44f8/-/preview/)

낚시왕은 처음에 1번 열의 한 칸 왼쪽에 있다. 다음은 1초 동안 일어나는 일이며, 아래 적힌 순서대로 일어난다. 낚시왕은 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동을 멈춘다.

낚시왕이 오른쪽으로 한 칸 이동한다.
낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
상어가 이동한다.
상어는 입력으로 주어진 속도로 이동하고, 속도의 단위는 칸/초이다. 상어가 이동하려고 하는 칸이 격자판의 경계를 넘는 경우에는 방향을 반대로 바꿔서 속력을 유지한채로 이동한다.

왼쪽 그림의 상태에서 1초가 지나면 오른쪽 상태가 된다. 상어가 보고 있는 방향이 속도의 방향, 왼쪽 아래에 적힌 정수는 속력이다. 왼쪽 위에 상어를 구분하기 위해 문자를 적었다.

![img2](https://upload.acmicpc.net/d03be3c0-057d-47f7-9808-202ae36a3da3/-/preview/)

상어가 이동을 마친 후에 한 칸에 상어가 두 마리 이상 있을 수 있다. 이때는 크기가 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.

낚시왕이 상어 낚시를 하는 격자판의 상태가 주어졌을 때, 낚시왕이 잡은 상어 크기의 합을 구해보자.

## 입력
첫째 줄에 격자판의 크기 R, C와 상어의 수 M이 주어진다. (2 ≤ R, C ≤ 100, 0 ≤ M ≤ R×C)

둘째 줄부터 M개의 줄에 상어의 정보가 주어진다. 상어의 정보는 다섯 정수 r, c, s, d, z (1 ≤ r ≤ R, 1 ≤ c ≤ C, 0 ≤ s ≤ 1000, 1 ≤ d ≤ 4, 1 ≤ z ≤ 10000) 로 이루어져 있다. (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다. d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.

두 상어가 같은 크기를 갖는 경우는 없고, 하나의 칸에 둘 이상의 상어가 있는 경우는 없다.

## 출력
낚시왕이 잡은 상어 크기의 합을 출력한다.

## 풀이
해당 문제는 구현에 해당하는 문제이므로 별도 풀이는 없습니다.  
문제에 주어진 순서대로 구현해 주면됩니다.

```java
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
```