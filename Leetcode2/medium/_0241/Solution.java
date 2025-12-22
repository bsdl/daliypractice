package com.bsdl.medium._0241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> result = new ArrayList<>();
        if (input.length() == 0) {
            return result;
        }
        int num = 0;
        int index = 0;
        while (index < input.length() &&
                !(input.charAt(index) == '+' || input.charAt(index) == '-' || input.charAt(index) == '*')) {
            num = num * 10 + (input.charAt(index) - '0');
            index++;
        }
        if (index == input.length()) {
            result.add(num);
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(index) == '+' || input.charAt(index) == '-' || input.charAt(index) == '*') {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                for (Integer value : result1) {
                    for (Integer integer : result2) {
                        int res = -1;
                        switch (input.charAt(i)) {
                            case '+':
                                res = value + integer;
                                break;
                            case '-':
                                res = value - integer;
                                break;
                            case '*':
                                res = value * integer;
                                break;
                        }
                        result.add(res);
                    }
                }
            }
        }
        map.put(input, result);
        return result;
    }
}
