# (2042) 구간 합 구하기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2042)

## 문제
어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 만약에 1,2,3,4,5 라는 수가 있고, 3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다. 그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.

## 입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다. 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데, a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.

입력으로 주어지는 모든 수는 -2^63보다 크거나 같고, 2^63-1보다 작거나 같은 정수이다.

## 출력
첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력한다. 단, 정답은 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.

## 풀이
해당 문제의 경우 주어진 구간의 합을 구하면 되는 문제이지만 주어진 배열의 값이 변한다는 조건이 있어 누적합으로 해결 할 수 없습니다.  

그러므로 해당문제의 경우는 세그먼트 트리 자료구조를 이용하여야 해결할 수 있습니다.  

```cpp
class SegmentTree{
private:
    int size;
    vector<long> tree;

private:
    long merge(long l, long r);
    long buildRec(vector<long>&arr, int node, int l_node, int r_node);
    long updateRec(int idx, long new_val, int node, int l_node, int r_node);
    long queryRec(int l, int r, int node, int l_node, int r_node);
public:
    void build(vector<long>&arr, int n);
    void update(int idx, long new_val);
    long query(int l, int r);
};
```

세그먼트 트리의 자료구조는 위와 같이 나타낼 수 있습니다.  

자세한 함수의 내부를 보기전 간략하게 세그먼트 트리에 대하여 정리해 보겠습니다.  
이진 트리의 형식으로 부모 노드는 하위 두 노드의 대표하는 값을 가지는 트리입니다.(해당 문제에서는 대푯값은 두 노드의 합입니다.)  
해당 자료구조는 트리의 이름을 가지고 있기는 하지만 이진 트리이므로 배열로 구현이 가능합니다.  

그럼 함수 코드를 보며 자세히 살펴보겠습니다.  

```cpp
long SegmentTree::buildRec(vector<long>&arr, int node, int l_node, int r_node){
    if(l_node == r_node)
        return tree[node] = arr[l_node];
        
    int mid = l_node + (r_node - l_node) / 2;
    long l_val = buildRec(arr, node * 2, l_node, mid);
    long r_val = buildRec(arr, node * 2 + 1, mid + 1, r_node);

    return tree[node] = merge(l_val, r_val);
}


void SegmentTree::build(vector<long>&arr, int n){
    size = n;
    tree.resize(size * 4);

    buildRec(arr, 1, 0, size - 1);
}
```

위의 함수는 세그먼트 트리를 초기화 하는 함수입니다.  
node는 세그먼트 트리의 노드 번호를 의미 하며 세그먼트 트리의 루트 노드는 1번 입니다.  
l_node는 원본배열의 가장 왼쪽 인덱스를 주면 되며 r_node는 가장 오른쪽의 인덱스를 주면 됩니다.  
이때 l_node와 r_node가 같아지게 되면 단말 노드가 됩니다.  
이후 반씩 나눠가며 대푯값을 구해주면 됩니다.  
```
<부가 설명>
- l_node + (r_node - l_node) / 2 는 (r_node + l_node) / 2 와 동일하지만 오버플로우를 방지할 수 있음
- 배열에서 노드의 자식 인덱스는 왼쪽 자식은 node * 2 오른쪽 자식은 node * 2 + 1 임
```

```cpp
long SegmentTree::updateRec(int idx, long new_val, int node, int l_node, int r_node){
    if(idx < l_node || r_node < idx)
        return tree[node];

    if(l_node == r_node)
        return tree[node] = new_val;

    int mid = l_node + (r_node - l_node) / 2;
    long l_val = updateRec(idx, new_val, node * 2, l_node, mid);
    long r_val = updateRec(idx, new_val, node * 2 + 1, mid + 1, r_node);
    return tree[node] = merge(l_val, r_val);
}

void SegmentTree::update(int idx, long new_val){
    updateRec(idx, new_val, 1, 0, size - 1);
}
```

위의 함수는 세그먼트 트리를 갱신하는 함수입니다.  
원본 배열의 값이 바뀌면 해당 배열의 인덱스 단말 노드의 부모의 값들 또한 모두 바뀌어야합니다.  

우선 인덱스의 범위를 판별해 줍니다.  
만약 인덱스가 해당 되지 않는 노드에 포함되어 있다면 기존의 값을 그대로 가져가면 됩니다.  
단말(l_node == r_node)이 인덱스 내부면 값을 갱신 해주고 이후는 올라가며 부모 노드의 값을 갱신합니다.  

```cpp
long SegmentTree::queryRec(int l, int r, int node, int l_node, int r_node){
    if(r < l_node || r_node < l)
        return 0;

    if(l <= l_node && r_node <= r)
        return tree[node];

    int mid = l_node + (r_node - l_node) / 2;
    return merge(queryRec(l, r, node*2, l_node, mid), queryRec(l, r, node*2+1, mid+1, r_node));
}

long SegmentTree::query(int l, int r){
    return queryRec(l, r, 1, 0, size - 1);
}
```

위의 함수는 특정 범위의 대폿 값을 물었을 때 답하는 함수입니다.  

우선 인덱스의 범위를 판별합니다.  
만약 인덱스의 범위 밖에면 0을 반환하고 내부이면 노드의 값을 반환합니다.  
이후는 올라가며 대푯값들을 가지고 다시 대푯값을 만들어 값을 반환합니다.  

최종적으로 아래와 같이 입력을 받아 실행시켜주면 됩니다.  

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, k, command;
    long a, b;
    cin >> n >> m >> k;

    vector<long> arr(n);
    for(int i = 0; i < n; ++i)
        cin >> arr[i];

    SegmentTree st;
    st.build(arr, n);

    for(int i = 0; i < m+k; ++i){
        cin >> command >> a >> b;

        if(command == 1)
            st.update(a-1, b);
        else
            cout << st.query(a-1, b-1) << "\n";
    }

    return 0;
}
```