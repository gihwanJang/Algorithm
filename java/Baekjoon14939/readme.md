# (14939) 불 끄기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/14939)
## 문제
전구 100개가 10×10 정사각형 모양으로 늘어서 있다.  
전구에 달린 스위치를 누르면 그 전구와 위, 아래, 왼쪽, 오른쪽에 있는 전구의 상태도 바뀐다.  
전구 100개의 상태가 주어지면 모든 전구를 끄기 위해 최소한으로 눌러야 하는 스위치의 개수를 출력하라

## 입력
10줄에 10글자씩 입력이 주어진다.  
#은 꺼진 전구고 O(대문자 알파벳 o)는 켜진 전구다.  
#과 O외에는 입력으로 주어지지 않는다.

## 출력
모든 전구를 끄기 위해 최소한으로 눌러야 하는 스위치의 개수를 출력하라.  
불가능하면 -1를 출력하라.

## 풀이
해당 문제는 그리디, 비트마스킹을 이용하면 해결 할 수 있는 문제입니다.  

우선 기본적으로 주어진 상태에 대하여 순서는 상관이 없습니다.  
그러므로 (0,0)을 바꾸고 (1,0)을 바꾸는는 것과 (1,0)을 바꾸고 (0,0)을 바꾸는 것은 동일 합니다.  

또한 나의 위가 켜져있으면 무조건 스위치를 눌러야합니다.  
그 이유는 인덱스는 아래로만 이동하기 때문입니다.  
(위는 제가 그렇게 설정한 것이며 우측으로만 이동하면 좌측이 켜져있으면 무조건 눌러야하는 그런 방식입니다.)  
이렇게 하여 아래쪽에 켜져있는 것이 있다면 모두 끌 수 없습니다.  

이제 1가지만 더 고려하면 됩니다.
가장 위쪽의 행입니다.  
가장 위쪽의 행은 더이상 위가 없으므로 모든 경우의 수를 살펴봐야 합니다.  
해당 위쪽 행은 10개의 열이 있으므로 2^10의 경우의 수를 가지게 됩니다.  

해당 경우의 수에 대하여 위의 과정을 반복하여 가장 작은 경우의 수를 찾아 출력하여 주면됩니다.

```java
import java.io.*;
import java.util.*;

public class Baekjoon14939 {
    Boolean[][] map;
    Boolean[][] temp;
    int[] dx = { 0, 1, 0, -1, 0 };
    int[] dy = { 0, 0, 1, 0, -1 };

    private void makeTemp() {
        temp = Arrays.stream(map)
                    .map(Boolean[]::clone)
                    .toArray(Boolean[][]::new);
    }

    private boolean validationLoc(int r, int c) {
        return (0 <= r && r < 10 &&
                0 <= c && c < 10);
    }

    private int changeState(int r, int c) {
        for (int i = 0; i < 5; ++i)
            if (validationLoc(r + dx[i], c + dy[i]))
                temp[r + dx[i]][c + dy[i]] = !temp[r + dx[i]][c + dy[i]];

        return 1;
    }

    private boolean isDone() {
        for (int c = 0; c < 10; ++c)
            if (temp[9][c])
                return false;

        return true;
    }

    public int solve() {
        int ans = Integer.MAX_VALUE;

        for (int bt = 0; bt < (1 << 10); ++bt) {
            int cnt = 0;
            makeTemp();

            for (int c = 0; c < 10; ++c)
                if ((bt & (1 << c)) != 0)
                    cnt += changeState(0, c);

            for (int r = 1; r < 10; ++r)
                for (int c = 0; c < 10; ++c)
                    if (temp[r - 1][c])
                        cnt += changeState(r, c);

            if (isDone())
                ans = Math.min(ans, cnt);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon14939 problem = new Baekjoon14939();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        problem.map = new Boolean[10][10];
        for (int r = 0; r < 10; ++r)
            problem.map[r] = br.readLine().chars().mapToObj(c -> c == 'O').toArray(Boolean[]::new);

        System.out.println(problem.solve());
    }
}
```