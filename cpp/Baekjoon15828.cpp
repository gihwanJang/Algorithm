#include <iostream>
#include <queue>

using namespace std;
 
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int capacity, packet;
    cin >> capacity;

    queue<int> que;
    while(true){
        cin >> packet;
        if(packet == -1) break;
        
        if(packet == 0)
            que.pop();
        else if(que.size() < capacity)
            que.push(packet);
    }

    if(que.empty()){
        cout << "empty" << "\n";
        return 0;
    }

    while(!que.empty()){
        cout << que.front() << "\n";
        que.pop();
    }
    return 0;
}
