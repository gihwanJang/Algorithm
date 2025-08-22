# (2162) 선분 그룹
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2162)
## 문제
N개의 선분들이 2차원 평면상에 주어져 있다. 선분은 양 끝점의 x, y 좌표로 표현이 된다.

두 선분이 서로 만나는 경우에, 두 선분은 같은 그룹에 속한다고 정의하며, 그룹의 크기는 그 그룹에 속한 선분의 개수로 정의한다. 두 선분이 만난다는 것은 선분의 끝점을 스치듯이 만나는 경우도 포함하는 것으로 한다.

N개의 선분들이 주어졌을 때, 이 선분들은 총 몇 개의 그룹으로 되어 있을까? 또, 가장 크기가 큰 그룹에 속한 선분의 개수는 몇 개일까? 이 두 가지를 구하는 프로그램을 작성해 보자.

## 입력
첫째 줄에 N(1 ≤ N ≤ 3,000)이 주어진다. 둘째 줄부터 N+1번째 줄에는 양 끝점의 좌표가 x1, y1, x2, y2의 순서로 주어진다. 각 좌표의 절댓값은 5,000을 넘지 않으며, 입력되는 좌표 사이에는 빈칸이 하나 있다.

## 출력
첫째 줄에 그룹의 수를, 둘째 줄에 가장 크기가 큰 그룹에 속한 선분의 개수를 출력한다.

## 풀이
해당 문제는 CCW, Union Find를 이용하면 해결 할 수 있는 문제입니다.  

선분의 교차여부는 CCW 알고리즘을 이용하면 판별 할 수 있습니다.  
한 선분을 기준으로 CCW 알고리즘을 수행 하면 해당 선분을 기준으로 두 점이 좌,우측 어디에 위치하는지 알 수 있으며 해당 과정을 두 선분에 대하여 진행 하였을 때 모두 해당 값의 곱이 -1이라면 교차하는 선분입니다.  
또한 0인 경우 한 직선위에 있는 있음으로 한 선분의 시작 점이 다른 선분의 끝점 보다 작고 다른 선분의 시작 점이 한 선분의 끝 보다 작으면 만나는 선분으로 판별 할 수 있습니다.  

위의 과정을 반복하며 모든 선분의 교차여부를 확인하며 유니온 파인드를 이용하여 Union해줍니다.  
이후 그룹의 갯수와 해당 그룹의 노드 수를 출력해주면 됩니다.

```java
import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x, y;
    @Override
    public int compareTo(Point o) {
        if(x == o.x) return y - o.y;
        return x - o.x; 
    }
}

class Line {
    Point p1, p2;
    private int CCW(Point p3) {
        int ccw = ( p1.x*(p2.y - p3.y) + p2.x*(p3.y - p1.y) + p3.x*(p1.y - p2.y) );
        if(ccw > 0) return 1;
        if(ccw < 0) return -1;
        return 0;
    }
    public boolean isCrossed(Line o) {
        int basedThis = CCW(o.p1) * CCW(o.p2);
        int basedOther = o.CCW(p1) * o.CCW(p2);

        if(basedThis == 0 && basedOther == 0) {
            Point thisLo = p1.compareTo(p2) < 0 ? p1 : p2;
            Point thisHi = p1.compareTo(p2) < 0 ? p2 : p1;
            Point otherLo = o.p1.compareTo(o.p2) < 0 ? o.p1 : o.p2;
            Point otherHi = o.p1.compareTo(o.p2) < 0 ? o.p2 : o.p1;

            return (thisLo.compareTo(otherHi) <= 0 && otherLo.compareTo(thisHi) <= 0);
        }
        
        return (basedThis <= 0 && basedOther <= 0);
    }
}

class UnionFine {
    int[] nodes, count;
    public UnionFine(int n) {
        nodes = new int[n];
        count = new int[n];
        for(int i = 0; i < n; ++i) {
            nodes[i] = i;
        }
        Arrays.fill(count, 1);
    }
    public int find(int n) {
        if(nodes[n] == n) return n;
        return nodes[n] = find(nodes[n]);
    }
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;
        nodes[rootA] = rootB;
        count[rootB] += count[rootA];
    }
}

public class Baekjoon2162 {
    int size;
    UnionFine group;
    List<Line> lines;

    public Baekjoon2162(int n) {
        size = n;
        group = new UnionFine(n);
        lines = new ArrayList<>(n);
    }

    public void makeGroup() {
        for(int i = 0; i < size; ++i) {
            for(int j = i+1; j < size; ++j) {
                if(lines.get(i).isCrossed(lines.get(j))) {
                    group.union(i, j);
                }
            }
        }
    }

    public String solve() {
        int maxCount = 0;
        int groupCount = 0;
        StringBuilder sb = new StringBuilder();

        makeGroup();
        for(int i = 0; i < size; ++i) {
            if(group.nodes[i] == i) {
                ++groupCount;
                maxCount = Math.max(maxCount, group.count[i]);
            }
        }

        sb.append(groupCount);
        sb.append("\n");
        sb.append(maxCount);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Baekjoon2162 problem = new Baekjoon2162(Integer.parseInt(br.readLine()));
        
        for(int i = 0; i < problem.size; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problem.lines.add(new Line());

            problem.lines.get(i).p1 = new Point();
            problem.lines.get(i).p1.x = Integer.parseInt(st.nextToken());
            problem.lines.get(i).p1.y = Integer.parseInt(st.nextToken());

            problem.lines.get(i).p2 = new Point();
            problem.lines.get(i).p2.x = Integer.parseInt(st.nextToken());
            problem.lines.get(i).p2.y = Integer.parseInt(st.nextToken());
        }

        System.out.println(problem.solve());
    }
}
```