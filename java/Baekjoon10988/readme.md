# (10988) 팰린드롬인지 확인하기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/10988)
## 문제
알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.

팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. 

level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.

## 입력
첫째 줄에 단어가 주어진다.  
단어의 길이는 1보다 크거나 같고, 100보다 작거나 같으며, 알파벳 소문자로만 이루어져 있다.

## 출력
첫째 줄에 팰린드롬이면 1, 아니면 0을 출력한다.

## 풀이
해당 문제는 2포인터를 이용하면 해결 할 수 있는 문제입니다.  

문자열을 입력 받고 해당 문자열의 시작과 끝에 포인터를 둡니다.  
이후 포인터를 좁혀가며 값이 같은지 비교합니다.  
만약 다르면 바로 0을 출력하고 해당 포인터가 엇갈릴때 까지 모두 같으면 1을 출력합니다.

```java
import java.io.*;

public class Baekjoon10988 {
    public static int solve(String s) {
        for(int lo = 0, hi = s.length()-1; lo <= hi; ++lo, --hi)
            if(s.charAt(lo) != s.charAt(hi)) return 0;
        return 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(br.readLine()));
    }
}
```