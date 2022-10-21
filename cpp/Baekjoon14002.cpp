#include <iostream>
#include <vector>

using namespace std;

struct route{
    int value, cnt = 0, prev = -1;
};

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> stack;
    int N, longestLength = 0, index = 0;
    cin >> N;

    vector<route> table(N);
    for(int i = 0; i < N; ++i){
        cin >> table[i].value;
        for(int j = 0; j < i; ++j)
            if(table[i].value > table[j].value)
                if(table[i].cnt < table[j].cnt + 1){
                    table[i].cnt = table[j].cnt + 1;
                    table[i].prev = j;
                }                
        if(longestLength < table[i].cnt){
            longestLength = table[i].cnt;
            index = i;
        }
    }
    
    while(true){
        if(index == -1) break;
        stack.push_back(table[index].value);
        index = table[index].prev;
    }

    cout << longestLength + 1 << "\n";
    while(!stack.empty()){
        cout << stack.back() << " ";
        stack.pop_back();
    }
    return 0;
}