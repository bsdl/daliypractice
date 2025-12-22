package com.bsdl.esay._0405;


class SoluConvert_a_Number_to_Hexadecimaltion {
    public String toHex(int num) { 
        char[] hexes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' , 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        int mask = 0b1111;
        for (int i = 28; i >= 0; i -= 4) {
            int index = (num >> i) & mask;
            if (sb.length() == 0) {
                if (index != 0) {
                    sb.append(hexes[index]);
                }
            }else {
                sb.append(hexes[index]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
   
    public static void main(String[] args) {
        SoluConvert_a_Number_to_Hexadecimaltion s = new SoluConvert_a_Number_to_Hexadecimaltion();
        String a = s.toHex(-4);
        System.out.print(a);

    }
}