#include<iostream>
#include<set>
using namespace std;

struct sorting {
	bool operator() (const string& a, const string& b) const {
		if (a.size() == b.size())
			return a < b;
		else
			return a.size() < b.size();
	}
};

int main(int argc, char const *argv[]){
    int n;
    string word;
    scanf("%d", &n);
    set<string, sorting> words;
    
    for(int i = 0; i < n; ++i){
        cin>>word;
        words.insert(word);
    }

    for(set<string>::iterator it = words.begin(); it != words.end(); ++it)
        cout << *it << endl;
    return 0;
}