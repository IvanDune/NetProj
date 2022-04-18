package com.example.servingwebcontent.logic;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;

public class Randomizer {

    public static int rand(int num){
        Random random = new Random();
        int n = random.nextInt(num+1);
        return n;
    }

    public static int rand(int num, int mod){
        int n = rand(num);
        if (n+mod>=0)
            return n+mod;
        else return 0;
    }

    public static int rand(int num, int mod, int kol){
        int sum=0;
        for (int i=0;i<kol;i++){
            sum += rand(num);
        }
        if (sum+mod>=0)
            return sum+mod;
        else return 0;
    }

    public static int characteristic(){
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

    public static int characteristicMod(int num){
        double i = (double) (num-10)/2;
        if (i<0&&i%1!=0)
            i-=0.5;
        return (int) i;
    }
}
