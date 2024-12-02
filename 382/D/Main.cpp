#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	vector<vector<int>> ans;
	auto dfs = [&](auto dfs, vector<int> v) -> void {
		int sz = v.size();
		if (sz == n) {
			ans.push_back(v);
			return;
		}
		for (int i = (sz == 0 ? 1 : v.back() + 10); i <= m - 10 * (n - sz - 1); i++) {
			vector<int> nxt = v;
			nxt.push_back(i);
			dfs(dfs, nxt);
		}
	};
	dfs(dfs, {});
	int X = ans.size();
	cout << X << '\n';
	for (int i = 0; i < X; i++) for (int j = 0; j < n; j++) cout << ans[i][j] << " \n"[j == n - 1];
}
