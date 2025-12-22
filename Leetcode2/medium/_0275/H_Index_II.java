package com.bsdl.medium._0275;

class H_Index_II {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 0) {
            return 0;
        }
        int left = 0, right = len - 1;
        int hIndex = Integer.MIN_VALUE;
        while(left <= right) {
            int mid = (left + right) >> 1;
            int num = len - mid;
            if(citations[mid] > num) {
                right = mid - 1;
            } else if(citations[mid] < num) {
                left = mid + 1;
            }
            hIndex = Math.max(hIndex, Math.min(num, citations[mid]));
            if(citations[mid] == num) {
                break;
            }
        }
        return hIndex;
    }

    public int integerReplacement(int n) {
        long longN = n;
        int times = 0;
        while(longN != 1) {
            if(longN == 3) {
                --longN;
            }else if((longN & 1) == 1) {               
                long tmp = longN >> 1;
                if((tmp & 1) == 1) {
                    ++longN;
                }else {
                    --longN;
                }
            }else {
                longN >>= 1;
            }
            ++times;
        }
        return times;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,4,6,7,8,9};
        H_Index_II h = new H_Index_II();
        h.integerReplacement(65535);
        h.hIndex(nums);
    }
}