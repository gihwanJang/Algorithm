#include <cstdio>
#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    bool check[46] = {false,};
    int zeors = 0, wrong = 0;

    for(vector<int>::iterator it = win_nums.begin(); it != win_nums.end(); ++it)
        check[*it] = true;

    for(vector<int>::iterator it = lottos.begin(); it != lottos.end(); ++it){
        if(*it == 0) ++zeors;
        else if(!check[*it]) ++wrong;
    }

    answer.push_back(wrong < 6 ? wrong+1 : 6);
    answer.push_back(wrong + zeors < 6 ? wrong+zeors+1 : 6);
    //printf("%d %d\n", answer[0], answer[1]);
    return answer;
}

int main(int argc, char const *argv[]) {
    vector<int> lottos(6);
    vector<int> win_nums(6);

    for(int i = 0; i < 6; ++i)
        scanf("%d", &lottos[i]);
    for(int i = 0; i < 6; ++i)
        scanf("%d", &win_nums[i]);

    solution(lottos, win_nums);
    return 0;
}
