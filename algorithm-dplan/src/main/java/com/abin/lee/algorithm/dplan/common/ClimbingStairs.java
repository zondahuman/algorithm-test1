package com.abin.lee.algorithm.dplan.common;

/**
 * Created by abin on 2018/4/29 12:44.
 * algorithm-test1
 * com.abin.lee.algorithm.dplan.common
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int result = climbStairs(5);
        System.out.println("result=" + result);
        int climbStairsDp = climbStairsDp(5);
        System.out.println("climbStairsDp=" + climbStairsDp);
    }

    public static int climbStairsDp(int n){
        if (n == 1) {
            return 1;
        }
        int[] cb = new int[n+1];
        cb[1] = 1;
        cb[2] = 2;
        for (int i = 3; i <=n ; i++) {
            cb[i] = cb[i-1] + cb[i-2];
        }
        return cb[n];
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int one = 1;
        int two = 2;
        int next = 0;
        for (int i = 2; i < n; i++) {
            next = one + two;
            one = two;
            two = next;
        }
        return two;
    }
}
