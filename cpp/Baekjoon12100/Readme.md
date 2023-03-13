# (12100) 2048(Easy)
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/12100)

## 문제
2048 게임은 4×4 크기의 보드에서 혼자 즐기는 재미있는 게임이다. 이 [링크](https://gabrielecirulli.github.io/2048/)를 누르면 게임을 해볼 수 있다.

이 게임에서 한 번의 이동은 보드 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동시키는 것이다. 이때, 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다. 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다. (실제 게임에서는 이동을 한 번 할 때마다 블록이 추가되지만, 이 문제에서 블록이 추가되는 경우는 없다)

		
![그림1](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/1.png)<그림 1>	
![그림2](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/2.png)
<그림 2>	
![그림3](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/3.png)
<그림 3>  
<그림 1>의 경우에서 위로 블록을 이동시키면 <그림 2>의 상태가 된다. 여기서, 왼쪽으로 블록을 이동시키면 <그림 3>의 상태가 된다.

![그림4](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/4.png)		
<그림 4>	
![그림5](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/5.png)
<그림 5>	
![그림6](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/6.png)
<그림 6>	
![그림7](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/7.png)
<그림 7>  
<그림 4>의 상태에서 블록을 오른쪽으로 이동시키면 <그림 5>가 되고, 여기서 다시 위로 블록을 이동시키면 <그림 6>이 된다. 여기서 오른쪽으로 블록을 이동시켜 <그림 7>을 만들 수 있다.

	
![그림8](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/8.png)
<그림 8>	
![그림9](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/9.png)
<그림 9>   
<그림 8>의 상태에서 왼쪽으로 블록을 옮기면 어떻게 될까? 2가 충돌하기 때문에, 4로 합쳐지게 되고 <그림 9>의 상태가 된다.


![그림10](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/10.png)	
<그림 10>	
![그림11](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/11.png)
<그림 11>	
![그림12](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/12.png)
<그림 12>	
![그림13](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/13.png)
<그림 13>  
<그림 10>에서 위로 블록을 이동시키면 <그림 11>의 상태가 된다. 

<그림 12>의 경우에 위로 블록을 이동시키면 <그림 13>의 상태가 되는데, 그 이유는 한 번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없기 때문이다.

	
![그림14](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/14.png)
<그림 14>	
![그림15](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/15.png)
<그림 15>  
마지막으로, 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다. 예를 들어, 위로 이동시키는 경우에는 위쪽에 있는 블록이 먼저 합쳐지게 된다. <그림 14>의 경우에 위로 이동하면 <그림 15>를 만든다.

이 문제에서 다루는 2048 게임은 보드의 크기가 N×N 이다. 보드의 크기와 보드판의 블록 상태가 주어졌을 때, 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값을 구하는 프로그램을 작성하시오.

## 입력
첫째 줄에 보드의 크기 N (1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 게임판의 초기 상태가 주어진다. 0은 빈 칸을 나타내며, 이외의 값은 모두 블록을 나타낸다. 블록에 쓰여 있는 수는 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴이다. 블록은 적어도 하나 주어진다.

## 출력
최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력한다.

## 풀이
해당 문제의 경우 보드의 크기는 1~20으로 정해져 있고 최대 5번이라는 조건이 있으므로 브루스트 포스를 통해 문제를 해결 할 수 있습니다.  

우선 브루스트 포스를 시행하기 전에 생각해 보아야 할 점은 보드를 움직이고 나서 백트래킹으로 특정 칸을 이전과 같이 되돌릴 방법이 없다는 것입니다.  
그러므로 각 깊이마다 값을 저장할 수 있게 각 칸마다 6개의 공간을 가지고 있어야 합니다.  
6칸중 가장 앞 칸은 초기의 값을 담고 각 칸은 움직인 횟수에 해당하는 칸에 값을 넣어줍니다.  
아래는 초기 값을 설정하는 코드입니다.  

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    
    vector<vector<vector<int>>> board(n, vector<vector<int>>(n, vector<int>(6)));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
            cin >> board[r][c][0];
    
    cout << find_maximum(board, 0) << "\n";
    return 0;
}

```

모든 경우는 상하좌우 4가지이며 이에 대한 깊이를 생각하면 4x4x4x4x4 = 1,024 번의 재귀만 수행하면 됩니다.  
이를 재귀 코드로 짜면 아래와 같습니다.  

```cpp
int find_maximum(vector<vector<vector<int>>>&board, int depth){
    int res = 0;
    if(depth == 5){
        for(int r = 0; r < board.size(); ++r)
            for(int c = 0; c < board.size(); ++c)
                res = max(res, board[r][c][5]);

        return res;
    }

    res = max(res, move_up(board, depth+1));
    res = max(res, move_down(board, depth+1));
    res = max(res, move_right(board, depth+1));
    res = max(res, move_left(board, depth+1));

    return res;
}
```

움직였을 때의 겨우는 해당 줄의 0이 아닌 값을 큐에 넣습니다.  
그리고 움직인 방향을 끝 쪽 부터 하나씩 꺼내 넣습니다.  
이때 큐의 값이 2개 이상인 경우 하나를 넣고 큐에 남아 있는 값이 넣은 값과 같은 경우 합쳐지므로 값을 더해지고 큐에서 같은 값을 뺍니다.  
큐에 값이 하나만 있는 경우는 그냥 값을 빼서 넣어주고
큐에 더 이상 값이 없다면 나며지 칸은 0으로 채워 줍니다.  

위와 같은 과정을 상, 하, 좌, 우 방향에 맞게 구현해 주면 됩니다.  

```cpp
int move_up(vector<vector<vector<int>>>&board, int depth){
    for(int c = 0; c < board.size(); ++c){
        for(int r = 0; r < board.size(); ++r)
            if(board[r][c][depth-1])
                que.push(board[r][c][depth-1]);

        for(int r = 0; r < board.size(); ++r){
            if(que.size() > 1){
                board[r][c][depth] = que.front();
                que.pop();
                if(que.front() == board[r][c][depth]){
                    board[r][c][depth] += que.front();
                    que.pop();
                }
            }
            else if(que.size() == 1){
                board[r][c][depth] = que.front();
                que.pop();
            }
            else
                board[r][c][depth] = 0;
        }
    }

    return find_maximum(board, depth);
}
```

```cpp
int move_down(vector<vector<vector<int>>>&board, int depth){
    for(int c = 0; c < board.size(); ++c){
        for(int r = board.size()-1; r > -1; --r)
            if(board[r][c][depth-1])
                que.push(board[r][c][depth-1]);

        for(int r = board.size()-1; r > -1; --r){
            if(que.size() > 1){
                board[r][c][depth] = que.front();
                que.pop();
                if(que.front() == board[r][c][depth]){
                    board[r][c][depth] += que.front();
                    que.pop();
                }
            }
            else if(que.size() == 1){
                board[r][c][depth] = que.front();
                que.pop();
            }
            else
                board[r][c][depth] = 0;
        }
    }

    return find_maximum(board, depth);
}
```

```cpp
int move_right(vector<vector<vector<int>>>&board, int depth){
    for(int r = 0; r < board.size(); ++r){
        for(int c = board.size()-1; c > -1; --c)
            if(board[r][c][depth-1])
                que.push(board[r][c][depth-1]);

        for(int c = board.size()-1; c > -1; --c){
            if(que.size() > 1){
                board[r][c][depth] = que.front();
                que.pop();
                if(que.front() == board[r][c][depth]){
                    board[r][c][depth] += que.front();
                    que.pop();
                }
            }
            else if(que.size() == 1){
                board[r][c][depth] = que.front();
                que.pop();
            }
            else
                board[r][c][depth] = 0;
        }
    }
    
    return find_maximum(board, depth);
}
```

```cpp
int move_left(vector<vector<vector<int>>>&board, int depth){
    for(int r = 0; r < board.size(); ++r){
        for(int c = 0; c < board.size(); ++c)
            if(board[r][c][depth-1])
                que.push(board[r][c][depth-1]);

        for(int c = 0; c < board.size(); ++c){
            if(que.size() > 1){
                board[r][c][depth] = que.front();
                que.pop();
                if(que.front() == board[r][c][depth]){
                    board[r][c][depth] += que.front();
                    que.pop();
                }
            }
            else if(que.size() == 1){
                board[r][c][depth] = que.front();
                que.pop();
            }
            else
                board[r][c][depth] = 0;
        }
    }
    
    return find_maximum(board, depth);
}
```