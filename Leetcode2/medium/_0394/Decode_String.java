package medium._0394;

import java.util.Stack;

class Decode_String {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ']') {
                String str = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    str = stack.pop() + str;
                }
                stack.pop();
                int times = Integer.valueOf(stack.pop());
                String subStr = str.toString();
                for (int j = 0; j < times - 1; j++) {
                    str += subStr;
                }
                stack.push(str.toString());
                i++;
            }else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                StringBuilder num = new StringBuilder();
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num.append(s.charAt(i));
                    i++;
                }
                stack.push(num.toString()); 
            }else {
                stack.push(s.substring(i, i + 1));
                i++;
            }           
        }
        while (!stack.empty()) {
            result = stack.pop() + result; 
        }
        return result;
    }

    public static void main(String args[]) {
        String s = "2[abc]3[cd]ef";
        Decode_String d = new Decode_String();
        String res = d.decodeString(s);
        res.length();
        // String ss = "[";
        // boolean a = ss != "[";
        // Stack<String> ss = new Stack<>();
        // ss.push("a");
        // ss.push("[");
        // boolean a = ss.peek() != "a";
        // boolean b = ss.peek() != "[";
    }
}