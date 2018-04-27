package com.abin.lee.algorithm.basic.string.common;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abin on 2018/4/28 1:03.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.string.common
 */
public class LongestNoRepeatingSubString {
    public static void main(String[] args) {
        String str3 = "ababcabcde";
//        Integer result = getMaxNoDuplicateSubString(str3);
        Integer result = findNoRepeatSub(str3);
        System.out.println("result=" + result);
    }

    public static int findNoRepeatSub(String params){
        int length = params.length();
        int i=0,j=0,total=0;
        Set<Character> set = new HashSet<Character>();
        while(i<length && j<length){
            if(!set.contains(params.charAt(j))){
                set.add(params.charAt(j++));
                total = Math.max(total, j-i);
            }else{
                set.remove(params.charAt(i++));
            }
        }
        return total;
    }
}
