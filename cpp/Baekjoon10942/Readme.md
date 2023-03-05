# (10942) 팰린드롬?
## :100: Algorithm
## 문제
명우는 홍준이와 함께 팰린드롬 놀이를 해보려고 한다.  
먼저, 홍준이는 자연수 N개를 칠판에 적는다. 그 다음, 명우에게 질문을 총 M번 한다.  
각 질문은 두 정수 S와 E(1 ≤ S ≤ E ≤ N)로 나타낼 수 있으며, S번째 수부터 E번째 까지 수가 팰린드롬을 이루는지를 물어보며, 명우는 각 질문에 대해 팰린드롬이다 또는 아니다를 말해야 한다.  
예를 들어, 홍준이가 칠판에 적은 수가 1, 2, 1, 3, 1, 2, 1라고 하자.

- S = 1, E = 3인 경우 1, 2, 1은 팰린드롬이다.
- S = 2, E = 5인 경우 2, 1, 3, 1은 팰린드롬이 아니다.
- S = 3, E = 3인 경우 1은 팰린드롬이다.
- S = 5, E = 7인 경우 1, 2, 1은 팰린드롬이다.  

자연수 N개와 질문 M개가 모두 주어졌을 때, 명우의 대답을 구하는 프로그램을 작성하시오.
## 입력
첫째 줄에 수열의 크기 N (1 ≤ N ≤ 2,000)이 주어진다.  
둘째 줄에는 홍준이가 칠판에 적은 수 N개가 순서대로 주어진다. 칠판에 적은 수는 100,000보다 작거나 같은 자연수이다.  
셋째 줄에는 홍준이가 한 질문의 개수 M (1 ≤ M ≤ 1,000,000)이 주어진다.  
넷째 줄부터 M개의 줄에는 홍준이가 명우에게 한 질문 S와 E가 한 줄에 하나씩 주어진다.

## 출력
총 M개의 줄에 걸쳐 홍준이의 질문에 대한 명우의 답을 입력으로 주어진 순서에 따라서 출력한다. 팰린드롬인 경우에는 1, 아닌 경우에는 0을 출력한다.

## 풀이
기본적인 아이디어는 요청한 구간을 물어볼때 마다 팰린드롭인지 검사하는 것이 아닌 모든 구간에 대하여 팰린드롭의 여부를 저장해두는 테이블을 만들어 놓고 테이블을 참조하여 답을 하는 것을 기본으로 하여 문제를 해결하였습니다.  

이때 모든 구간에 대하여 팰린드롭인지 검사를 합니다.  
검사는 아래와 같이 시작과 끝에 포인터를 두고 값이 같은지를 확인합니다.  

```cpp
bool isPalindrome(vector<int>&nums, int s, int e){
    for(; s < e; ++s, --e)
        if(nums[s] != nums[e])
            return false;

    return true;
}
```

이때 특정 구간에서 팰린드롭이라고 판정이 나면 포인터가 지나간길은 모두 팰린드롭인 문장이 됩니다.  
즉 (s=1, e=7)이 팰린드롭이라면 (s=2, e=6), (s=3,e=5), (s=4, e= 4)는 모두 팰린드롭이 됩니다.  
그러므로 아래의 코드와 같이 구간이 팰린드롭이라고 판별되면 해당 구간으로 부터 s<=e인 구간에 대하여 ++s, --e를 하며 보두 팰린드롭임을 표기해 줍니다.  

```cpp
void findPalindrome(vector<int>&nums, vector<vector<bool>>&table){
    int c_r, c_c;

    for(int r = 0; r < nums.size(); ++r)
        for(int c = r; c < nums.size(); ++c)
            if(!table[r][c])
                if(isPalindrome(nums, r, c))
                    for(c_r = r, c_c =c; c_r <= c_c; ++c_r, --c_c)    
                        table[c_r][c_c] = true;
}
```

전구간에 대하여 팰린드롭의 표기를 끝냈다면 질의에 대하여 테이블을 참조하여 답을 해주면 됩니다.  

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e;
    cin >> n;

    vector<int> nums(n);
    for(int i = 0;i < n; ++i)
        cin >> nums[i];
    
    vector<vector<bool>> table(n, vector<bool>(n));
    findPalindrome(nums, table);

    cin >> m;
    while(m--){
        cin >> s >> e;
        cout << (table[s-1][e-1] ? 1 : 0) << "\n";
    }
    return 0;
}
```