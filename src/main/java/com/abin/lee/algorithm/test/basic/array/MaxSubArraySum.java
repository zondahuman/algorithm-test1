package com.abin.lee.algorithm.test.basic.array;

/**
 * Created by abin on 2018/3/23 18:24.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.array
 * 求最大子数组之和的方法解析（2种可选）
 *  给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 * http://www.jb51.net/article/101025.htm
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] total = new int[]{1,2,3,4,5};
        int result1 = subArraySum(total);
        System.out.println("result1= " + result1);
        int result2 = maxSubArray1(total);
        System.out.println("result2= " + result2);
    }

    public static int subArraySum(int[] params){
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < params.length ; i++) {
            for (int j = 0; j <= i ; j++) {
                thisSum += params[i] ;
                if(thisSum > maxSum){
                    maxSum = thisSum ;
                }
            }
        }

        return maxSum;
    }


    public static int maxSubArray1(int[] a){
        int i,j;
        int ThisSum=0;
        int MaxSum=0;
        for (i = 0; i < a.length; i++) {
            ThisSum=a[i];
            for(j=i+1;j<a.length;j++){
                ThisSum+=a[j];
                if(ThisSum>MaxSum){
                    MaxSum=ThisSum;
                }
            }
        }
        return MaxSum;
    }


}
