package medium._0166;

import java.util.*;

class Fraction_to_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        try {
            StringBuilder str = new StringBuilder();
            Map<Long, Integer> map = new HashMap<>(); 
            if (numerator < 0 ^ denominator< 0) {
                str.append("-");
            }
            // 添加整数部分            
            long up = Math.abs(Long.valueOf(numerator));
            long down = Math.abs(Long.valueOf(denominator));
            str.append(String.valueOf(up / down));
            long remainder = up % down;
            if (remainder == 0)
                return str.toString();
            str.append(".");
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    str.insert(map.get(remainder), "(");
                    str.append(")");
                    break;
                }else {
                    map.put(remainder, str.length());
                    up = remainder * 10;
                    str.append(String.valueOf(up / down));
                    remainder = up % down;                    
                }
            }
            return str.toString();
        } catch (ArithmeticException e) {
            System.out.println(e);
            return "";
        }
    }
    public static void main(String args[]) {
    }
}