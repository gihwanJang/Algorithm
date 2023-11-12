# (1516) 게임 개발
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1516)
## 문제
숌 회사에서 이번에 새로운 전략 시뮬레이션 게임 세준 크래프트를 개발하기로 하였다.  
핵심적인 부분은 개발이 끝난 상태고, 종족별 균형과 전체 게임 시간 등을 조절하는 부분만 남아 있었다.

게임 플레이에 들어가는 시간은 상황에 따라 다를 수 있기 때문에, 모든 건물을 짓는데 걸리는 최소의 시간을 이용하여 근사하기로 하였다.  
물론, 어떤 건물을 짓기 위해서 다른 건물을 먼저 지어야 할 수도 있기 때문에 문제가 단순하지만은 않을 수도 있다.  
예를 들면 스타크래프트에서 벙커를 짓기 위해서는 배럭을 먼저 지어야 하기 때문에, 배럭을 먼저 지은 뒤 벙커를 지어야 한다.  
여러 개의 건물을 동시에 지을 수 있다.

편의상 자원은 무한히 많이 가지고 있고, 건물을 짓는 명령을 내리기까지는 시간이 걸리지 않는다고 가정하자.

## 입력
첫째 줄에 건물의 종류 수 N(1 ≤ N ≤ 500)이 주어진다.  
다음 N개의 줄에는 각 건물을 짓는데 걸리는 시간과 그 건물을 짓기 위해 먼저 지어져야 하는 건물들의 번호가 주어진다.  
건물의 번호는 1부터 N까지로 하고, 각 줄은 -1로 끝난다고 하자.  
각 건물을 짓는데 걸리는 시간은 100,000보다 작거나 같은 자연수이다.  
모든 건물을 짓는 것이 가능한 입력만 주어진다.

## 출력
N개의 각 건물이 완성되기까지 걸리는 최소 시간을 출력한다.

## 풀이
해당 문제는 위상정렬을 이용하면 해결 할 수 있는 문제입니다.  

건물들의 정보를 가지는 클래스 또는 구조체를 정의 합니다.  
해당 클래스는 (time : 건물을 짓는데 걸리는 시간, in : 진입차수, prev : 이전 건물을 짓는데 걸리는 시간, out : 자기자신을 진입차수로 가지는 노드 리스트)를 멥버로 가집니다.  
위의 정보에 맞게 입력을 받아 해당 클래스의 리스트를 만들어 줍니다.  

만들어진 리스트에서 진입차수가 0인 것들만을 뽑아 que에 넣어줍니다.  
que가 빌때 까지 아래의 과정을 수행합니다.  

    - que에서 값을 가져와 현제의 건설 time과 prev를 합산해 줍니다.  
    - 자신을 진입차수로 가지는 건물들의 prev를 자신의 time과 비교하여 더 큰 것으로 업데이트해 줍니다.  
    - 이후 해당 건물의 진입차수를 낮춰줍니다.  
    - 이때 낮춘 진입 차수가 0이라면 해당 노드를 que에 넣어 줍니다.

위의 과정이 끝났다면 각 노드의 time을 출력해 줍니다.


```java
import java.io.*;
import java.util.*;

class Node {
    int time, in, prev;
    List<Integer> out;

    public Node() {
        this.in = 0;
        this.prev = 0;
        out = new ArrayList<>();
    }

    public void add(int node) {
        out.add(node);
    }
}

class Problem {
    List<Node> buildings;

    public String solve() {
        StringBuilder sb = new StringBuilder();
        build();
        for(Node n : buildings) sb.append(n.time).append("\n");
        return sb.toString();
    }

    private void build() {
        Node curr;
        Queue<Node> que = new ArrayDeque<>();
        for(Node b : buildings)
            if(b.in == 0) que.add(b);

        while(!que.isEmpty()) {
            curr = que.poll();
            curr.time += curr.prev;

            for(int idx : curr.out) {
                buildings.get(idx).prev = Math.max(buildings.get(idx).prev, curr.time);
                if(--buildings.get(idx).in == 0) que.add(buildings.get(idx));
            }
        }
    }
}

public class Baekjoon1516 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        Problem problem = new Problem();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        problem.buildings = new ArrayList<>(n);
        for(int i = 0; i < n; ++i) problem.buildings.add(new Node());
        
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            problem.buildings.get(i).time = Integer.parseInt(st.nextToken());

            while (true) {
                int idx = Integer.parseInt(st.nextToken());
                if(idx == -1) break;
                ++problem.buildings.get(i).in;
                problem.buildings.get(idx-1).add(i);
            }
        }

        System.out.print(problem.solve());
    }
}
```