/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cointests;

import java.util.ArrayList;

public class CoinsUtils {
    /* This method is the heart of the class. It returns the minimum coins you need
     * to reach some amount of coins using dynamic programming. A coin denomination
     * of 1 is expected to be in coinDenoms.
     */
    public static ArrayList getMinChange(int[] coinDenoms, int change){
        int[] minCoinsNeeded = new int[100];
        int[] lastCoinUsed = new int[100];
        
        // What happens when you have zero coins... Initializing the arrays.
        minCoinsNeeded[0] = 0;
        lastCoinUsed[0] = 0;

        // The coinDenom array cannot be empty.
        if(coinDenoms.length == 0){
            throw new IllegalArgumentException("Array of coin denominations must have"
                    + " at least one element in it.");
        }
        // Change should be less than 100 (because then we would be using dollar bills)
        // and change must be greater than or equal to zero.
        if(change >= 100){
            change = 100;
            throw new IllegalArgumentException("Change must be less than 100.");
        }
        if(change <= 0){
            change = 0;
            throw new IllegalArgumentException("Change must be positive and not zero.");
        }

        // Update the tables all the way up to the value of change.
        for(int i = 1; i <= change; i++){
            // Track the index of coin used to find leastCoins
            int index = 0;
            // Track the value at the index with the current leastCoins value
            int leastCoins = minCoinsNeeded[i - 1];
            
            // Check all minCoinsNeeded array at all increments of coinDenoms to find the least coins needed
            for(int j = 1; j < coinDenoms.length; j++){
                // Don't check a coin if it is greater than increment of i.    
                if(coinDenoms[j] <= i){
                    // Find the most efficient coin. Track the smallest number of coins.
                    if(leastCoins > minCoinsNeeded[i - coinDenoms[j]]){
                        leastCoins = minCoinsNeeded[i - coinDenoms[j]];
                        index = j;
                    }
                }
            }
            // Update arrays.
            minCoinsNeeded[i] = leastCoins + 1;
            lastCoinUsed[i] = coinDenoms[index];
        }
        
        // Uncomment to see tables for minCoinsNeeded and lastCoinUsed arrays.
/*
        System.out.println("MinCoinsUsed");
        print(minCoinsNeeded, change);
        
        System.out.println("LastCoinUsed");
        print(lastCoinUsed, change);
*/        

        // Create an arrayList to hold all the coins that were used using lastCoinUsed array.
        ArrayList<Integer> coinsBack = new ArrayList();
        int i = change;
        while(lastCoinUsed[i] != 0){
            coinsBack.add(lastCoinUsed[i]);
            i -= lastCoinUsed[i];
        }
        
        // Uncomment to print a table of coins returned.
/*        coinsBack.trimToSize();
        System.out.println("Size = " + coinsBack.size());
        Integer[] cb = new Integer[coinsBack.size()]; cb = coinsBack.toArray(cb);
        System.out.println("Coins returned");
        print(cb, cb.length);
 */       
        return coinsBack;
    }
    
    
    /* prints a table of the elements in an array*/
    private static void print(int[] arr, int length){
        for(int i = 0; i <= length; i++){
            System.out.println(i + "  " + arr[i]);
        }
        System.out.println();
    }
    
    private static void print(Integer[] arr, int length){
        for(int i = 0; i < length; i++){
            System.out.println(i + "  " + arr[i]);
        }
        System.out.println();
    }
}
