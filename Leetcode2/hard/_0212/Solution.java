package hard._0212;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordsIn = new ArrayList<>();
        for(String word: words) {
           if(exist(board, word)) {
               wordsIn.add(word);
           }
        }
        return wordsIn;
    }

    private boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length()) {
            return false;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int k) {
        if(k >= word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        board[i][j] -= 128;
        boolean res = search(board, word, i - 1, j, k + 1) || search(board, word, i, j + 1, k + 1) ||
                search(board, word, i + 1, j, k + 1) || search(board, word, i, j - 1, k + 1);
        board[i][j] += 128;
        return res;
    }

}
