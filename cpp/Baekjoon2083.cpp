#include <iostream>

using namespace std;

struct member{
    string name;
    int age, weight;
};

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    member m;

    while(true){
        cin >> m.name >> m.age >> m.weight;
        if(m.name == "#" && m.age == 0 && m.weight == 0)
            break;

        cout << m.name << " " << (m.age > 17 || m.weight >= 80 ? "Senior" : "Junior") << "\n";
    }
    return 0;
}
