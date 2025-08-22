# (2568) 
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2568)
## 문제
두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.

예를 들어, <그림 1>과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄, A의 3번 위치와 B의 9번 위치를 잇는 전깃줄, A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다. 

![img1](https://upload.acmicpc.net/854620e2-d10b-4bb6-84f0-0dd4b89bfb13/-/preview/)

<그림 1>

전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 최소 개수의 전깃줄을 구하는 프로그램을 작성하시오.

## 입력
첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다. 전깃줄의 개수는 100,000 이하의 자연수이다. 둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다.  
위치의 번호는 500,000 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다. 

## 출력
첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.  
둘째 줄부터 한 줄에 하나씩 없애야 하는 전깃줄의 A전봇대에 연결되는 위치의 번호를 오름차순으로 출력한다. 만약 답이 두 가지 이상이라면 그 중 하나를 출력한다.

## 풀이
해당 문제는 이진탐색을 이용항 LIS를 이용하면 해결 할 수 있는 문제입니다.  

해당 문제는 A를 기준으로 또는 B를 기준으로 하여 해결 할 수 있습니다.  

하지만 출력조건에서 A를 기준으로 출력하라는 조건이 있기 때문에 A를 기준으로 풀이를 하겠습니다.  
우선 A를 기준으로 정렬해 줍니다.  
이후 교차하지 않으려면 B에 연결된 선이 정렬 되어 있어야 하기 때문에 B에서 가장 긴 증가하는 부분 수열을 찾습니다.  
이때 증가하는 부분수열 즉 LIS를 찾는 방법에는 이중 for문을 이용하는 방법과 이진탐색을 활용하는 방법이 있습니다.  

이중 for문을 쓰게 되면 O(n^2)의 시간 복잡도를 가지게 되어 시간초과가 나게됩니다.
그러므로 이진탐색을 활용하여 LIS를 찾습니다.  
이때 LIS를 찾기 위해 해당 인덱스와 별도의 이전 인덱스를 저장하는 배열을 유지합니다.  
LIS를 백트래킹하여 사용되는 값들을 마스킹합니다.  

마스킹 되지 않은 값들을 출력해 줍니다.

```java
import java.io.*;
import java.util.*;

class Line implements Comparable<Line> {
    int a, b;
    boolean isCrossed = true;

    @Override
    public int compareTo(Line o) {
        return a - o.a;
    }
}

public class Baekjoon2568 {
    int n;
    List<Line> lines;

    private int binarySearch(List<int[]> LIS, int target) {
        int lo = 0, hi = LIS.size(), mid;

        while(lo < hi) {
            mid = (lo + hi) / 2;
            if(LIS.get(mid)[0] < target) lo = mid+1;
            else hi = mid;
        }

        return lo;
    }

    private void backTraking(int[] prev, int i) {
        lines.get(i).isCrossed = false;
        if(i != prev[i]) {backTraking(prev, prev[i]);}
    }

    private void removeLine() {
        int[] prev = new int[n];
        List<int[]> LIS = new ArrayList<>(lines.size());

        LIS.add(new int[]{lines.get(0).b, 0});
        for(int i = 1, idx; i < n; ++i) {
            if(LIS.get(LIS.size()-1)[0] < lines.get(i).b) {
                prev[i] = LIS.get(LIS.size()-1)[1];
                LIS.add(new int[]{lines.get(i).b, i});
            }
            else {
                idx = binarySearch(LIS, lines.get(i).b);
                prev[i] = idx == 0 ? i : LIS.get(idx-1)[1];
                LIS.get(idx)[0] = lines.get(i).b;
                LIS.get(idx)[1] = i;
            }
        }

        backTraking(prev, LIS.get(LIS.size()-1)[1]);
    }

    public String solve() {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        Collections.sort(lines);
        removeLine();

        for(Line l : lines) {
            if(l.isCrossed) {
                sb.append(l.a).append("\n");
                ++cnt;
            }
        }

        return sb.insert(0, cnt + "\n").toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon2568 problem = new Baekjoon2568();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        problem.n = Integer.parseInt(st.nextToken());
        problem.lines = new ArrayList<>(problem.n);
        for (int i = 0; i < problem.n; ++i) {
            st = new StringTokenizer(br.readLine());
            problem.lines.add(new Line());
            problem.lines.get(i).a = Integer.parseInt(st.nextToken());
            problem.lines.get(i).b = Integer.parseInt(st.nextToken());
        }

        System.out.print(problem.solve());
    }
}
```