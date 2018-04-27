package com.abin.lee.algorithm.basic.string.reverse;

/**
 * Created by abin on 2018/3/23 16:49.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.string
 */
public class StringReverse {

    public static void main(String[] args) {
        String input = "abcdef" ;
        String result = reverse(input);
        System.out.println("result = " + result);
        String result1 = rescureReverse(input);
        System.out.println("result1 = " + result1);
        String result2 = reverse1(input);
        System.out.println("result2 = " + result2);
    }

    public static String reverse(String param){
        char[] arr = param.toCharArray();
        char temp;
        for (int i = 0; i <arr.length/2 ; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        return new String(arr);
//        return param;
    }

    public static String rescureReverse(String param){
        if(param.length() == 1)
            return param;
        else
            return rescureReverse(param.substring(1)) + param.charAt(0);
    }

    public static String reverse1(String param){
        StringBuffer buffer = new StringBuffer();
        for (int i = param.length()-1; i >=0 ; i--) {
            buffer.append(param.charAt(i));
        }
        return buffer.toString();
    }



}
