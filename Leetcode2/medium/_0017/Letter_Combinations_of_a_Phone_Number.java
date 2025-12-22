package com.bsdl.medium._0017;

import com.bsdl.medium._0229.Solution;

import java.util.*;

class Letter_Combinations_of_a_Phone_Number {
    
    
    // public List<String> letterCombinations(String digits) {
    //     List<String> res = new LinkedList<String>();
    //     Map<String, String> collection = new HashMap<String, String>(){/**
    //         *
    //         */
    //        private static final long serialVersionUID = 1L;
    
    //     {           
    //             put("0", " ");
    //             put("1", "*");
    //             put("2", "abc");
    //             put("3", "def");
    //             put("4", "ghi");
    //             put("5", "jkl");
    //             put("6", "mno");
    //             put("7", "pqrs");
    //             put("8", "tuv");
    //             put("9", "wxyz");
    //     }};
    //     generatesAll("", digits);       
    //     return res;
    // }

    // public void generatesAll(String combination, String digits) {
    //     if (digits.length() == 0)
    //         res.add(combination);
    //     else {
    //         String digit = digits.substring(0, 1);
    //         String letters = collection.get(digit);
    //         for (int i = 0; i < letters.length(); i++) {
    //             String letter = letters.substring(i, i + 1);
    //             generatesAll(combination + letter, digits.substring(1));
    //         }
    //     }
    // }
    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if (digits.length() > 0) {
            dfs(digits, "", map, ans);
        }
        return ans;
    }

    private void dfs(String digits, String combine, Map<String, String> map, List<String> ans) {
        if (digits.length() == 0) {
            ans.add(combine);
            return;
        }
        String digit = digits.substring(0, 1);
        String letters = map.get(digit);
        for (char letter: letters.toCharArray()) {
            dfs(digits.substring(1), combine + letter, map, ans);
        }
    }

    public static void main(String[] args) {
        Letter_Combinations_of_a_Phone_Number solution = new Letter_Combinations_of_a_Phone_Number();
        solution.letterCombinations("23");
    }
}

