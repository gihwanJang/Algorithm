# (12852) 1로 만들기 2
## :100: Algorithm
## 문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.  

정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

## 입력
첫째 줄에 1보다 크거나 같고, 10e6보다 작거나 같은 자연수 N이 주어진다.

## 출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.  
둘째 줄에는 N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력한다. 정답이 여러 가지인 경우에는 아무거나 출력한다.

## 풀이
해당 문제의 경우 처음에는 전수조사를 시도했지만 시간 초과가나게 되어 dp를 이용하여 문제를 풀이했습니다.  
우선 연산 횟수 만이 아닌 연산과정을 출력해야 하므로 이전 기록들을 추적 할 수 있게 아래와 같은 자료구조를 이용하여 dp를 시도 했습니다.  
cnt는 현제까지의 연산 횟수 이며 prev는 이전 연산 값 입니다.  

```cpp
struct history{
    int cnt;
    int prev;
};
```

이후 dp를 시도하는데 이때 2가지 방법을 생각해 볼 수 있습니다.  
n에서 시작하여 1까지 도달하는 경로와 1에서 시작하여 n까지 도달하는 경로가 있습니다.  
하지만 n에서 시작하여 1로 도달하게 된다면 3 또는 2로 나눌때 마다 나눠 떨어지는지 확인을 해야한다는 점과 출력시 되추적후에  되추적한것을 다시 출력해야한다는 비효율적인 면이 있어 1에서 시작하여 n으로 도달하는 점화식을 세우게 되었습니다.  
해당 점화식은 다음과 같습니다.  
dp[i * 3] = min(dp[i * 3].cnt, dp[i].cnt + 1)  
dp[i * 2] = min(dp[i * 2].cnt, dp[i].cnt + 1)  
dp[i + 1] = min(dp[i + 1].cnt, dp[i].cnt + 1)  

```cpp
void makeOne(int n, vector<history>&dp){
    dp[1].cnt = 0;
    dp[1].prev = 1;

    for(int i = 1; i < n; ++i){
        if(i * 3 <= n)
            if(dp[i*3].prev == 0 || dp[i*3].cnt > dp[i].cnt+1){
                dp[i*3].cnt = dp[i].cnt+1;
                dp[i*3].prev = i;
            }
        
        if(i * 2 <= n)
            if(dp[i*2].prev == 0 || dp[i*2].cnt > dp[i].cnt+1){
                dp[i*2].cnt = dp[i].cnt+1;
                dp[i*2].prev = i;
            }    

        if(dp[i+1].prev == 0 || dp[i+1].cnt > dp[i].cnt+1){
            dp[i+1].cnt = dp[i].cnt+1;
            dp[i+1].prev = i;
        }
    }

    return;
}
```

출력의 경우 연산 횟수는 n번째 dp의 cnt를 출력하고  연산과정은 n에서 prev를 따라 출력해 주면 됩니다.

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<history> dp(n + 1);
    makeOne(n, dp);
    
    int curr = n;
    cout << dp[n].cnt << "\n";
    while(curr != 1){
        cout << curr << " ";
        curr = dp[curr].prev;
    }
    cout << 1 << "\n";
    return 0;
}
```