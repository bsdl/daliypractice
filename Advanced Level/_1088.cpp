//
// Created by bsdl on 2020/6/23.
//

#include <iostream>
#include <cmath>

typedef long long ll;
using namespace std;

ll getGcd(ll a, ll b) {
    if (b == 0) {
        return a;
    }
    return getGcd(b, a % b);
}

string numToString(ll n, ll d) {
    if (d == 0) {
        return "Inf";
    }
    if (n == 0) {
        return "0";
    }
    string res;
    ll intergerPart = n / d;
    if (intergerPart == 0) {
        res = to_string(n) + "/" + to_string(d);
    } else {
        ll newN = abs(n) % d;
        if (newN == 0) {
            res = to_string(intergerPart);
        } else {
            res = to_string(intergerPart) + " " + to_string(newN) + "/" + to_string(d);
        }
    }
    if ((n < 0 && d > 0) || (n > 0 && d < 0)) {
        res = "(" + res + ")";
    }
    return res;
}

string getValue(ll n1, ll d1, ll n2, ll d2, char op) {
    string res;
    switch (op) {
        case '+': {
            ll d = d1 * d2;
            ll n = n1 * d2 + n2 * d1;
            ll gcd = getGcd(abs(n), abs(d));
            n /= gcd;
            d /= gcd;
            res = numToString(n, d);
            break;
        }
        case '-': {
            ll d = d1 * d2;
            ll n = n1 * d2 - n2 * d1;
            ll gcd = getGcd(abs(n), abs(d));
            n /= gcd;
            d /= gcd;
            res = numToString(n, d);
            break;
        }
        case '*': {
            ll d = d1 * d2;
            ll n = n1 * n2;
            ll gcd = getGcd(abs(n), abs(d));
            n /= gcd;
            d /= gcd;
            res = numToString(n, d);
            break;
        }
        case '/': {
            if (n2 < 0 && d2 > 0) {
                n2 = -n2;
                d2 = -d2;
            }
            ll d = d1 * n2;
            ll n = n1 * d2;
            if (d == 0) {
                res = "Inf";
                break;
            }
            if (n == 0) {
                res = "0";
                break;
            }
            ll gcd = getGcd(abs(n), abs(d));
            n /= gcd;
            d /= gcd;
            res = numToString(n, d);
            break;
        }
        default:
            break;
    }
    return res;
}

int main() {
    ll n1, d1, n2, d2;
    scanf("%lld/%lld %lld/%lld", &n1, &d1, &n2, &d2);
    if (n1 != 0) {
        ll gcd = getGcd(abs(n1), abs(d1));
        n1 /= gcd;
        d1 /= gcd;
    }
    if (n2 != 0) {
        ll gcd = getGcd(abs(n2), abs(d2));
        n2 /= gcd;
        d2 /= gcd;
    }
    string num1 = numToString(n1, d1), num2 = numToString(n2, d2);
    string sum = getValue(n1, d1, n2, d2, '+');
    cout << num1 << " + " << num2 << " = " << sum << endl;
    string diff = getValue(n1, d1, n2, d2, '-');
    cout << num1 << " - " << num2 << " = " << diff << endl;
    string product = getValue(n1, d1, n2, d2, '*');
    cout << num1 << " * " << num2 << " = " << product << endl;
    string quotient = getValue(n1, d1, n2, d2, '/');
    cout << num1 << " / " << num2 << " = " << quotient << endl;
    return 0;
}





