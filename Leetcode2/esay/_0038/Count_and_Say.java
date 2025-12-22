package com.bsdl.esay._0038;

class Count_and_Say {
    public String countAndSay(int n) {
        int start = 1;
        String curRes = "1";
        while (start < n) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < curRes.length(); ) {
                int j = i + 1;
                while (j < curRes.length() && curRes.charAt(j) == curRes.charAt(i)) {
                        j++;
                }
                String tmp = curRes.substring(i, j);
                res.append(String.valueOf(tmp.length()));
                res.append(curRes.charAt(i));
                i = j;
            }
            start++;
            curRes = res.toString();
        }
        return curRes;
    }
    public static void main(String args[]) {
        Count_and_Say s = new Count_and_Say();
        s.countAndSay(4);
    }
}