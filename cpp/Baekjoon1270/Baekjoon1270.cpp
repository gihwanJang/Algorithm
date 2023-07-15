#include <unordered_map>
#include <iostream>


using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    while(n--)
    {
        bool flag = true;
        int t;
        long army;
        unordered_map<long,int> map;
        
        cin >> t;
        
        for(int i = 0; i < t; ++i)
        {
            cin >> army;

            if(map.count(army))
                ++map.find(army)->second;
            else
                map.insert({army, 1});
        }

        for(pair<long,int> a : map)
            if(double(t) / 2 < a.second)
            {
                cout << a.first << "\n";
                flag = false;
                break;
            }

        if(flag)
            cout << "SYJKGW\n";
    }
    return 0;
}
