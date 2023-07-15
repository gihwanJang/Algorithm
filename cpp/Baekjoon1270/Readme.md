# (1270) 전쟁 - 땅따먹기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1270)
#
## 문제
드디어 전쟁은 전면전이 시작되었고, 서로 땅을 따먹기 시작했다.

현재 여러 지역은 한창 전쟁이 벌어지고 있는 상황인데, 어느 지역은 거의 전쟁이 마무리 단계로 가고 있다.

하지만 당신은 군대를 보낼 때 적군을 혼란시키기 위해서 우리 나라의 군대라는걸 표시하지 않고, 군대의 번호로 표시했다.

어느 땅에서 한 번호의 군대의 병사가 절반을 초과한다면 그 땅은 그 번호의 군대의 지배하에 놓이게 된다.

이때, 각 땅들을 지배한 군대의 번호를 출력하여라. 만약, 아직 전쟁이 한창중인 땅이라면 “SYJKGW”을 쌍 따옴표 없이 출력한다.
#
## 입력
첫째 줄에는 땅의 개수 n(n<=200)이 주어진다. 그리고 두 번째 줄에서 n+1번째 줄에는 제일 처음에 숫자 Ti(i번째 땅의 병사수, Ti<=100,000)와, Ti개의 숫자 (각각 병사의 군대 번호)가 주어진다. i번째 땅의 j번째 병사 번호 Nij가 주어진다. ( | Nij | <= 2^31 )
#
## 출력
첫째 줄에는 각각의 땅의 상태를 순서대로 출력한다. 만약 땅이 지배가 되어있다면 그 지배한 병사의 번호를 출력하고, 아니라면 “SYJKGW”을 쌍 따옴표 없이 출력한다.
#
## 풀이
해당 문제는 map을 이용하면 해결 할 수 있는 문제입니다.  

map을 선언합니다.
이때 map의 자료형은 Nij의 범위가 int범위를 벗어 나기 때문에 <long, int>가 되어야합니다.

해당 땅의 병사를 입력 받습니다.
해당 국의 병사가 map에 있다면 병사수를 증가 시키고 없다면 map에 추가합니다.

각 국의 병사 수를 카운트하며 만약 전체 병사의 전반을 넘었다면 해당 국을 아니면 SYJKGW를 출력해줍니다.

위의 과적을 각 땅에 대하여 동일 하게 반복해 주시면 됩니다.

```cpp
#include <unordered_map>
#include <iostream>


using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    while(n--)
    {
        bool flag = true;
        int t;
        long army;
        unordered_map<long,int> map;
        
        cin >> t;
        
        for(int i = 0; i < t; ++i)
        {
            cin >> army;

            if(map.count(army))
                ++map.find(army)->second;
            else
                map.insert({army, 1});
        }

        for(pair<long,int> a : map)
            if(double(t) / 2 < a.second)
            {
                cout << a.first << "\n";
                flag = false;
                break;
            }

        if(flag)
            cout << "SYJKGW\n";
    }
    return 0;
}
```