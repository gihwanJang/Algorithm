# (9019) DSLR
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/9019)
#
## 문제
네 개의 명령어 D, S, L, R 을 이용하는 간단한 계산기가 있다. 이 계산기에는 레지스터가 하나 있는데, 이 레지스터에는 0 이상 10,000 미만의 십진수를 저장할 수 있다. 각 명령어는 이 레지스터에 저장된 n을 다음과 같이 변환한다. n의 네 자릿수를 d1, d2, d3, d4라고 하자(즉 n = ((d1 × 10 + d2) × 10 + d3) × 10 + d4라고 하자)

1. D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
2. S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
3. L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
4. R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.

위에서 언급한 것처럼, L 과 R 명령어는 십진 자릿수를 가정하고 연산을 수행한다. 예를 들어서 n = 1234 라면 여기에 L 을 적용하면 2341 이 되고 R 을 적용하면 4123 이 된다.

여러분이 작성할 프로그램은 주어진 서로 다른 두 정수 A와 B(A ≠ B)에 대하여 A를 B로 바꾸는 최소한의 명령어를 생성하는 프로그램이다. 예를 들어서 A = 1234, B = 3412 라면 다음과 같이 두 개의 명령어를 적용하면 A를 B로 변환할 수 있다.

1234 →L 2341 →L 3412
1234 →R 4123 →R 3412

따라서 여러분의 프로그램은 이 경우에 LL 이나 RR 을 출력해야 한다.

n의 자릿수로 0 이 포함된 경우에 주의해야 한다. 예를 들어서 1000 에 L 을 적용하면 0001 이 되므로 결과는 1 이 된다. 그러나 R 을 적용하면 0100 이 되므로 결과는 100 이 된다.
#
## 입력
프로그램 입력은 T 개의 테스트 케이스로 구성된다. 테스트 케이스 개수 T 는 입력의 첫 줄에 주어진다. 각 테스트 케이스로는 두 개의 정수 A와 B(A ≠ B)가 공백으로 분리되어 차례로 주어지는데 A는 레지스터의 초기 값을 나타내고 B는 최종 값을 나타낸다. A 와 B는 모두 0 이상 10,000 미만이다.
#
## 출력
A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력한다. 가능한 명령어 나열이 여러가지면, 아무거나 출력한다.
#
## 풀이
해당 문제는 BFS를 이용하면 되는 문제입니다.  

해당 BFS는 문자열의 길이가 깊이가 됩니다.  
입력 수에 대하여 각각 D,S,L,R의 연산을 한 값이 이전에 했던 적이 없다면 해당 수와 연산 문자열을 que에 넣어주는 식으로 반복해 주면 됩니다.  

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int D(int n){
    return 2*n > 9999 ? (2*n) % 10000 : 2*n;
}
int S(int n){
    return n == 0 ? 9999 : n-1;
}
int L(int n){
    int num[4];
    for(int i = 0; i < 4; ++i){
        num[i] = n % 10;
        n /= 10;
    }
    return num[2]*1000 + num[1]*100 + num[0]*10 + num[3];
}
int R(int n){
    int num[4];
    for(int i = 0; i < 4; ++i){
        num[i] = n % 10;
        n /= 10;
    }
    return num[0]*1000 + num[3]*100 + num[2]*10 + num[1];
}

string DSLR(int s, int e){
    int n;
    pair<int, string> curr;
    vector<bool> visited(10000);
    queue<pair<int, string>> que;
    que.push({s, ""});
    visited[s] = true;
    
    while(!que.empty()){
        curr = que.front();
        que.pop();

        if(curr.first == e)
            return curr.second;

        n = D(curr.first);
        if(!visited[n]){
            que.push({n, curr.second+"D"});
            visited[n] = true;
        }
        n = S(curr.first);
        if(!visited[n]){
            que.push({n, curr.second+"S"});
            visited[n] = true;
        }
        n = L(curr.first);
        if(!visited[n]){
            que.push({n, curr.second+"L"});
            visited[n] = true;
        }
        n = R(curr.first);
        if(!visited[n]){
            que.push({n, curr.second+"R"});
            visited[n] = true;
        }
    }
    return "";
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, s, e;
    cin >> T;
    while(T--){
        cin >> s >> e;

        cout << DSLR(s, e) << "\n";
    }
    return 0;
}

```