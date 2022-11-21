#include <iostream>
#include <list>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    list<int> cards;
    for(int i = 1; i <= N; ++i)
        cards.push_back(i);

    while(cards.size() > 1){
        int num = cards.front();
        cout << num << " ";
        cards.pop_front();
        num = cards.front();
        cards.pop_front();
        cards.push_back(num);
    }

    cout << cards.front() << "\n";
    return 0;
}
