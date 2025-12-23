package esay._0205;

import java.util.*;

class Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicForOneDirec(s, t) && 
                isIsomorphicForOneDirec(t, s);
    }

    public boolean isIsomorphicForOneDirec(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if(!map.containsKey(chs)) {
                map.put(chs, cht);
            }else {
                if(map.get(chs) != cht) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Isomorphic_Strings i = new Isomorphic_Strings();
        i.isIsomorphic("ab", "aa");
    }
}