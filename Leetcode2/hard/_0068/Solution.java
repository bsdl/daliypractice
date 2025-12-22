package com.bsdl.hard._0068;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> text = new ArrayList<>();
        int cur = 0;
        int curStart = cur;
        while (cur < words.length) {
            // 每次循环添加一行
            StringBuilder line = new StringBuilder();
            // 以下是为了判断这一行应该添加几个词，如果多添加了或是最后一行就跳出
            int lineLen = 0;
            int charLen = 0;
            while (lineLen - 1 < maxWidth) {
                lineLen += words[cur].length() + 1;
                charLen += words[cur].length();
                cur++;
                if (cur == words.length) {
                    break;
                }
            }
            // 如果是最后一行，即词数不够填满一行或者当前加入的词正好够一行
            if (lineLen - 1 <= maxWidth) {
                for (int i = curStart; i < cur; i++) {
                    line.append(words[i]);
                    if (i == cur - 1) {
                        break;
                    }
                    line.append(" ");
                }
                line.append(" ".repeat(maxWidth - line.length()));
            } else {
                // 如果加入的词超了一个，则减去当前加入的词，之后分3种情况
                charLen -= words[--cur].length();
                int wordsNum = cur - curStart;
                // 如果本行词数为1
                if (wordsNum == 1) {
                    line.append(words[curStart]);
                    line.append(" ".repeat(maxWidth - charLen));
                    // 如果本行词数为2，将两词放在开头和结尾
                } else if (wordsNum == 2) {
                    line.append(words[curStart++]);
                    line.append(" ".repeat(maxWidth - charLen));
                    line.append(words[curStart]);
                    // 如果本行词数大于2
                } else {
                    int spaceLen = (maxWidth - charLen) / (wordsNum - 1);
                    int extra = (maxWidth - charLen) % (wordsNum - 1);
                    for (int i = curStart; i < cur; i++) {
                        line.append(words[i]);
                        if (i == cur - 1) {
                            break;
                        }
                        line.append(" ".repeat(spaceLen));
                        if (extra > 0) {
                            line.append(" ");
                            extra--;
                        }
                    }
                }
            }
            curStart = cur;
            text.add(line.toString());
        }
        return text;
    }
}
