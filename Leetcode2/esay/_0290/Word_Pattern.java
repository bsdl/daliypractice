package com.bsdl.esay._0290;

import java.util.*;

class Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        Set<String> hashset = new HashSet<>();
        if(strs.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(strs[i].equals(map.get(pattern.charAt(i)))) {
                    continue;
                }else {
                    return false;
                }
            }else {
                map.put(pattern.charAt(i), strs[i]);
                hashset.add(strs[i]);
            }
        }
        
        return map.size() == hashset.size();
    }
}