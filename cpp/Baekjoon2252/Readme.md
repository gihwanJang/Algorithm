# (2252) 줄 세우기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2252)

## 문제
N명의 학생들을 키 순서대로 줄을 세우려고 한다. 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다. 그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.

일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.

## 입력
첫째 줄에 N(1 ≤ N ≤ 32,000), M(1 ≤ M ≤ 100,000)이 주어진다. M은 키를 비교한 회수이다. 다음 M개의 줄에는 키를 비교한 두 학생의 번호 A, B가 주어진다. 이는 학생 A가 학생 B의 앞에 서야 한다는 의미이다.

학생들의 번호는 1번부터 N번이다.

## 출력
첫째 줄에 학생들을 앞에서부터 줄을 세운 결과를 출력한다. 답이 여러 가지인 경우에는 아무거나 출력한다.

## 풀이
해당 문제의 경우 특정 순서에 따라 정렬을 해야하므로 위상정렬을 이용하면 됩니다.  

이때 키를 비교했을 때 뒤에 서야하는 학생이 진입 차수를 가지게 됩니다.   
입력을 받으며 뒤에서야 하는 학생의 진입차수를 증가 시켜주고 그래프에 앞에 서야하는 학생의 노드에 추가 시켜줍니다.  

코드는 아래와 같고 이때 그래프를 인접행렬로 구현하면 시간 초과가 되니 인접 그래프로 구현해야됩니다.

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e;
    cin >> n >> m;

    vector<int> inDegree(n+1);
    vector<vector<int>> seq(n+1);
    for(int i = 0; i < m; ++i){
        cin >> s >> e;

        ++inDegree[e];
        seq[s].push_back(e);
    }

    line_up(inDegree, seq);
    cout << "\n";
    return 0;
}
```

위의 과정이 끝났다면 진입차수와 그래프를 이용하여 위상정렬을 시도해 주시면 됩니다.  

먼저 큐에 진입차수가 0인 노드들을 모두 담습니다.  
이후 큐가 비어있지 않을 때 까지 아래의 과정을 반복합니다.   

- 큐에서 노드를 빼서 가져온다.
- 그래프에서 해당 노드에서 갈 수 있는 다른 노드들을 방문하며 진입차수를 낮춰준다. 
- 낮춘 진입차수가 0일경우 큐에 삽입해 준다.

이때 답을 출력 해야하므로 큐에서 노드를 빼면서 해당 노드를 출력해 주면됩니다.

```cpp
void line_up(vector<int>&inDegree, vector<vector<int>>&seq){
    int p;

    queue<int> que;
    for(int i = 1; i < inDegree.size(); ++i)
        if(inDegree[i] == 0)
            que.push(i);

    while(!que.empty()){
        p = que.front();
        que.pop();

        cout << p << " ";

        for(int i = 0; i < seq[p].size(); ++i){
            --inDegree[seq[p][i]];
            if(!inDegree[seq[p][i]])
                que.push(seq[p][i]);
        }
    }
}
```
