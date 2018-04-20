/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cointests;

import java.util.ArrayList;

public class CoinsUtils {
    
    public static ArrayList getMinChange(int[] coinDenoms, int change){
        int[] minCoinsNeeded = new int[100];
        int[] lastCoinUsed = new int[100];
        
        minCoinsNeeded[0] = 0;
        lastCoinUsed[0] = 0;

        if(coinDenoms.length == 0){
            throw new IllegalArgumentException("Array of coin denominations must have"
                    + " at least one element in it.");
        }
        if(change >= 100){
            change = 100;
            throw new IllegalArgumentException("Change must be less than 100.");
        }
        if(change <= 0){
            change = 0;
            throw new IllegalArgumentException("Change must be positive and not zero.");
        }

//        int copy = change;
        for(int i = 1; i <= change; i++){
            // Track the index of coin used to find leastCoins
            int index = 0;
            // Track the value at the index with the current leastCoins value
            int leastCoins = minCoinsNeeded[i - 1];
            for(int j = 1; j < coinDenoms.length; j++){
                if(coinDenoms[j] <= i){
                    if(leastCoins > minCoinsNeeded[i - coinDenoms[j]]){
                        leastCoins = minCoinsNeeded[i - coinDenoms[j]];
                        index = j;
                    }
                }
            }
            minCoinsNeeded[i] = leastCoins + 1;
            lastCoinUsed[i] = coinDenoms[index];
        }

        System.out.println("MinCoinsUsed");
        print(minCoinsNeeded, change);
        
        System.out.println("LastCoinUsed");
        print(lastCoinUsed, change);
        
        ArrayList<Integer> coinsBack = new ArrayList();
                
        return coinsBack;
    }
    
    //dynammic algorithm
    public static Object[] dynCoins(int[] array, int change, int[] minCoins){
        
        if (array.length == 0) {
            throw new IllegalArgumentException("Array of size 0 is not allowed");
        }

        ArrayList list = new ArrayList();
        
        for(int i = 0; i < change+1; i++){
            int coinCount = i;
            for(int j = 0; j < array.length; j++){
                if(j<=i){
                    if(minCoins[i-j]+1 < coinCount){
                        coinCount = minCoins[i-j]+1;
                    }
                }
            }
            minCoins[i] = coinCount;
            list.add(minCoins[i]);
        }
        
        return list.toArray();
    }
    private static void print(int[] arr, int length){
        for(int i = 0; i <= length; i++){
            System.out.println(i + "  " + arr[i]);
        }
        System.out.println();
    }
}
