package com.bsdl.medium._0151;

class Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0;) {
            while (i >= 0 && s.charAt(i) == ' ') {
                --i;
            }
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            sb.append(s, j + 1, i + 1);
            sb.append(' ');
            i = j;
        }
        String backWards = sb.toString();
        int index = backWards.length() - 1;
        while (backWards.charAt(index) == ' ') {
            index--;
        }
        return backWards.substring(0, index + 1);
    }

    public static void main(String[] args) {
        // Reverse_Words_in_a_String r = new Reverse_Words_in_a_String();
        // String ss = r.reverseWords("a good   example");
    }
}