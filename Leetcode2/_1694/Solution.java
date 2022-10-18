package _1694;

public class Solution {
    public static String reformatNumber(String number) {
        StringBuilder builder = new StringBuilder();
        int i;
        for (i = 0; i < number.length(); i++) {
            if (number.charAt(i) == ' ' || number.charAt(i) == '-') {
                continue;
            }
            builder.append(number.charAt(i));
        }
        String num = builder.toString();
        if (num.length() <= 3) {
            return num;
        }
        String lastStr = "";    
        int last = num.length() % 3;
        if (last == 1) {
            lastStr = num.substring(num.length() - 2, num.length());
            num = num.substring(0, num.length() - 2);
        }
        builder = new StringBuilder();
        int cnt = 0;
        for (i = 0; i < num.length(); i++) {
            builder.append(num.charAt(i));
            cnt++;
            if (cnt == 3 && i != num.length() - 1) {
                builder.append("-");
                cnt = 0;
            }
        }
        if (lastStr.length() > 0) {
            builder.append("-").append(lastStr);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String res = Solution.reformatNumber("--17-5 229 35-39475 ");
        System.out.println(res);
    }
}
