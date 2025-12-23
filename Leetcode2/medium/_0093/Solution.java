package medium._0093;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ipAddrs;

    public List<String> restoreIpAddresses(String s) {
        ipAddrs = new ArrayList<>();
        helper(s, "", 0, 0);
        return ipAddrs;
    }

    private void helper(String s, String ip, int start, int partNum) {
        if (start > s.length() || partNum > 4) {
            return;
        }
        if (start == s.length() && partNum == 4) {
            ipAddrs.add(ip);
        }
        for (int i = start + 1; i <= start + 3 && i <= s.length(); i++) {
            if (i - start > 1 && s.charAt(start) == '0') {
                return;
            }
            String part = s.substring(start, i);
            if (Integer.parseInt(s.substring(start, i)) <= 255) {
                String tmp = ip;
                tmp += part;
                tmp += (partNum == 3) ? "" : ".";
                helper(s, tmp, i, partNum + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> a;
        a = solution.restoreIpAddresses("25525511135");

        System.out.println(a);
    }
}
