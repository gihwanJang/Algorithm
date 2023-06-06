# (10101) 삼각형 외우기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/10101)
#
## 문제
창영이는 삼각형의 종류를 잘 구분하지 못한다. 따라서 프로그램을 이용해 이를 외우려고 한다.

삼각형의 세 각을 입력받은 다음, 

- 세 각의 크기가 모두 60이면, Equilateral
- 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
- 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
- 세 각의 합이 180이 아닌 경우에는 Error

를 출력하는 프로그램을 작성하시오.
#
## 입력
총 3개의 줄에 걸쳐 삼각형의 각의 크기가 주어진다. 모든 정수는 0보다 크고, 180보다 작다.
## 출력
문제의 설명에 따라 Equilateral, Isosceles, Scalene, Error 중 하나를 출력한다.
#
## 풀이
세 각을 입력받은 후 아래의 조건문을 실행합니다.

해당 각의 합이 180이 아닌 경우 Error를 출력합니다.  
두 각이 60이면 Equilateral를 출력합니다.  
두 각이 같으면 Isosceles를 출력합니다.  
이외의 경우는 Scalene를 출력합니다.  

```cpp
#include <iostream>
#include <vector>

using namespace std;

string kindOfTriangle(vector<int>&triangle){
    int sum = 0;

    for(int i = 0; i < 3; ++i)
        sum += triangle[i];

    if(sum != 180)
        return "Error";

    if(triangle[0] == 60 && triangle[1] == 60)
        return "Equilateral";

    if(triangle[0] == triangle[1] || triangle[1] == triangle[2] || triangle[0] == triangle[2])
        return "Isosceles";

    return "Scalene";
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> triangle(3);
    for(int i = 0; i < 3; ++i)
        cin >> triangle[i];

    cout << kindOfTriangle(triangle) << "\n";
    return 0;
}
```