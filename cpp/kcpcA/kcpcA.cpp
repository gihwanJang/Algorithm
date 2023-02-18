#include <iostream>
#include <vector>

using namespace std;

int n, k;
vector<vector<bool>> schedule(5, vector<bool>(11));

struct Class{
    int dayOfWeek;
    int start;
    int end;
};

int makeSchedule(vector<bool>&choice, vector<Class>&classes, int grades, int curr){
    if(grades >= k)
        return grades == k ? 1 : 0;

    int count = 0;

    for(int i = curr; i < n; ++i){
        if(choice[i]) continue;

        bool canChoice = true;
        for(int t = classes[i].start; t <= classes[i].end; ++t)
            if(classes[i].dayOfWeek == 5 || schedule[classes[i].dayOfWeek][t]){
                canChoice = false;
                break;
            }
        
        if(!canChoice) continue;

        choice[i] = true;
        for(int t = classes[i].start; t <= classes[i].end; ++t)
            schedule[classes[i].dayOfWeek][t] = true;
        
        count += makeSchedule(choice, classes, grades + (classes[i].end - classes[i].start + 1), i + 1);

        choice[i] = false;
        for(int t = classes[i].start; t <= classes[i].end; ++t)
            schedule[classes[i].dayOfWeek][t] = false;
    }
    
    return count;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> k;

    vector<bool> choice(n);
    vector<Class> classes(n);
    for(int i = 0; i < n; ++i)
        cin >> classes[i].dayOfWeek >> classes[i].start >> classes[i].end;

    cout << makeSchedule(choice, classes, 0, 0);
    return 0;
}

