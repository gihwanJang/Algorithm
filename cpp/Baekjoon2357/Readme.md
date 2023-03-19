# (2357) 최솟값과 최댓값
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2357)

## 문제
N(1 ≤ N ≤ 100,000)개의 정수들이 있을 때, a번째 정수부터 b번째 정수까지 중에서 제일 작은 정수, 또는 제일 큰 정수를 찾는 것은 어려운 일이 아니다. 하지만 이와 같은 a, b의 쌍이 M(1 ≤ M ≤ 100,000)개 주어졌을 때는 어려운 문제가 된다. 이 문제를 해결해 보자.

여기서 a번째라는 것은 입력되는 순서로 a번째라는 이야기이다. 예를 들어 a=1, b=3이라면 입력된 순서대로 1번, 2번, 3번 정수 중에서 최소, 최댓값을 찾아야 한다. 각각의 정수들은 1이상 1,000,000,000이하의 값을 갖는다.

## 입력
첫째 줄에 N, M이 주어진다. 다음 N개의 줄에는 N개의 정수가 주어진다. 다음 M개의 줄에는 a, b의 쌍이 주어진다.

## 출력
M개의 줄에 입력받은 순서대로 각 a, b에 대한 답을 최솟값, 최댓값 순서로 출력한다.

## 풀이
해당 문제의 경우 구간합을 선형검색을 통하여 탐색하여도 답을 찾을 수 는 있지만 O(N)의 시간이 걸립니다.  
하지만 [이전에 사용했던](https://velog.io/@gihwan319/BOJ-2042-구간-합-구하기) 세그먼트 트리를 사용하면 O(log N)의 시간 복잡도로 검색이 가능합니다.  
하지만 세그먼트 트리를 사용하면 선형 검색을 할때 보다 많은 공간을 사용하게 된다는 점도 알아두어야 합니다.  

우선 세그먼트 트리는 각 노드가 대푯 값을 가지는데 해당 문제에서의 대푯 값은 최대, 최소 값이 됩니다.  

세그먼트 트리의 경우 아래와 같이 작성 하였습니다.  

```cpp
class SegmentTree{
private:
    int size;
    int mode;
    vector<int> tree;

private:
    int buildRec(vector<int>&arr, int node, int l_node, int r_node);
    int queryRec(int l, int r, int node, int l_node, int r_node);

public:
    void build(int n, vector<int>&arr, int m);
    int query(int l, int r);
};
```

- size : 기존 배열의 크기
- mode : 1은 최소 세그먼트 트리, 0은 최대 세그먼트 트리
- tree : 이진 트리 형태의 세그먼트 트리

자세한 함수를 살펴 보겠습니다.  

```cpp
int SegmentTree::buildRec(vector<int>&arr, int node, int l_node, int r_node){
    if(l_node == r_node)
        return tree[node] = arr[l_node];
        
    int mid = l_node + (r_node - l_node) / 2;
    int l_val = buildRec(arr, node * 2, l_node, mid);
    int r_val = buildRec(arr, node * 2 + 1, mid + 1, r_node);

    return tree[node] = (mode ? min(l_val, r_val):max(l_val, r_val));
}

void SegmentTree::build(int n, vector<int>&arr, int m){
    size = n;
    tree.resize(size * 4);
    mode = m;

    buildRec(arr, 1, 0, size-1);
}
```

위의 함수는 세그먼트 트리를 초기화 하는 함수입니다.  

node는 세그먼트 트리의 노드 번호를 의미 하며 세그먼트 트리의 루트 노드는 1번 입니다.  
l_node는 원본 배열의 가장 왼쪽 인덱스를 주면 되며 r_node는 가장 오른쪽의 인덱스를 주면 됩니다.  
이때 l_node와 r_node가 같아지게 되면 단말 노드가 됩니다.  
이후 반씩 나눠가며 대푯값을 구해주면 됩니다.  
mod가 1이면 최소, 0이면 최대가 대푯값입니다.

```cpp
int SegmentTree::queryRec(int l, int r, int node, int l_node, int r_node){
    if(r < l_node || r_node < l)
        return mode ? 2000000000 : 0;

    if(l <= l_node && r_node <= r)
        return tree[node];

    int mid = l_node + (r_node - l_node) / 2;
    int l_val = queryRec(l, r, node*2, l_node, mid);
    int r_val = queryRec(l, r, node*2+1, mid+1, r_node);

    return (mode ? min(l_val, r_val):max(l_val, r_val));
}

int query(int l, int r){
    return queryRec(l, r, 1, 0, size-1);
}
```

위의 함수는 특정 범위의 대폿 값을 물었을 때 답하는 함수입니다.

우선 인덱스의 범위를 판별합니다.
만약 인덱스의 범위 밖에면 대폿값에 영향이 없는 값을 반환합니다.  
이후는 올라가며 대푯값들을 가지고 다시 대푯값을 만들어 값을 반환합니다.

최종적으로 아래와 같이 입력을 받아 실행시켜주면 됩니다.

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e;
    cin >> n >> m;

    vector<int> nums(n);
    for(int i = 0; i < n; ++i)
        cin >> nums[i];

    SegmentTree min_st;
    min_st.build(n, nums, 1);
    SegmentTree max_st;
    max_st.build(n, nums, 0);
    
    while(m--){
        cin >> s >> e;

        cout << min_st.query(s-1, e-1) << " " << max_st.query(s-1, e-1) << "\n";
    }
    return 0;
}
```