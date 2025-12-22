package com.bsdl.esay._0383;

import java.util.*;

class Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: ransomNote.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch: magazine.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }
        return map.isEmpty();
    }
}