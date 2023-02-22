# (1043) 거짓말
## :100: Algorithm
## 문제
지민이는 파티에 가서 이야기 하는 것을 좋아한다. 파티에 갈 때마다, 지민이는 지민이가 가장 좋아하는 이야기를 한다. 지민이는 그 이야기를 말할 때, 있는 그대로 진실로 말하거나 엄청나게 과장해서 말한다. 당연히 과장해서 이야기하는 것이 훨씬 더 재미있기 때문에, 되도록이면 과장해서 이야기하려고 한다. 하지만, 지민이는 거짓말쟁이로 알려지기는 싫어한다. 문제는 몇몇 사람들은 그 이야기의 진실을 안다는 것이다. 따라서 이런 사람들이 파티에 왔을 때는, 지민이는 진실을 이야기할 수 밖에 없다. 당연히, 어떤 사람이 어떤 파티에서는 진실을 듣고, 또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다. 지민이는 이런 일을 모두 피해야 한다.

사람의 수 N이 주어진다. 그리고 그 이야기의 진실을 아는 사람이 주어진다. 그리고 각 파티에 오는 사람들의 번호가 주어진다. 지민이는 모든 파티에 참가해야 한다. 이때, 지민이가 거짓말쟁이로 알려지지 않으면서, 과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구하는 프로그램을 작성하시오.

## 입력
첫째 줄에 사람의 수 N과 파티의 수 M이 주어진다.

둘째 줄에는 이야기의 진실을 아는 사람의 수와 번호가 주어진다. 진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들의 번호가 주어진다. 사람들의 번호는 1부터 N까지의 수로 주어진다.

셋째 줄부터 M개의 줄에는 각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어진다.

N, M은 50 이하의 자연수이고, 진실을 아는 사람의 수는 0 이상 50 이하의 정수, 각 파티마다 오는 사람의 수는 1 이상 50 이하의 정수이다.
## 출력
첫째 줄에 문제의 정답을 출력한다.

## 풀이
파티에 참석한 인원을 집합들로 묶어야 하므로 해당 문제는 유니온 파인드를 이용하여 풀었습니다.  
처음에는 참석하는 인원들 모두 자기 자신을 부모로 같는 집합에 넣습니다.  
이후 파티에 참석한 인원을 입력 받으며 같은 집합으로 묶어 주게 됩니다.  
이렇게 입력을 받고 집합으로 묶어주는 것을 마치면 최종적으로 집합이 완성됩니다.  
이제 파티에 참석한 인원들을 탐색하며 해당 인원이 진실을 알고있는 인원과 같은 집합에 속해 있다면 해당 파티를 제외합니다.  
이제 제외하고 남은 파티의 수를 출력해주면 됩니다.  

<코드>
```cpp
#include <iostream>
#include <vector>

using namespace std;

int find(vector<int>&parents, int x) {
    if(parents[x] == x) return x;
    return find(parents, parents[x]);
}
 
void union_set(vector<int>&parents, int x, int y) {
    x = find(parents, x);
    y = find(parents, y);
    parents[x] = y;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, k;
    cin >> n >> m >> k;
    // 진실을 알고 있는 사람들 초기화
    vector<int> knowns(k);
    for(int i = 0, p; i < k; ++i){
        cin >> p;
        knowns[i] = p - 1;
    }
    // 해당 인원들의 부모노드 초기화
    vector<int> parents(n);
    for(int i = 0; i < n; ++i)
        parents[i] = i;
    //참석 명부 작성
    vector<vector<int>> roster(m);
    for(int i = 0, c; i < m; ++i){
        cin >> c;
        int p;
        int prev;
        for(int j = 0; j < c; ++j){
            prev = p;
            cin >> p;
            --p;
            // 같은 파티에 참석한 인원을 같은 집합으로 추가
            if(j > 0)
                union_set(parents, prev, p);
            
            roster[i].push_back(p);
        }
    }
    // 진실을 알고 있는 자와 같은 집합에 있다면 해당 파티 제외
    for(auto& list : roster){
        bool hasKnown = false;
        for(auto& person : list){
            if(hasKnown) break;
            for(auto& known : knowns){
                if(find(parents, person) == find(parents, known)){
                    hasKnown = true;
                    break;
                }
            }
        }
        if(hasKnown)
            m--;
    }

    cout << m << "\n";
    return 0;
}
``` 