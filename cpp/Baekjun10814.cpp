#include<iostream>
#include<algorithm>
using namespace std;

struct Member{
    int age, join;
    string name;
};

bool compare(const Member &u, const Member &v){
    if(u.age < v.age)
        return true;
    else if (u.age == v.age)
        return u.join < v.join;
    else
        return false;
}


int main(int argc, char const *argv[]){
    int n;
    printf("%d", &n);

    Member members[n];
    for(int i = 0; i < n; ++i){
        cin >> members[i].age >> members[i].name;
        members[i].join = i;
    }

    sort(members, members + n, compare);

    for(int i = 0; i < n; ++i)
        cout << members[i].age << " " << members[i].name << "\n";
        
    return 0;
}
