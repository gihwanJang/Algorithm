# (10845) 큐
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/10845)

## 문제
정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

- push X: 정수 X를 큐에 넣는 연산이다.
- pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- size: 큐에 들어있는 정수의 개수를 출력한다.
- empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
- front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

## 입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

## 출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

## 풀이
해당 문제는 그냥 내장 라이브러리를 사용하여 queue나 vector를 사용하면 편하게 풀 수 있는 문제입니다.  
하지만 그냥 풀면 재미가 없기 때문에 queue를 직접 구현하여 풀어보겠습니다.  
다만 템플릿을 이용하여 구현하기에는 너무 많은 시간을 요구하므로 자료형은 정수로 한정 시키겠습니다.

해당 큐는 Single Linked List로 구현해 보겠습니다.  

우선 값을 저장하는 노드를 구현하여야 합니다.  
해당 노드는 값과 다음 노드의 위치 정보를 가지고 있습니다.

```cpp
struct node{
    int value;
    node*next = NULL;
};
```

해당 노드가 구현 되었다면 실질적인 queue class를 구현하여야 합니다.  

```cpp
class queue{
private:
    int size_q;
    node* head;
    node* tail; 
public:
    queue();
    void push(int v);
    int pop();
    int size();
    bool empty();
    int front();
    int back();
};
```

- size_q : 큐의 사이즈입니다.
- head : 가장 앞의 노드입니다.
- tail : 가장 마지막 노드입니다. (굳이 가지고 있지 않아도 되지만 back() 연산시 O(1)에 접근하기 위해 지정)

우선 생성자 입니다.
각 값들은 기본 값으로 생성하면 됩니다.

```cpp
queue::queue(){
    size_q = 0;
    head = NULL;
    tail = NULL;
}
```

push 함수입니다.  
node의 메모리를 할당후 입력 값을 지정해 줍니다.  
이후 큐가 비어 있다면 해당 노드를 head로 지정해주고 아니면 tail뒤에 이어 붙이고 해당 node를 tail로 지정해 줍니다.  
큐 사이즈를 증가 시켜 줍니다.  

```cpp
void queue::push(int v){
    node*new_node = new node;
    new_node->value = v;

    if(size_q == 0)
        head = new_node;
    else
        tail->next = new_node;

    tail = new_node;
    ++size_q;
}
```

pop 함수입니다.  
뺄 값이 없으면 -1을 반환합니다.  
삭제할 노드를 head로 지정한 후 head를 옮겨주고 큐의 사이즈를 감소시킵니다.  
삭제할 노드의 메모리를 해제한 후 삭제한 노드의 값을 반환해 줍니다.

```cpp
int queue::pop(){
    if(!size_q) return -1;

    node*rm_node = head;
    int res = rm_node->value;

    head = rm_node->next;
    --size_q;

    delete rm_node;
    return res;
}
```
size() 함수입니다.  
큐사이즈를 그대로 반환해주면 됩니다. 

```cpp
int queue::size(){
    return size_q;
}
```

empty 함수입니다.  
큐사이즈가 0이면 참 아니면 거짓으로 반환해주면 됩니다.

```cpp
bool queue::empty(){
    return !size_q;
}
```

front 함수입니다.  
만약 큐 사이즈가 0이면 -1을 반환해 주고 아니면 head의 값을 반환해 주면 됩니다.   
(아 3항 연산자를 쓰면 1줄로 표현 가능합니다. 글 쓰다보니 그렇네요 ㅠㅠ)

```cpp
int queue::front(){
    if(!size_q) return -1;
    return head->value;
}
```
pop 함수입니다.  
만약 큐 사이즈가 0이면 -1을 반환해 주고 아니면 tail의 값을 반환해 주면 됩니다.  
(3항 연산자를 쓰면 1줄로 표현 가능합니다.)

```cpp
int queue::back(){
    if(!size_q) return -1;
    return tail->value;
}
```

마지막은 문제 풀이입니다.  
그대로 입력 받아 위에서 만든 함수들을 실행시켜주면 됩니다.  

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    queue que;

    int n, v;
    cin >> n;

    string s;
    while(n--){
        cin >> s;

        if(s == "push"){
            cin >> v;
            que.push(v);
        }
        else if(s == "pop")
            cout << que.pop() << "\n";
        else if(s == "size")
            cout << que.size() << "\n";
        else if(s == "empty")
            cout << que.empty() << "\n";
        else if(s == "front")
            cout << que.front() << "\n";
        else
            cout << que.back() << "\n";
    }
    return 0;
}
```