# (10699) 오늘 날짜
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/10699)
#
## 문제
서울의 오늘 날짜를 출력하는 프로그램을 작성하시오.
#
## 출력
서울의 오늘 날짜를 "YYYY-MM-DD" 형식으로 출력한다.
#
## 풀이
오늘의 날짜를 출력해주시면 됩니다.  
이때 출력 양식은 월과 일은 2자리로 출력해야 합니다.

```cpp
#include <stdio.h>
#include <ctime>

using namespace std;

int main(int argc, char const *argv[]){
    time_t timer;
    tm *t;

    timer = time(NULL);
    t = localtime(&timer);

    printf("%d-", t->tm_year+1900);
    printf("%02d-", t->tm_mon+1);
    printf("%02d\n", t->tm_mday);
    return 0;
}
```