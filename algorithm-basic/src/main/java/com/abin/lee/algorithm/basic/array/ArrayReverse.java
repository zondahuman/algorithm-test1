package com.abin.lee.algorithm.basic.array;


import com.abin.lee.algorithm.common.util.JsonUtil;

/**
 * Created by abin on 2018/3/23 16:38.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.array
 */
public class ArrayReverse {
    public static void main(String[] args) {
        int[] params = new int[]{1, 2, 3, 4, 5, 6};
        int[] result = reverse(params);
        System.out.println("rersult=" + JsonUtil.toJson(result));
    }

    public static int[] reverse(int[] params) {
        int temp = 0;
        for (int i = 0; i < params.length/2; i++) {
            temp = params[i];
            params[i] = params[params.length - i - 1];
            params[params.length - i - 1] = temp;
        }
        return params;
    }


}
