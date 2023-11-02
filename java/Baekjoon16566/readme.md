# (16566) 카드 게임 
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/16566)
## 문제
철수와 민수는 카드 게임을 즐겨한다. 이 카드 게임의 규칙은 다음과 같다.

1. N개의 빨간색 카드가 있다. 각각의 카드는 순서대로 1부터 N까지 번호가 매겨져 있다. 이 중에서 M개의 카드를 고른다.
2. N개의 파란색 카드가 있다. 각각의 카드는 순서대로 1부터 N까지 번호가 매겨져 있다. 이 중에서 빨간색에서 고른 번호와 같은 파란색 카드 M개를 고른다.
3. v 철수는 빨간색 카드를 가지고 민수는 파란색 카드를 가진다.
4. 철수와 민수는 고른 카드 중에 1장을 뒤집어진 상태로 낸다. 그리고 카드를 다시 뒤집어서 번호가 큰 사람이 이긴다. 이 동작을 K번 해서 더 많이 이긴 사람이 최종적으로 승리한다. 한 번 낸 카드는 반드시 버려야 한다.

철수는 뛰어난 마술사이기 때문에 본인이 낼 카드를 마음대로 조작할 수 있다. 즉, 카드를 버리고 민수 몰래 다시 들고 온다거나 민수한테 없는 카드를 내기도 한다.

민수는 뛰어난 심리학자이기 때문에 철수가 낼 카드를 알아낼 수 있다. 그래서 민수는 철수가 낼 카드보다 큰 카드가 있다면 그 카드들 중 가장 작은 카드를 내기로 했다.

K번 동안 철수가 낼 카드가 입력으로 주어진다. 그렇다면 민수가 어떤 카드를 낼지 출력하라. 단, 민수가 카드를 내지 못하는 경우는 없다고 가정한다.

## 입력
첫째 줄에 세 개의 자연수 N, M, K가 주어진다. (1 ≤ M ≤ N ≤ 4,000,000, 1 ≤ K ≤ min(M, 10,000))

다음 줄에 카드의 번호를 나타내는 M개의 자연수가 주어진다. 각각의 수들은 1 이상이고 N 이하이며 서로 다르다.

다음 줄에 K개의 자연수가 주어진다. i번째 수는 철수가 i번째로 내는 카드의 번호이다. 철수가 내는 카드 역시 1 이상 N 이하이다.

## 출력
K줄에 걸쳐서 수를 출력한다. i번째 줄에는 민수가 i번째로 낼 카드의 번호가 출력되어야 한다.

## 풀이
해당 문제는 정렬과 이진 탐색을 이용하면 해결 할 수 있는 문제입니다.  

우선 나가 가진 카드의 번호를 오름 차순으로 정렬합니다.  
이후 상대방이 낼 카드보다 값이 큰 인덱스 이진 탐색을 이용하여 찾습니다.  
이때 해당 카드는 사용 되었을 수 있음으로 used배열을 통해 사용되지 않은 카드를 우측에서 찾습니다.

해당 카드를 출력하고 해당 카드를 used에 사용 된 카드로 표기해 줍니다.  

위의 과정을 k번 반복합니다.

```java
import java.io.*;
import java.util.*;

public class Baekjoon16566 {
    int n, m, k;
    boolean[] used;
    List<Integer> myCards;
    List<Integer> yourCards;

    private int getCanUsingIdx(int idx) {
        while(used[idx]==true){++idx;}
        return idx;
    }

    private int binarySearch(Integer target) {
        int lo = 0, hi = myCards.size(), mid;

        while(lo < hi) {
            mid = (lo + hi) / 2;
            if(myCards.get(mid) <= target) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        myCards.sort(null);
        for(int i = 0, idx; i < k; ++i) {
            idx = getCanUsingIdx(binarySearch(yourCards.get(i)));
            sb.append(myCards.get(idx)).append("\n");
            used[idx] = true;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon16566 problem = new Baekjoon16566();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        problem.n = Integer.parseInt(st.nextToken());
        problem.m = Integer.parseInt(st.nextToken());
        problem.k = Integer.parseInt(st.nextToken());
        problem.used = new boolean[problem.m];
        problem.myCards = new ArrayList<>(problem.m);
        problem.yourCards = new ArrayList<>(problem.k);

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < problem.m; ++i)
            problem.myCards.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < problem.k; ++i)
            problem.yourCards.add(Integer.parseInt(st.nextToken()));

        System.out.print(problem.solve());
    }
}
```