# (6549) 히스토그램
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/6549)
#
## 문제
히스토그램은 직사각형 여러 개가 아래쪽으로 정렬되어 있는 도형이다. 각 직사각형은 같은 너비를 가지고 있지만, 높이는 서로 다를 수도 있다. 예를 들어, 왼쪽 그림은 높이가 2, 1, 4, 5, 1, 3, 3이고 너비가 1인 직사각형으로 이루어진 히스토그램이다.

![img1](https://www.acmicpc.net/upload/images/histogram.png)

히스토그램에서 가장 넓이가 큰 직사각형을 구하는 프로그램을 작성하시오.
#
## 입력
입력은 테스트 케이스 여러 개로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, 직사각형의 수 n이 가장 처음으로 주어진다. (1 ≤ n ≤ 100,000) 그 다음 n개의 정수 h1, ..., hn (0 ≤ hi ≤ 1,000,000,000)가 주어진다. 이 숫자들은 히스토그램에 있는 직사각형의 높이이며, 왼쪽부터 오른쪽까지 순서대로 주어진다. 모든 직사각형의 너비는 1이고, 입력의 마지막 줄에는 0이 하나 주어진다.
#
## 출력
각 테스트 케이스에 대해서, 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 출력한다.
#
## 풀이
우선 해당 문제는 스택을 이용하여 해결이 가능하며 분할정복을 이용하여도 해결이 가능한 문제입니다.  
해당 풀이에서는 분할정복을 이용하여 문제를 해결 하였습니다.  

면저 히스토그램을 입력받습니다.  
밑변은 1로 고정이니 높이 값만을 리스트에 저장하여 히스토그램을 유지합니다.  

분할 정복의 기본적인 아이디어는 다음과 같습니다.  
(좌측 최대, 우측 최대, 좌우측 통합 최대) 3가지 경우중 최대를 택하면 해당 직사각형은 가장큰 넓이의 직사각형이 됩니다.  
그러기 위해 중앙을 기준으로 분할 정복을 시도합니다.  
여기서 좌측과 우측의 최대 값을 가져오는 것 까지는 쉽게 할 수 있습니다.  

문제는 좌우측 통합의 최대를 따로 구해줘야 한다는 것입니다.  
우선 좌우측 통합이기 때문에 중앙을 기준으로 좌측 우측을 모두 지나야합니다.  
그러므로 최초 최대 넓이는 중앙을 기준으로 잡습니다.  

이후 좌측 또는 우측으로 이동하며 최대 넓이의 값을 갱신해 줍니다.  
이동은 높이가 큰 것을 선택해줍니다.

위의 과정이 끝나면 큰 것을 골라 이동했기 때문에 특정 방향으로 이동하지 못할 수도 있습니다.  
그러므로 해당 특정 방향으로도 쭉이동하며 최대 넓이의 값을 갱신해 줍니다.  

좌우측 통합 최대 값이 구해졌음으로 (좌측, 우측, 좌우측) 최대 값을 골라 출력해 주면됩니다. 

```cpp
#include <iostream>
#include <vector>

using namespace std;

long combination(vector<long>&histogram, int lo, int hi) {
    int mid = (lo + hi) / 2;
    int toLeft = mid;
	int toRight = mid;

    long height = histogram[mid];
    long maxArea = height;

    while(lo < toLeft && toRight < hi) {
		if(histogram[toLeft - 1] < histogram[toRight + 1])
			height = min(height, histogram[++toRight]);	
		else 
			height = min(height, histogram[--toLeft]);

		maxArea = max(maxArea, height * (toRight - toLeft + 1)); 
	}

    while (toRight < hi) {
        height = min(height, histogram[++toRight]);
        maxArea = max(maxArea, height * (toRight - toLeft + 1));
    }

    while (lo < toLeft) {
        height = min(height, histogram[--toLeft]);
        maxArea = max(maxArea, height * (toRight - toLeft + 1));
    }
    
    return maxArea;
}

long divideAndConquer(vector<long>&histogram, int lo, int hi) {
    if(lo == hi) return histogram[lo];
    
    int mid = (lo + hi) / 2;
    
    long left = divideAndConquer(histogram, lo, mid);
    long right = divideAndConquer(histogram, mid + 1, hi);

    return max(max(left, right), combination(histogram, lo, hi));
}

long getMaxArea(vector<long>&histogram) {
    return divideAndConquer(histogram, 0, histogram.size()-1);
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (true) {
        int n;
        cin >> n;
        if(!n) break;

        vector<long> histogram(n);
        for(int i = 0; i < n; ++i)
            cin >> histogram[i];

        cout << getMaxArea(histogram) << "\n";
    }
    return 0;
}
```