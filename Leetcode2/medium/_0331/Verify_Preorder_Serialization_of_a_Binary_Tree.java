package medium._0331;

import java.util.Stack;

class Verify_Preorder_Serialization_of_a_Binary_Tree {
    public boolean isValidSerializatin(String preorder) {
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    if (stack.peek().equals("#")) {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                }
            }
            stack.push(strs[i]);          
        }
        if (stack.size() == 1 && stack.peek().equals("#")) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
      
    }
}