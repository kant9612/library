#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    vector<string> grid(8);
    for (int i = 0; i < 8; ++i) {
        cin >> grid[i];
    }

    int safeCount = 0;

    for (int i = 0; i < 8; ++i) {
        for (int j = 0; j < 8; ++j) {
            if (grid[i][j] == '.') {
                bool rowSafe = true;
                bool colSafe = true;

                for (int k = 0; k < 8; ++k) {
                    if (grid[i][k] == '#') {
                        rowSafe = false;
                        break;
                    }
                }

                for (int k = 0; k < 8; ++k) {
                    if (grid[k][j] == '#') {
                        colSafe = false;
                        break;
                    }
                }

                if (rowSafe && colSafe) {
                    safeCount++;
                }
            }
        }
    }

    cout << safeCount << endl;

    return 0;
}
