#include <cstdio>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> sizes) {
    int w = 0, h = 0;
    for(int i = 0; i < sizes.size(); ++i){
        w = max(w, max(sizes[i][0], sizes[i][1]));
        h = max(h, min(sizes[i][0], sizes[i][1]));
    }
    return w * h;
}

int main(int argc, char const *argv[]){
    vector<vector<int>> sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
    printf("%d\n", solution(sizes));
    return 0;
}
