# (12850) 본대 산책2
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/12850)
## 문제
숭실 대학교 정보 과학관은 유배를 당해서  캠퍼스의 길 건너편에 있다. 그래서 컴퓨터 학부 학생들은 캠퍼스를 ‘본대’ 라고 부르고 정보 과학관을 ‘정보대’ 라고 부른다. 준영이 또한 컴퓨터 학부 소속 학생이라서 정보 과학관에 박혀있으며 항상 꽃 이 활짝 핀 본 대를 선망한다. 어느 날 준영이는 본 대를 산책하기로 결심하였다. 숭실 대학교 캠퍼스 지도는 아래와 같다.

![img1](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12850/1.png)

(편의 상 문제에서는 위 건물만 등장한다고 가정하자)

한 건물에서 바로 인접한 다른 건물로 이동 하는 데 1분이 걸린다. 준영이는 산책 도중에 한번도 길이나 건물에 멈춰서 머무르지 않는다. 준영이는 할 일이 많아서 딱 D분만 산책을 할 것이다. (산책을 시작 한 지 D분 일 때, 정보 과학관에 도착해야 한다.) 이때 가능한 경로의 경우의 수를 구해주자.

## 입력
D 가 주어진다 (1 ≤ D ≤ 1,000,000,000) 

## 출력
가능한 경로의 수를 1,000,000,007로 나눈 나머지를 출력한다.

## 풀이
해당 문제는 (분할정복, 행렬 거듭제곱)을 이용하면 해결 할 수 있는 문제입니다.  

우선 각 노드에 대하여 그래프를 만들었을 때 인덱스를 r, c라고 가정하겠습니다.  
이때 이 그래프를 n제곱하게 되면 r노드에서 c노드로 n번만에 도달할 수 있는경우의 수가 graph[r][c]에 값이 저장됩니다.  

그러므로 주어진 그래프를 d번 제곱을 하게 되었을 때, graph[0][0]을 확인하면 해당 값이 됩니다.  
하지만 d의 범위가 (1 ≤ D ≤ 1,000,000,000)이므로 (8x8)행렬 곱셍을 1,000,000,000번을 하게되면 시간초과가 나게 됩니다.  

이를 해결 하기위해 분할정복을 사용하여 제곱한것을 가지고 제곱을하게됩니다.  
그럼 d는 1씩 차감되는 것이아닌 d/2씩 차감 되므로 시간 복잡도는 8^3log(n)이 됩니다.

```java
import java.io.*;

public class Baekjoon12850 {
    long div = 1_000_000_007;
    long[][] map = {
        { 0, 1, 1, 0, 0, 0, 0, 0 }, /*정보*/
        { 1, 0, 1, 1, 0, 0, 0, 0 }, /*전산*/
        { 1, 1, 0, 1, 1, 0, 0, 0 }, /*미래*/
        { 0, 1, 1, 0, 1, 1, 0, 0 }, /*신양*/
        { 0, 0, 1, 1, 0, 1, 1, 0 }, /*한경*/
        { 0, 0, 0, 1, 1, 0, 0, 1 }, /*진리*/
        { 0, 0, 0, 0, 1, 0, 0, 1 }, /*형남*/
        { 0, 0, 0, 0, 0, 1, 1, 0 }, /*학생*/
    };
    
    public long[][] multiply(long[][] a, long[][] b) {
        long[][] ret = new long[8][8];

        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                for(int k = 0; k < 8; ++k) {
                    ret[i][j] += a[i][k] * b[k][j];
                    ret[i][j] %= div;
                }
                ret[i][j] %= div;
            }
        }

        return ret;
    }
    public long solve(long d) {
        long[][] res = new long[8][8];
        for(int i = 0; i < 8; ++i) {res[i][i] = 1;}

        while(d != 0) {
            if((d & 1) == 1){
                res = multiply(res, map);
                d -= 1;
            }
            map = multiply(map, map);
            d /= 2;
        }
        
        return res[0][0];
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon12850 problem = new Baekjoon12850();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long d = Long.parseLong(br.readLine());
        System.out.println(problem.solve(d));
    }
}
```