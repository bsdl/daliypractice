package medium._0022;

import java.util.*;

class Generate_Parentheses {
    // public List<String> generateParenthesis(int n) {
    //     List<String> list = new LinkedList<String>();
    //     generatesAll(new char[2 * n], 0, list);
    //     return list;
    // }

    // public void generatesAll(char[] line, int pos, List<String> list) {
    //     if (pos == line.length) {
    //         if (valid(line)) 
    //             list.add(new String(line));
    //     }else {
    //         line[pos] = '(';
    //         generatesAll(line, pos + 1, list);
    //         line[pos] = ')';
    //         generatesAll(line, pos + 1, list);           
    //     }
    // }

    // public boolean valid(char[] line) {
    //     int balenced = 0;
    //     for (char c : line) {
    //         if (c == '(')
    //             balenced++;
    //         else
    //             balenced--;
    //         if (balenced < 0)
    //             return false;
    //     }
    //     return balenced == 0;
    // }

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generatesAll(res, n, 0, 0, "");
        return res;
    }

    public void generatesAll(List<String> res, int num, int left, int right, String line) {
        if (line.length() == num * 2)
            res.add(line);
        else {
            if (left < num) 
                generatesAll(res, num, left + 1, right, line + '(');
            if (right < left)
                generatesAll(res, num, left, right + 1, line + ')');
        }
        return;
    }
    
}