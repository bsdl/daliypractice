package com.bsdl.medium._0187;

import java.util.*;

class Repeated_DNA_Sequences {
    // public List<String> findRepeatedDnaSequences(String s) {
    //     Set<String> strings = new HashSet<>();
    //     int len = s.length();
    //     for(int i = 0; i <= len - 10; i++) {
    //         for(int j = i + 1; j < len - 10; j++) {
    //             if(s.substring(i, i + 10).equals(s.subSequence(j, j + 10))) {
    //                 strings.add(s.substring(i, i + 10));    
    //                 break;
    //             }
    //         }
    //     }
    //     return new LinkedList<>(strings);
    // }
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        List<String> strings = new LinkedList<>();
        // int a = 0b11111111111111111111;
        byte[] bytes = new byte[1 << 20];
        return strings;   
    }



    public static void main(String[] args) {
        Repeated_DNA_Sequences r = new Repeated_DNA_Sequences();
        r.findRepeatedDnaSequences("asdadadsadsa");
    }
}