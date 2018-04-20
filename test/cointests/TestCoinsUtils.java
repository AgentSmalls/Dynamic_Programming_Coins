/*
 * Authors: Timothy Small and James Jacobs
 * Date: 4/20/18
 * Overview: Collections of tests to test a dynamic program for returning change
 */

package cointests;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCoinsUtils {
    
    //tests if value of change is greater than or equal to zero
    @Test (expected = IllegalArgumentException.class)
    public void testPositiveChangeBack(){
        int change = -5;
        int[] coinDenominations = new int[] {1, 5, 10, 25};
        assertEquals(0, CoinsUtils.getMinChange(coinDenominations, change));
    }
    
    //checks if change is less than a dollar
    @Test (expected = IllegalArgumentException.class)
    public void testChangeLessThanDollar(){
        int change = 109;
        int[] coinDenominations = new int[] {1, 5, 10, 25};
        assertEquals(100, CoinsUtils.getMinChange(coinDenominations, change));
    }
    
    // Coin system in this test would work using greedy algorithm. Does not directly 
    // test the effectiveness of the dynamic algorithm.
    //tests that the algorithm returns the correct coins
    @Test
    public void testProperChangeBack(){
        int change = 92;
        int[] coinDenominations = new int[] {1, 5, 10, 25};
        ArrayList<Integer> expected = new ArrayList();
        expected.add(1);
        expected.add(1);
        expected.add(5);
        expected.add(10);
        expected.add(25);
        expected.add(25);
        expected.add(25);

        assertEquals(expected, CoinsUtils.getMinChange(coinDenominations, change));
        
    }
    
    //tests if dynamic program works properly
    @Test
    public void testDynamicReturnChange(){
        int change = 33;
        int[] coinDenominations = {1, 10, 25};
        Integer[] returnedCoins = {1, 1, 1, 10, 10, 10};
        ArrayList coins = new ArrayList();
        for(int i = 0; i < returnedCoins.length; i++){
            coins.add(returnedCoins[i]);
        }
        assertEquals(coins, CoinsUtils.getMinChange(coinDenominations, change));
    }
        
    //tests for a change value of 15
    @Test (expected = IllegalArgumentException.class)
    public void testEmptyArrayParameter(){
        int[] array = {};
        int change = 15;
        
        CoinsUtils.getMinChange(array, change);
        
    }
    
}
