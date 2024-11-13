#include <bits/stdc++.h>
using namespace std;

int main(void) {
	long long n;
	long long m = (long long)1 << 31;
	//long long m = 1 << 31; では右辺が (int)1<<31 として計算されるためオーバーフローし(=-(2 の31 乗)になります)、その値が long long 型に直され m に代入されてしまいます。
	//long long m = 2147483648; は問題ありません
	cin >> n;
	if ((-m <= n) && (n < m))cout << "Yes" << endl;
	else cout << "No" << endl;
	return 0;
}
