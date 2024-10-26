#include <iostream>
#include <set>
#include <vector>
#include <utility>

using namespace std;

const int dx[8] = {2, 1, -1, -2, -2, -1, 1, 2};
const int dy[8] = {1, 2, 2, 1, -1, -2, -2, -1};

int main() {
    long long N;
    int M;
    cin >> N >> M;
    
    set<pair<int, int>> occupied;
    set<pair<int, int>> threatened;
    
    vector<pair<int, int>> pieces(M);
    for (int i = 0; i < M; ++i) {
        int a, b;
        cin >> a >> b;
        pieces[i] = {a, b};
        occupied.insert({a, b});
    }
    
    for (const auto& [x, y] : pieces) {
        for (int k = 0; k < 8; ++k) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                if (occupied.find({nx, ny}) == occupied.end()) {
                    threatened.insert({nx, ny});
                }
            }
        }
    }
    
    long long total_safe_cells = N * N - threatened.size() - occupied.size();
    cout << total_safe_cells << endl;
    
    return 0;
}
