# (2166) 다각형의 면적
## :100: Algorithm
## 문제
2차원 평면상에 N(3 ≤ N ≤ 10,000)개의 점으로 이루어진 다각형이 있다. 이 다각형의 면적을 구하는 프로그램을 작성하시오.

## 입력
첫째 줄에 N이 주어진다. 다음 N개의 줄에는 다각형을 이루는 순서대로 N개의 점의 x, y좌표가 주어진다. 좌표값은 절댓값이 100,000을 넘지 않는 정수이다.

## 출력
첫째 줄에 면적을 출력한다. 면적을 출력할 때에는 소수점 아래 둘째 자리에서 반올림하여 첫째 자리까지 출력한다.

## 풀이
다각형의 경우 한 점을 고정하고 다른 두 점들 선택하면 삼각형을 만들 수 있습니다.  
그러므로 한 점을 기준으로 선택하고 두 점씩 선택해 가면 면적을 구해 더해주면 됩니다.  
다만 이때 선택한 삼각형이 다각형의 외부일 수도 있고 내부 있수 도 있는데 삼각형 넓이를 구하는 아래와 같은 공식을 사용하면 내부와 외부의 계산 결과의 부호가 다르게 됩니다.  

$ \frac{1}{2} \vert x_1y_2 + x_2y_3 + x_3y_1 - x_2y_1 - x_3y_2 - x_1y_3 \vert$

```cpp
double triangleArea(double x1, double x2, double x3, double y1, double y2, double y3){
	double res = x1 * y2 + x2 * y3 + x3 * y1;
	res -= y1 * x2 + y2 * x3 + y3 * x1;
	return res / 2;
}
```

그러므로 내부에 있는 삼각형을 더해지고 외부에 있는 삼각형은 빼집니다.  
물론 위의 가정도 다각형의 점이 임의로 주어지면 성립하지 않지만 해당 문제에서 좌표는 다각형을 이루는 순서대로 주어지기 때문에 가능 합니다.
그렇게 모든 삼각형을 다합산하여 절댓값을 반환하면 답을 도출 할 수 있습니다.

```cpp
double calculateArea(vector<pair<int,int>>&points){
    double res = 0;

    for (int i = 2; i < points.size(); ++i)
		res += triangleArea(points[0].first, points[i - 1].first, points[i].first, points[0].second, points[i - 1].second, points[i].second);

    return abs(res);
}
```

마지막으로 출력시 출력 조건에 맞게 출력해 줍니다.

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;

    vector<pair<int,int>> points(n);
    for(int i = 0; i < n; ++i)
        cin >> points[i].first >> points[i].second;
    
    cout << fixed;
    cout.precision(1);
    cout << calculateArea(points) << "\n";
    return 0;
}
```