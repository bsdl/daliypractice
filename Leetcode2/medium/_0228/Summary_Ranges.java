package com.bsdl.medium._0228;

import java.util.*;

class Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new LinkedList<>();
        int index = 0;
        while(index < nums.length) {
            int startIndex = index;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(nums[index++]) + "->");         
            while(index < nums.length && nums[index] - nums[index - 1] == 1) {
                index++;
            }
            if(nums[index - 1] != nums[startIndex]) {
                sb.append(String.valueOf(nums[index - 1]) + "->");
            }      
            sb.delete(sb.length() - 2, sb.length());
            ranges.add(sb.toString());
        }
        return ranges;
    }

    public static void main(String[] args) {
        Summary_Ranges s = new Summary_Ranges();
        s.summaryRanges(new int[]{0,1,2,4,5,7});
        
    }
}