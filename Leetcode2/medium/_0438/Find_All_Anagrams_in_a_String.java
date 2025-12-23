package medium._0438;

import java.util.*;

class Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> mapP = new HashMap<Character, Integer>();
        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        List<Integer> res = new LinkedList<Integer>();
        int lenP = p.length();
        int lenS = s.length();
        for (char ch : p.toCharArray()) {
            mapP.put(ch, mapP.getOrDefault(ch, 0) + 1);
        }
        int matches = 0;
        int left = 0;
        for (int i = 0; i < lenS; ) {
            char ch = s.charAt(i);
            if (mapP.containsKey(ch)) {
                mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);
                if (mapS.get(ch).equals(mapP.get(ch)))
                    matches++;
            }
            i++;
            while (matches == mapP.size()) {
                if (i - left == lenP)
                    res.add(left);               
                char leftCh = s.charAt(left);
                if (mapP.containsKey(leftCh)) {
                    mapS.put(leftCh, mapS.get(leftCh) - 1);
                    if (mapP.get(leftCh) > mapS.get(leftCh))
                        matches--;
                }
                
                left++;
            }
        }
        return res;
    }
}