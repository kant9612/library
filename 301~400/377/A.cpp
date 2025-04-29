#include <iostream>
#include <algorithm>
#include <string>

int main() {
    std::string S;
    std::cin >> S;
    
    // Sort the string
    std::sort(S.begin(), S.end());
    
    // Check if sorted string is "ABC"
    if (S == "ABC") {
        std::cout << "Yes" << std::endl;
    } else {
        std::cout << "No" << std::endl;
    }
    
    return 0;
}
