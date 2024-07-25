# Euclidean Distance(유클리드 거리)

## 정의
데카르트 좌표계로 나타낸 점 p = (p1, p2,..., pn)와 q = (q1, q2,..., qn)가 있을 때, 두 유클리드 노름을 이용하여 두 점 p, q의 거리를 계산하면 다음과 같다.

$\|\mathbf{p} - \mathbf{q}\|$ = 
$\sqrt{(\mathbf{p}-\mathbf{q})\cdot(\mathbf{p}-\mathbf{q})}$ = 
$\sqrt{\|\mathbf{p}\|^2 + \|\mathbf{q}\|^2 - 2\mathbf{p}\cdot\mathbf{q}}$

## 가장 가까운 두점

유클리드 거리를 사용하는 좌표계에서 최근접 점의 거리는 분할 정복을 이용하면 구할 수 있다.  
2차원 평면상을 예로 들었을 때, 아래와 같은 경우를 생각해 볼 수 있다.

![좌표 그림]()

위의 점들을 x값을 기준으로 오름차순으로 정렬한다.  
이후 해당 점들 중 가운데 값을 기준으로 계속 나눠 간다.  
해당 과정을 반복하여 해당 구간의 점이 2개 또는 3개가 될때 까지 반복 후2개 또는 3개의 점에 대하여 최소 거리를 구해준다.  

![분할 좌표 그림]()

이렇게 하면 해당 구간들의 좌, 우측의 최소 거리가 구해진다.  
구해진 좌우측을 중앙을 기준으로 합쳐나간다.  

이때, 최소 값은 (좌, 우측의 최소 값)이 거나 (중앙을 지나가는 점들의 거리)이다.  
좌, 우측은 산출 값이 존재하므로 중앙을 지나가는 점들의 거리중 최소 값을 산출하여야 한다.  
이때 중앙을 지나는 점들의 거리를 전수 조사하게 되면 $O_{(n)}$ 의 시간복잡도를 가지게 된다.  

그러므로 최적화를 해줄 필요가 있다.  
우선 중앙을 기준으로 (좌, 우측의 최소 값)보다 멀리 떨어진 점들은 중앙을 지나는 순가 무조건 최소 값 보다 커지게 되므로 고려할 필요가 없다.  
즉 임의의 점 $P_i$ 와 중점 $P_{mid}$ 대하여 [ ${(P_{mid}.x - P_i.x)}^2$ < Min(l,r)]의 구간에 해당 하는 점들 만을 고려하면 된다.

![분할 최소 좌표 그림]()

또한 위의 구간에서 y축으로도 제한 할 수 있다.  
해당 구간을 y축으로 정렬한후 임의의 점 $P_i$ 와 i점 보다 뒤에 있는 임의의점 $P_j$ 대하여 [ ${(P_j.y - P_i.y)}^2$ < Min]의 구간에 대하여 거리의 최소 값을 갱신해 나가면 된다.

## 예제 코드

``` java
class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Point o) {
        int subX = o.x - x;
        int subY = o.y - y;
        return subX * subX + subY * subY;
    }

    public static Comparator<Point> compareWithX() {
        return new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        };
    }

    public static Comparator<Point> compareWithY() {
        return new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        };
    }

}

class Problem {

    int n;
    Point[] points;

    public Problem(int n) {
        this.n = n;
        this.points = new Point[n];
    }

    public int solve() {
        Arrays.sort(points, Point.compareWithX());
        return closestPair(0, n - 1);
    }

    private int closestPair(int l, int r) {
        if (r - l < 3) {
            int min = Integer.MAX_VALUE;

            for(int i = l; i < r; ++i) {
                for(int j = i + 1; j <= r; ++j) {
                    min = Math.min(min, points[i].getDistance(points[j]));
                }
            }
            return min;
        }

        int mid = l + (r - l) / 2;
        int min = Math.min(closestPair(l, mid), closestPair(mid + 1, r));
        int stripMin = stripClosest(l, r, mid, min);

        return Math.min(min, stripMin);
    }

    private int stripClosest(int l, int r, int mid, int min) {
        List<Point> stripList = new ArrayList<>();

        for (int i = mid; i >= l && doublePow(points[mid].x - points[i].x) < min; --i) {
            stripList.add(points[i]);
        }
        for (int i = mid+1; i <= r && doublePow(points[i].x - points[mid].x) < min; ++i) {
            stripList.add(points[i]);
        }
        Collections.sort(stripList, Point.compareWithY());
        for (int i = 0; i < stripList.size(); ++i) {
            for (int k = i + 1; k < stripList.size() && doublePow(stripList.get(k).y - stripList.get(i).y) < min; ++k) {
                min = Math.min(min, stripList.get(i).getDistance(stripList.get(k)));
            }
        }
        return min;
    }

    private int doublePow(int n) {
        return n * n;
    }

}
```

## 가장 먼 두점