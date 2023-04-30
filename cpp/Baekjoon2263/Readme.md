# (2263) 트리의 순회
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2263)
#
## 문제
n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다. 이와 같은 이진 트리의 인오더와 포스트오더가 주어졌을 때, 프리오더를 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 n(1 ≤ n ≤ 100,000)이 주어진다. 다음 줄에는 인오더를 나타내는 n개의 자연수가 주어지고, 그 다음 줄에는 같은 식으로 포스트오더가 주어진다.
#
## 출력
첫째 줄에 프리오더를 출력한다.
#
## 풀이
해당 문제는 아래의 트리 순회의 특성을 이용하여 풀 수 있는 문제입니다.  

1. PostOrder : 서브 트리에 대하여 root 노드를 마지막에 방문한다.  
2. InOrder : 서브 트리에 대하여 root 노드 기준으로 좌측 서브 트리와 우측 서브 트리를 분할 할 수 있다.
3. PreOder : 서브 트리에 대하여 root 노드 부터 방문한다.

우선 InOrder와 PostOrder에 대하여 입력을 받습니다.  

입력이 끝나면 재귀적으로 서브 트리에 대하여 아래의 과정을 반복합니다.  

1. 서브 트리의 루트를 PreOder에 추가합니다.  
2. PostOrder의 특성을 이용하여 InOrder의 서브트리의 root를 찾습니다.  
3. 해당 서브 트리에서 InOrder의 특성을 이용하여 다시 좌우 서브 트리를 나누 재귀를 실행합니다.  

해당 재귀의 종료조건은 해당 서브 트리를 다시 좌우로 나눌 수 없을 때까지 입니다.  

마지막으로 완성한 PreOder를 출력해 줍니다. 

```cpp
#include <iostream>
#include <vector>

using namespace std;

void preOrder(vector<int>&pre, vector<int>&in, vector<int>&post, int in_s, int in_e, int post_s, int post_e){
    if (in_s > in_e || post_s > post_e)
        return;

    pre.push_back(post[post_e]);

    int root, left_size;

    for(int i = in_s; i <= in_e; ++i)
        if(in[i] == post[post_e]){
            root = i;
            break;
        }

    left_size = root - in_s;

    preOrder(pre, in, post, in_s, root - 1, post_s, post_s + left_size - 1);
    preOrder(pre, in, post, root + 1, in_e, post_s + left_size, post_e - 1);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> pre;
    vector<int> in(n);
    vector<int> post(n);

    for(int i = 0; i < n; ++i)
        cin >> in[i];

    for(int i = 0; i < n; ++i)
        cin >> post[i];

    preOrder(pre, in, post, 0, n - 1, 0, n - 1);

    for(int i = 0; i < n; ++i)
        cout << pre[i] << " ";
    cout << "\n";
    return 0;
}
```