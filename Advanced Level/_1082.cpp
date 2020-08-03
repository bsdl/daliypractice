//
// Created by bsdl on 2020/6/26.
//

#include <iostream>

using namespace std;

string china_num[10] = { "ling", "yi", "er", "san", "si", "wu", 
                            "liu", "qi", "ba", "jiu" };

string china_carry[4] = { "", "Shi", "Bai", "Qian" };
bool isYi = false;
bool isTenThousand = false;
int main() {
    string num;
    cin >> num;
    bool isPositive = true;
    if (num.length() == 1 && num[0] == '0') {
        printf("ling");
        return 0;
    }
    if (num[0] == '-') {
        if (num.length() == 2 && num[1] == '0') {
            printf("ling");
            return 0;
        }
        cout << "Fu";
        isPositive = false;
        num = num.substr(1);
    }
    else if (num[0] == '+') {
        num = num.substr(1);
    }
    int idx = 0;
    int len = num.length();
    while (idx < len) {
        int cur_num = num[idx] - '0';
        int pos_from_high = len - 1 - idx;
        while (cur_num == 0) {         
            pos_from_high = len - 1 - idx;
            if (pos_from_high / 4 == 1 && pos_from_high % 4 == 0) {
                if (isTenThousand) {
                    printf(" Wan");
                }               
            } 
            else if (pos_from_high / 4 == 2) {
                cout << " " << "Yi";
            }
            idx++;
            cur_num = num[idx] - '0';
        }
        if (idx > 0 && idx != len && num[idx - 1] - '0' == 0 && pos_from_high % 4 != 0) {
            printf(" ling");
        }  
        if (isPositive && idx == 0) {
            cout << china_num[cur_num];
        }
        else {
            cout << " " << china_num[cur_num];
        }       
        pos_from_high = len - 1 - idx;
        int tmp = pos_from_high % 4;        
        if (tmp != 0) {
            cout << " " << china_carry[tmp];
            isTenThousand = true;         
        }
        else {
            
            if (pos_from_high / 4 == 1) {
                cout << " " << "Wan";
            }
            else if (pos_from_high / 4 == 2) {
                cout << " " << "Yi";
                isYi = true;
            }
        }
        idx++;
    }
    return 0;
}