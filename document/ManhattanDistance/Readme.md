# Manhattan Distance(맨해튼 거리)

## 정의
맨해튼 거리는 
$d_{1}$ 과 벡터 
${\mathbf  {p}}$ , 
${\mathbf  {q}}$ 사이에 차원 실수를 데카르트 좌표계에 일정한 좌표축의 점 위에 투영한 선분 길이의 합을 말하는데, 이를 공식으로 표현하면 다음과 같다.

${\mathbf  {p}}=(p_{1},p_{2},\dots ,p_{n})\,$과 
${\mathbf  {q}}=(q_{1},q_{2},\dots ,q_{n})\,$를 공간 벡터라 할 때,

$d_{1}(\mathbf{p}, \mathbf{q}) = \lVert \mathbf{p} - \mathbf{q} \rVert_{1} = \sum_{i=1}^{n} \lvert p_{i} - q_{i} \rvert$
이다.



예를 들어 2차원 평면위의 두점 
$(x_{1},y_{2})$ 과 
$(x_{1},y_{2})$ 가 있을 때, 두 점의 맨해튼 거리는
$|x_{1}-x_{2}|+|y_{1}-y_{2}|$ 이다. 

## 최단거리와 최장거리 찾기

2차원 평면에서의 맨허튼 거리는 아래와 같이 총 4가지의 경우로 나눌 수 있다.

1. $x_{1} \geq x_{2}$ && $y_{1} \geq y_{2}$
   - $|x_{1}-x_{2}|+|y_{1}-y_{2}|$ = $x_{1}-x_{2}+y_{1}-y_{2}$ = $(x_{1}+y_{1})-(x_{2}+y_{2})$
2. $x_{1} \geq x_{2}$ && $y_{1} \leq y_{2}$
   - $|x_{1}-x_{2}|+|y_{1}-y_{2}|$ = $x_{1}-x_{2}+y_{2}-y_{1}$ = $(x_{1}-y_{1})-(x_{2}-y_{2})$
3. $x_{1} \leq x_{2}$ && $y_{1} \geq y_{2}$
   - $|x_{1}-x_{2}|+|y_{1}-y_{2}|$ = $x_{2}-x_{1}+y_{1}-y_{2}$ = $(x_{2}-y_{2})-(x_{1}-y_{1})$
4. $x_{1} \leq x_{2}$ && $y_{1} \leq y_{2}$
   - $|x_{1}-x_{2}|+|y_{1}-y_{2}|$ = $x_{2}-x_{1}+y_{2}-y_{1}$ = $(x_{2}+y_{2})-(x_{1}+y_{1})$

위의 특성을 이용하면 효율적인 방식으로 주어진 위치에서 최장거리와 최단 거리를 찾을 수 있다.  
각 점의 x, y의 차와 합을 각각 저장 한 배열에 대하여 정렬 한 후 최소 거리를 구한다면 차이가 가장 작은 값, 최대 거리를 구한다면 차이가 가장 큰 값으로 답을 내면 된다.  
다만 맨해튼 거리에서 최대 거리는 45도 회전시키면 체비셰프 거리에서의 최댓값을 구하는 문제가 되므로 더 효율적인 방법으로도 계산이 가능하다.

## 예제 코드
``` java
class Manhattan {
	int n;
	int[] sub;
	int[] sum;

	public Manhattan(int n) {
		this.n = n;
		this.sub = new int[n];
		this.sum = new int[n];
	}

	public int getLongestDistance() {
		Arrays.sort(sub);
		Arrays.sort(sum);
		return Math.max(sub[n-1] - sub[0], sum[n - 1] - sum[0]);
	}

    public int getShotestDistance() {
        int sumMax = 0;
        int subMax = 0;
        
		Arrays.sort(sub);
		Arrays.sort(sum);
        for(int i = 1; i < n; ++i) {
            sumMax = Math.min(sumMax, sum[i] - sum[i-1]);
            subMax = Math.min(subMax, sub[i] - sub[i-1]);
        }
		return Math.min(sumMax, subMax);
	}
}
```