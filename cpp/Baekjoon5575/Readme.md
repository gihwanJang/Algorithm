# (5575) 타임 카드
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/5575)
#
## 문제
JOI 상사는 직원의 근무시간을 타임 카드로 관리하고있다. 직원들은 전용 장비를 사용하여 타임 카드에 출근 시간을 기록한다. 근무를 마치고 퇴근할 때도 타임 카드에 퇴근 시간을 기록한다. 타임카드에서 사용하는 시간단위는 24 시간제를 사용한다.

보안상의 이유로 직원들의 출근 시간은 7시 이후이다. 또한, 모든 직원은 23시 이전에 퇴근한다. 직원의 퇴근 시간은 항상 출근 시간보다 늦다.

입력으로 JOI 상사의 3 명의 직원 A 씨, B 씨, C 씨의 출근 시간과 퇴근 시간이 주어 졌을 때 각 직원의 근무시간을 계산하는 프로그램을 작성하라.
#
## 입력
입력은 3 행으로 구성된다.

첫 번째 줄에는 A 씨의 출근 시간과 퇴근 시간,

두 번째 줄에는 B 씨의 출근 시간과 퇴근 시간,

세 번째 줄에는 C 씨의 출근 시간과 퇴근 시간이 각각 공백으로 구분되어 있다.

시간은 각각 공백으로 구분된 3 개의 정수로 쓰여져있다.

3 개의 정수 h(7 ≦ h ≦ 22), m(0 ≦ m ≦ 59), s(0 ≦ s ≦ 59)는 h시 m 분 s 초를 나타낸다.
#
## 출력
첫 번째 줄에 A 씨의 근무 시간,

두 번째 줄에 B 씨의 근무 시간,

세 번째 줄에 C 씨의 근무 시간을 출력하라.

근무 시간이 h 시간 m 분 s 초이면 h, m, s의 순으로 공백으로 분리하여 출력하라.
#
## 풀이
각 A, B, C의 퇴근 시간과 출근 시간을 입력받습니다.  

이후 모두의 퇴근 시간의 분과 초를 계산 할 수 있도록 변환해 줍니다.  

이후 퇴근 시간에서 출근 시간을 뺀 값을 출력해 줍니다.

```cpp
#include <iostream>

using namespace std;

struct Time{
    int h, m, s;
};

void convertTime(Time&end, Time&start){
    if(end.s < start.s){
        --end.m;
        end.s += 60;
    }
    if(end.m < start.m){
        --end.h;
        end.m += 60;
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Time a_start, a_end, b_start, b_end, c_start, c_end;
    cin >> a_start.h >> a_start.m >> a_start.s;
    cin >> a_end.h >> a_end.m >> a_end.s;
    
    cin >> b_start.h >> b_start.m >> b_start.s;
    cin >> b_end.h >> b_end.m >> b_end.s;
    
    cin >> c_start.h >> c_start.m >> c_start.s;
    cin >> c_end.h >> c_end.m >> c_end.s;

    convertTime(a_end, a_start);
    convertTime(b_end, b_start);
    convertTime(c_end, c_start);

    cout << a_end.h - a_start.h << " ";
    cout << a_end.m - a_start.m << " ";
    cout << a_end.s - a_start.s << "\n";

    cout << b_end.h - b_start.h << " ";
    cout << b_end.m - b_start.m << " ";
    cout << b_end.s - b_start.s << "\n";

    cout << c_end.h - c_start.h << " ";
    cout << c_end.m - c_start.m << " ";
    cout << c_end.s - c_start.s << "\n";
    return 0;
}
```