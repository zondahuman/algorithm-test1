package com.abin.lee.algorithm.test.basic.array;

/**
 * Created by abin on 2018/3/23 18:24.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.array
 * 求最大子数组之和的方法解析（2种可选）
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 * http://www.jb51.net/article/101025.htm
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
//        int[] total = new int[]{1, 2, 3, 4, 5};
        int[] total = new int[]{-2,2,-3,4,-1,2,1,-5,3};

//        int result1 = maxSubArraySumDp(total);
        int result1 = maxSubArraySumDp2(total);
        System.out.println("result1= " + result1);
        int result2 = maxSubArraySumConventional(total);
        System.out.println("result2= " + result2);
        int result3 = maxSubArraySumConventional(total);
        System.out.println("result3= " + result3);
    }

    /**
     * 常规实现 O(n^2)
     * @param param
     * @return
     */
    public static int maxSubArraySumConventional(int[] param){
        int current = 0;
        int max = 0;
        for (int i = 0; i <param.length ; i++) {
            current = param[i];
            for (int j = i+1; j <param.length ; j++) {
                current += param[j];
                if(current > max){
                    max = current ;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划实现 O(n)
     * @param params
     * @return
     */
    public static int maxSubArraySumDp(int[] params) {
        int current = params[0];
        int max = params[0];
        for (int i = 1; i < params.length; i++) {
            current = Math.max(current + params[i], params[i]);
            max = Math.max(current, max);
        }
        return max;
    }

    /**
     * 动态规划实现 O(n)
     * @param params
     * @return
     */
    public static int maxSubArraySumDp2(int[] params) {
        int current = 0;
        int max = 0;
        for (int i = 0; i < params.length; i++) {
            current = Math.max(current + params[i], params[i]);
            max = Math.max(current, max);
        }
        return max;
    }

    public static int greedyMaxSubSum(int[] param){
        int current = 0;
        int max = 0;
        for (int i = 0; i <param.length ; i++) {
            current += param[i];
            if(current > max)
                max = current;
            if(current < 0)
                current = 0;
        }
        return max;
    }



}
