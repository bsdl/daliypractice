package esay._0299;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        StringBuilder sb = new StringBuilder();
        int[] s = new int[10];
        int[] g = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            s[secret.charAt(i) - '0']++;
            g[guess.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(s[i], g[i]);
        }
        sb.append(bulls).append('A').append(cows - bulls).append('B');
        return sb.toString();
    }
}
