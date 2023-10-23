# (1509) 팰린드롬 분할
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1509)
## 문제
세준이는 어떤 문자열을 팰린드롬으로 분할하려고 한다. 예를 들어, ABACABA를 팰린드롬으로 분할하면, {A, B, A, C, A, B, A}, {A, BACAB, A}, {ABA, C, ABA}, {ABACABA}등이 있다.

분할의 개수의 최솟값을 출력하는 프로그램을 작성하시오.

## 입력
첫째 줄에 문자열이 주어진다. 이 문자열은 알파벳 대문자로만 이루어져 있고, 최대 길이는 2,500이다.

## 출력
첫째 줄에 팰린드롬 분할의 개수의 최솟값을 출력한다.

## 풀이
해당 문제는 BFS를 이용하면 해결 할 수 있는 문제입니다.  

1. 주어진 문자열의 각 문자로 만들 수 있는 펠린드롬을 모두 만든다.  
    - 이때 팰린드롬은 2가지로 나누어 생각해 볼 수 있다.
    - 팰린드롬 문자열의 길이가 홀수인 경우 -> 홀수인 경우 해당 문자를 기준으로 좌우를 판단하여 만들어 간다.
    - 팰린드롬 문자열의 길이가 짝수인 경우 -> 왼쪽의 값이 같은 경우만 해당 두 만자를 기준으로 좌우를 판단하여 만들어 간다.

2. 위의 팰린드롬이 되는 경우를 인덱스를 통하여 값을 저장한다.
    - 예를 들어 ABAB인 경우 ABA : (0,2), B : (3)가된다.

3. 인덱스로 만들어진 값들은 그래프로 표현한다.

4. 그래프를 0에서 시작하여 끝까지 BFS를 시행하고 가장 짧은 깊이를 출력한다.

```java
import java.io.*;
import java.util.*;

class BFSInfo {
    int depth, value;
    public BFSInfo(int depth, int value) {
        this.depth = depth;
        this.value = value;
    }
    public int getDepth(){return depth;}
    public int getValue(){return value;}
}

public class Baekjoon1509 {
    boolean[][] palindromeState;

    private void makePalindrome(String s, int lo, int hi) {
        if(palindromeState[lo][hi]) return;

        palindromeState[lo][hi] = true;
        if( lo > 0 &&
            hi+1 < s.length() && 
            s.charAt(lo-1) == s.charAt(hi+1) )
            makePalindrome(s, lo-1, hi+1);
    }

    private int BFS() {
        boolean[] visited = new boolean[palindromeState.length+1];
        Queue<BFSInfo> que = new ArrayDeque<>();
        que.add(new BFSInfo(0, 0));

        while(!que.isEmpty()) {
            BFSInfo curr = que.poll();

            if(curr.value == palindromeState.length)
                return curr.depth;

            if(!visited[curr.value]){
                visited[curr.value] = true;

                for(int i = curr.value; i < palindromeState.length; ++i)
                    if(palindromeState[curr.value][i] && !visited[i+1])
                        que.add(new BFSInfo(curr.depth+1, i+1));
            }
        }
        
        return 0;
    }

    public int solve(String s) {
        palindromeState = new boolean[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); ++i){
            makePalindrome(s, i, i);
            if(i > 0 && s.charAt(i) == s.charAt(i-1))
                makePalindrome(s, i-1, i);
        }

        return BFS();
    }

    public static void main(String[] args) throws IOException {
        Baekjoon1509 problem = new Baekjoon1509();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(problem.solve(s));
    }
}
```