#include <iostream>
#include <vector>

using namespace std;

void manDoing(vector<int>&switches, int num){
    for(int i = num - 1; i < switches.size(); i += num)
        switches[i] = !switches[i];
}

void womanDoing(vector<int>&switches, int num){
    int start = num - 2, end = num;
    switches[num - 1] = !switches[num - 1];
    for(; start >= 0 && end < switches.size() && switches[start] == switches[end]; --start, ++end){
        switches[start] = !switches[start];
        switches[end] = !switches[end];
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    
    vector<int> switches(N);
    for(int i = 0; i < N; ++i){
        cin >> switches[i];
    }
    
    cin >> N;
    while(N--){
        int sex, num;
        cin >> sex >> num;
        
        if(sex == 1) manDoing(switches, num);
        else womanDoing(switches, num);   
    }

    for(int i = 0; i < switches.size(); ++i){
        cout << (switches[i] ? 1 : 0) << " ";
        if((i+1) % 20 == 0) cout << "\n";
    }

    return 0;
}
