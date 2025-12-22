package com.bsdl.medium._0006;

class ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int startLap = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            int evenColLap = startLap - 2 * i;
            int oddColLap = startLap - evenColLap;
            if (i == numRows - 1 || i == 0) {
                evenColLap = startLap;
                oddColLap = startLap;
            }
            boolean isEven = true;
            for (int j = i; j < s.length(); ) {             
                sb.append(s.charAt(j));
                if (isEven) {
                    j += evenColLap;
                    isEven = false;
                }else {
                    j += oddColLap;
                    isEven = true;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        ZigZag_Conversion z = new ZigZag_Conversion();
        String res = z.convert("abcdefghijklm", 5);
        System.out.println(res);
    }
}