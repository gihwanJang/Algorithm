# (1074) Z
## :100: Algorithm
## 문제
한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.

![Baekjoon1074_1](https://upload.acmicpc.net/21c73b56-5a91-43aa-b71f-9b74925c0adc/-/preview/)

N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.  
다음 예는 22 × 22 크기의 배열을 방문한 순서이다.

![Baekjoon1074_2](https://upload.acmicpc.net/adc7cfae-e84d-4d5c-af8e-ee011f8fff8f/-/preview/)

N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.  
다음은 N=3일 때의 예이다.

![Baekjoon1074_3](https://upload.acmicpc.net/d3e84bb7-9424-4764-ad3a-811e7fcbd53f/-/preview/)

## 입력
첫째 줄에 정수 N, r, c가 주어진다.
## 출력
r행 c열을 몇 번째로 방문했는지 출력한다.
## 풀이

해당 문제의 경우 작은 메모리를 요구하므로 배열을 실제로 채워가며 구현을 할 시 메모리 초과가 나타납니다.  
그러므로 배열이 있다고 가정하며 해당 문제를 풀었습니다.  
  
우선 해당 문제의 경우 부분적으로 반복이 나타나므로 분할 정복을 통하여 해당문제를 해결 할 수 있습니다.  
큰 문제를 작은 문제로 즉 전체의 테이블에서 4구역으로 나누어 문제를 해결 할 수 있습니다.  

이때 모든 경우를 따지며 탐색하는 것은 효율이 좋지 못하므로 찾으려고 하는 좌표 즉(limit_r, limit_c)가 해당 테이블에 포함되어 있으면 탐색을 하고 아니면 해당 테이블에는 없음으로 해당 테이블의 칸수를 전부 더해 줍니다.  

탐색 시에는 문제의 조건에 맞게 우상단, 좌상단, 우하단, 좌하단 순으로 탐색을 해주면 됩니다.  

그 결과 아래와 같이 코딩을 할 수 있습니다.(이때, n : 현재 탐색하는 사이즈, r : 현재 탐색하는 행, c : 현재 탐색하는 열)


<코드>
```cpp
void zSearch(int n, int r, int c, int&count, int limit_r, int limit_c){
    if(limit_r == r && limit_c == c){
        cout << count << "\n";
        return;
    }

    if (limit_r < r + n && limit_r >= r && limit_c < c + n && limit_c >= c){
        zSearch(n/2, r, c, count, limit_r, limit_c);
        zSearch(n/2, r, c + n/2, count, limit_r, limit_c);
        zSearch(n/2, r + n/2, c, count, limit_r, limit_c);
        zSearch(n/2, r + n/2, c + n/2, count, limit_r, limit_c);
    }
    else{
        count += n * n;
    }
    
    return;
}
``` 