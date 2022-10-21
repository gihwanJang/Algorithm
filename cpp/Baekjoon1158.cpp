#include <iostream>
#include <queue>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);

	int N, K;
	cin >> N >> K;
	
	queue<int>q;
	for (int i = 1; i <= N; ++i)
        q.push(i);

	cout << "<";

	while (q.size() > 1) {
		for (int i = 1; i < K; ++i) {
			int tmp = q.front();
			q.pop();
			q.push(tmp);
		}
		cout << q.front() << ", ";
		q.pop();
	}
	cout << q.front() << ">\n";
    return 0;
}


/*
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K;
    cin >> N >> K;
    
    list<int> l;
    for(int i = 1; i <= N; ++i)
        l.push_back(i);
    list<int>::iterator it = l.begin();
    
    cout << "<";
    while(!l.empty()){
        for (int i = 1; i < K; ++i)
            if (++it == l.end())
                it = l.begin();

        cout << *it;
        cout << (l.size() == 1 ? "" : ", ");

        it = l.erase(it);
        it = (it == l.end()) ? l.begin() : it;
    }
    cout << ">" << "\n";
    return 0;
}
*/