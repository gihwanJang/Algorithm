# (2110) 공유기 설치

## :100: Algorithm

## 문제
도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.

도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.

C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

## 입력
첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다. 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

## 출력
첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.

## 풀이
설치 할 수 있는 공유기 갯수는 설치 할 수 있는 거리에 반비례하게 됩니다.  
그러므로 입력 받은 집들의 위치를 정렬한 후 가장 앞의 집과 가장 뒤에 있는 집의 차이를 구합니다.  
이때 구한 차이는 공유기를 설치할 수 있는 최대 거리인 high가 되고 최소 거리는 1로 low가 됩니다.  
해당 경계값을 통해 이진탐색을 실행합니다.  
mid의 거리로 공유기를 설치 했을 때 해당 (공유기의 갯수가 입력 받은 갯수 보다 적으면) 설치거리가 mid보다 작아야 하므로 최대 경계값 high를 mid로 변경하고 (공유기의 갯수가 입력 받은 갯수 보다 크거나 같으면) low를 mid보다 크게 변경해 줍니다.  
아래의 코드는 위의 설명을 코드로 표현한 것 입니다.  

<코드>
```cpp
int canInstall(int distance, vector<int>&house){
    int cnt = 1;
    int last = house[0];

    for(int i = 1; i < house.size(); ++i){
        int curr = house[i];
        if(curr - last >= distance) {
			++cnt;
			last = curr;
		}
    }

    return cnt;
}

int solution(int n, int c, vector<int>&house){
    sort(house.begin(), house.end());

    int lo = 1;
    int hi = house[n-1] - house[0] + 1;

    while(lo < hi){
        int mid = (lo + hi) / 2;

        if(canInstall(mid, house) < c)
            hi = mid;
        else
            lo = mid + 1;
    }

    return lo - 1;
}
```