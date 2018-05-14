package com.abin.lee.algorithm.greedy.refuel;

/**
 * Created by abin on 2018/5/12 13:56.
 * algorithm-test1
 * com.abin.lee.algorithm.greedy.refuel
 */
public class GasStationRefuel {


    public static int refuel(int[] refuelStation, int distance){
        for(int i=0;i<refuelStation.length;i++){
            if(refuelStation[i] > distance)
                return -1;
        }
        for (int i = 0; i <refuelStation.length ; i++) {

        }
        return 0;

    }




}
