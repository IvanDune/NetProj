package com.example.servingwebcontent.logic;

import java.util.*;

public class Randomizer {
    /**
     * Generate random number
     * @param num - top limit
     * @return - random number from 1 to n
     */
    public static int rand(int num){
        Random random = new Random();
        int n = random.nextInt(num+1);
        return n;
    }
    /**
     * Generate random number with special modifier
     * @param num - top limit
     * @param mod - modifier to roll
     * @return
     */
    public static int rand(int num, int mod){
        int n = rand(num);
        if (n+mod>=0)
            return n+mod;
        else return 0;
    }
    /**
     * Generate several numbers with modifier
     * @param num - top limit
     * @param mod - final modifier for all rolls
     * @param quantity - quantity of rolls
     * @return
     */
    public static int rand(int num, int mod, int quantity){
        int sum=0;
        for (int i=0;i<quantity;i++){
            sum += rand(num);
        }
        if (sum+mod>=0)
            return sum+mod;
        else return 0;
    }
    /**
     * Generate standard characteristic for D&D 5e
     * @return - one characteristic
     */
    public static int characteristicDnd(){
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i=0;i<4;i++){
            list.add(rand(6));
            sum += list.get(i);
        }
        int i = (int) Collections.min(list);
        sum -=i;
        return sum;
    }

    /**
     * Geneate modifier of characteristic in D&D 5e
     * @param num - standard characteristic
     * @return - modifier of characteristic
     */
    public static int characteristicDndMod(int num){
        double i = (double) (num-10)/2;
        if (i<0&&i%1!=0)
            i-=0.5;
        return (int) i;
    }
}
