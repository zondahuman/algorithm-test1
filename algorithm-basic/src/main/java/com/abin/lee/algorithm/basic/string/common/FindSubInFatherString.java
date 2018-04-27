package com.abin.lee.algorithm.basic.string.common;

/**
 * Created by abin on 2018/4/27 22:20.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.string.common
 */
public class FindSubInFatherString {

    public static void main(String[] args) {
        boolean flag = findSub("abcdefgh", "cdef");
        System.out.println("flag=" + flag );
    }

    public static boolean findSub(String father, String sub) {
        int dad = father.length();
        int son = sub.length();
        int temp = 0;
        for (int i = 0; i <dad ; i++) {
            if(father.charAt(i) == sub.charAt(temp++)){
                if(temp == son)
                    return true;
            }else {
                temp = 0;
            }
        }
        return false;
    }







}