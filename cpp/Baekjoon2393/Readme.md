# (2393) Rook
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2393)
#
## 문제
You have just learned how to output text to the screen and your teacher has challenged you to create an ASCII art of a chess piece. You have decided to make your favorite piece, the rook.
#
## 출력
The rook art, exactly as shown below, with no extra blank spaces. In particular, a line must not end with a blank space.
#
## 풀이
이스케이프 시퀀스만 주의하며 출력

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);

    cout << "  ___  ___  ___" << "\n";
    cout << "  | |__| |__| |" << "\n";
    cout << "  |           |" << "\n";
    cout << "   \\_________/" << "\n";
    cout << "    \\_______/" << "\n";
    cout << "     |     |" << "\n";
    cout << "     |     |" << "\n";
    cout << "     |     |" << "\n";
    cout << "     |     |" << "\n";
    cout << "     |_____|" << "\n";
    cout << "  __/       \\__" << "\n";
    cout << " /             \\" << "\n";
    cout << "/_______________\\" << "\n";

    return 0;
}
```