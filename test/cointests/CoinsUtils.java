/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cointests;

import java.util.ArrayList;

public class CoinsUtils {
    
    public static ArrayList getMinChange(int[] array, int change){
        ArrayList<Integer> coinsBack = new ArrayList();
        if(array.length == 0){
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

        
        while(change != 0){
            int choice = 0;
            for(int i = 0; i < array.length; i++){
                if(change >= array[i]){
                    choice = array[i];
                }
            }
            change -= choice;
            coinsBack.add(choice);
        }
        
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
}
