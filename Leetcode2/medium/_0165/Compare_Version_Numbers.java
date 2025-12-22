package com.bsdl.medium._0165;

class Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        // . 必须得加转义字符\\
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index1 = 0, index2 = 0;
        while (index1 < v1.length && index2 < v2.length) {
            if (Integer.valueOf(v1[index1]) == Integer.valueOf(v2[index2])) {
                index1++;  
                index2++;
            } else {
                if (Integer.valueOf(v1[index1]) > Integer.valueOf(v2[index2])) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        while (index1 < v1.length) {
            if (Integer.valueOf(v1[index1]) != 0) {
                return 1;
            }
            index1++;
        }
        while (index2 < v2.length) {
            if (Integer.valueOf(v2[index2]) != 0) {
                return -1;
            }
            index2++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.0";
        String v2 = "1.0.0";
        Compare_Version_Numbers v = new Compare_Version_Numbers();
        int flag = v.compareVersion(v1, v2);
        System.out.println(flag);
    }
}