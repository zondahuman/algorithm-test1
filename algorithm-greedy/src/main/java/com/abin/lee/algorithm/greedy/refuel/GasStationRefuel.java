package com.abin.lee.algorithm.greedy.refuel;

/**
 * Created by abin on 2018/5/12 13:56.
 * algorithm-test1
 * com.abin.lee.algorithm.greedy.refuel
 */
public class GasStationRefuel {

    public static void main(String[] args) {
        int[] distance = new int[]{1,2,3,4,5,6,6};
        int totalJourney = 7;
        int result = carRefuel(distance, totalJourney);
        System.out.println("result=" + result);
    }
    /**
     *
     * @param refuelStation 每个加油站之间的距离，
     * @param distance 每次加满油能行走的距离
     * @return
     */
    public static int carRefuel(int[] refuelStation, int distance){
        for(int i=0;i<refuelStation.length;i++){
            if(refuelStation[i] > distance)
                return -1;
        }
        int sum = 0;//加油的次数
        int journery = 0 ;
        for (int i = 0; i <refuelStation.length ; i++) {
            journery += refuelStation[i] ;
            if(journery > distance){
                sum++;
                journery = refuelStation[i];
            }
        }
        return sum;

    }




}
