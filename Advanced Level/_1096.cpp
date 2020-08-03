//
// Created by bsdl on 2020/6/26.
//

#include <iostream>
#include <cmath>


using namespace std;

int main() {
    int num;
    cin >> num;
    int max = 0;
    int firstNum = 0;
    for (int i = 2; i <= sqrt((double) num); i++) {
        if (num % i != 0) {
            continue;
        }
        int j = i;
        int tmp = 1;
        while (true) {
            tmp *= j;
            if (num % tmp != 0) {
                break;
            }
            if (j - i + 1 > max) {
                firstNum = i;
                max = j - i + 1;
            }
            j++;
        }
    }
    if (max == 0) {
        printf("1\n%d", num);
    } else {
        cout << max << endl;
        for (int i = 0; i < max; i++) {
            cout << firstNum;
            if (i != max - 1) {
                cout << "*";
            }
            firstNum++;
        }
    }
    return 0;
}