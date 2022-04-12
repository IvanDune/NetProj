package com.example.servingwebcontent.logic;

import java.util.Random;

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
}
