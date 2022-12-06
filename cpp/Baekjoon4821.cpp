#include <iostream>
#include <vector>
#include <sstream>
#include <unordered_set>

using namespace std;

vector<string> split(string input, char delimiter) {
    vector<string> ranges;
    stringstream ss(input);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        ranges.push_back(temp);
    }
 
    return ranges;
}

int countPage(int p, string range){
    unordered_set<int> set;
    vector<string> ranges = split(range, ',');

    for(int i = 0; i < ranges.size(); ++i){
        vector<string> pages = split(ranges[i], '-');

        if(pages.size() == 1){
            if(stoi(pages[0]) <= p)
                set.insert(stoi(pages[0]));
        }
        else{
            for(int low = stoi(pages[0]); low <= stoi(pages[1]); ++low)
                if(low <= p)
                    set.insert(low);
        }
    }

    return set.size();
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int p = -1;
    while(cin >> p){
        if(p == 0) break;

        string range;
        cin >> range;
        
        cout << countPage(p, range) << "\n";
    }

    return 0;
}
