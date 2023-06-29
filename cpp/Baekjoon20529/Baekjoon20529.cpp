#include <unordered_map>
#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

void calculateDistance(vector<vector<int>>&distance, vector<string>&mbti_label)
{
    for(int r = 0; r < 16; ++r)
        for(int c = 0; c < 16; ++c)
            for(int i = 0; i < 4; ++i)
                if(mbti_label[r][i] != mbti_label[c][i])
                    ++distance[r][c];
}

int getClosestDistance(vector<int>&mbti_count, vector<vector<int>>&distance,  vector<int>&choice)
{   
    if(choice.size() == 3)
        return distance[choice[0]][choice[1]] + distance[choice[0]][choice[2]] + distance[choice[1]][choice[2]];

    int res = 1234567891;

    for(int i = 0; i < 16; ++i)
        if(mbti_count[i])
        {
            --mbti_count[i];
            choice.push_back(i);
            res = min(res, getClosestDistance(mbti_count, distance, choice));
            choice.pop_back();
            ++mbti_count[i];
        }

    return res;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    unordered_map<string, int> MBTI_TABLE = {
        {"INFJ", 0}, {"INFP", 1},{"ISFJ", 2},{"ISFP", 3},
        {"ISTP", 4},{"ISTJ", 5},{"INTP", 6},{"INTJ", 7},
        {"ENTP", 8},{"ESTJ", 9},{"ESTP", 10},{"ENFP", 11},
        {"ESFJ", 12},{"ENTJ", 13},{"ENFJ", 14},{"ESFP", 15},
    };
    vector<string> mbti_label = {
        "INFJ", "INFP", "ISFJ", "ISFP",
        "ISTP", "ISTJ", "INTP", "INTJ",
        "ENTP", "ESTJ", "ESTP", "ENFP",
        "ESFJ", "ENTJ", "ENFJ", "ESFP"
    };
    vector<vector<int>> distance(16,vector<int>(16));
    calculateDistance(distance, mbti_label);

    while(T--)
    {
        int n, ans = 1234567891;
        cin >> n;

        string s;
        vector<int> mbti_count(16);
        for(int i = 0; i < n; ++i)
        {
            cin >> s;
            ++mbti_count[MBTI_TABLE.at(s)];
        }

        vector<int> choice;
        cout << getClosestDistance(mbti_count, distance, choice) << "\n";
    }
    return 0;
}
