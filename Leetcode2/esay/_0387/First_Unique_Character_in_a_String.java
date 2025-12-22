package com.bsdl.esay._0387;

class First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int[] map = new int[256];
        for (char ch : s.toCharArray()) {
            map[ch]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}