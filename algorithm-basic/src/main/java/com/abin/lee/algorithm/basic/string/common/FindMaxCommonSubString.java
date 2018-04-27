package com.abin.lee.algorithm.basic.string.common;

/**
 * Created by abin on 2018/4/27 17:21.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.string
 * 给定两个字符串，求长度最大的公共子串
 */
public class FindMaxCommonSubString {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str1 = "abcdefg";
        String str2 = "abdefg";
        String result = findMaxSub(str1, str2);
        System.out.println("result: " + result);
    }

    public static String findMaxSub(String param1, String param2){
        String min = param1.length() >= param2.length() ?  param2 : param1;
        String max = param1.length() < param2.length() ?  param2 : param1;
        for (int i = 0; i <min.length() ; i++) {
            // 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
            for (int start = 0, end=min.length()-i; end <= min.length() ; start++,end++) {
                String sub = min.substring(start, end);
                if(max.contains(sub)){
                    return sub;
                }
            }
        }
        return "";
    }




}
