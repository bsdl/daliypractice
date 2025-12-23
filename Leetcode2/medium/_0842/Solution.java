package medium._0842;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> fib = new ArrayList<>();
        helper(S, 0, fib);
        return fib;
    }

    private boolean helper(String S, int start, List<Integer> fib) {
        if (start == S.length() && fib.size() > 2) {
            return true;
        }
        for (int i = start; i < S.length(); i++) {
            String tmp = S.substring(start, i + 1);
            if (Long.parseLong(tmp) > Integer.MAX_VALUE) {
                break;
            }
            if ((tmp.charAt(0) == '0' && tmp.length() > 1)) {
                break;
            }
            int curFib = Integer.parseInt(tmp);
            if (fib.size() < 2) {
                fib.add(curFib);
                if (helper(S, i + 1, fib)) {
                    return true;
                }
                fib.remove(fib.size() - 1);
            } else {
                if (fib.get(fib.size() - 1) + fib.get(fib.size() - 2) == curFib) {
                    fib.add(curFib);
                    if (helper(S, i + 1, fib)) {
                        return true;
                    }
                    fib.remove(fib.size() - 1);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        var ss = solution.splitIntoFibonacci("5511816597");
        System.out.print(ss);
    }
}
