# (2887) 행성 터널
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2887)
## 문제
때는 2040년, 이민혁은 우주에 자신만의 왕국을 만들었다. 왕국은 N개의 행성으로 이루어져 있다. 민혁이는 이 행성을 효율적으로 지배하기 위해서 행성을 연결하는 터널을 만들려고 한다.

행성은 3차원 좌표위의 한 점으로 생각하면 된다. 두 행성 A(xA, yA, zA)와 B(xB, yB, zB)를 터널로 연결할 때 드는 비용은 min(|xA-xB|, |yA-yB|, |zA-zB|)이다.

민혁이는 터널을 총 N-1개 건설해서 모든 행성이 서로 연결되게 하려고 한다. 이때, 모든 행성을 터널로 연결하는데 필요한 최소 비용을 구하는 프로그램을 작성하시오.

## 입력
첫째 줄에 행성의 개수 N이 주어진다. (1 ≤ N ≤ 100,000) 다음 N개 줄에는 각 행성의 x, y, z좌표가 주어진다.  
좌표는 -109보다 크거나 같고, 109보다 작거나 같은 정수이다.  
한 위치에 행성이 두 개 이상 있는 경우는 없다. 

## 출력
첫째 줄에 모든 행성을 터널로 연결하는데 필요한 최소 비용을 출력한다.

## 풀이
해당 문제는 크루스칼을 이용하면 해결 할 수 있는 문제입니다.  

우선 point들을 {인덱스, x, y, z}형태로 입력 받습니다.  

이후 해당 point들로 간선을 만듭니다.  
이때 point의 최대 갯수는 100,000개 이므로 이중 for문으로 모든 간선을 만들게 되면 10,000,000,000개의 간선이 생성 되므로 메모리 초과가 발생하게 됩니다.  
그렇기 때문에 각 x,y,z를 기준으로 정렬후 인접한 노드끼리 간선을 만들면 300,000개의 간선을 만들 수 있습니다.

이후 만들어진 간선을 이용하여 크루스칼 알고리즘을 실행합니다.  

```java
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start, end, value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return value - o.value;
    }
}

class UnionFind {
    int size;
    int[] nodes;

    public UnionFind(int n) {
        this.size = n;
        nodes = new int[n];
        for(int i = 0; i < n; ++i)
            nodes[i] = i;
    }

    public int find(int n) {
        if (nodes[n] == n) return n;
        return nodes[n] = find(nodes[n]);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        nodes[rootA] = rootB;
    }
}

public class Baekjoon2887 {
    UnionFind set;
    PriorityQueue<Edge> pq;

    public Baekjoon2887(List<int[]> points) {
        pq = new PriorityQueue<>();
        set = new UnionFind(points.size());
        makeEdge(points);
    }

    private void makeEdge(List<int[]> points) {
        for(int i = 1; i < 4; ++i) {
            int v = i;
            Collections.sort(points, (o1,o2) -> (o1[v] - o2[v]));
            for(int j = 1; j < points.size(); ++j) {
				int[] p1 = points.get(j-1);
				int[] p2 = points.get(j);
				int dis = Math.abs(p1[v]-p2[v]);
			
				pq.add(new Edge(p1[0], p2[0], dis));
			}
        }
    }

    public int solve() {
        int cost = 0;

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();

            if(set.find(curr.start) != set.find(curr.end)) {
                set.union(curr.start, curr.end);
                cost += curr.value;
            }
        }

        return cost;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon2887 problem;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> points = new ArrayList<>(n);

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] point = new int[4];
            point[0] = i;
            point[1] = Integer.parseInt(st.nextToken());
            point[2] = Integer.parseInt(st.nextToken());
            point[3] = Integer.parseInt(st.nextToken());
            points.add(point);
        }

        problem = new Baekjoon2887(points);
        System.out.println(problem.solve());
    }
}
```