/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    @Test (expected = IllegalArgumentException.class)
    public void testPositiveChangeBack(){
        int change = -5;
        int[] coinDenominations = new int[] {1, 5, 10, 25};
        assertEquals(0, CoinsUtils.getMinChange(coinDenominations, change));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testChangeLessThanDollar(){
        int change = 109;
        int[] coinDenominations = new int[] {1, 5, 10, 25};
        assertEquals(100, CoinsUtils.getMinChange(coinDenominations, change));
    }
    
    @Test
    public void testProperChangeBack(){
        int change = 92;
        int[] coinDenominations = new int[] {1, 5, 10, 25};
        ArrayList<Integer> expected = new ArrayList();
/*        expected.add(25);
        expected.add(25);
        expected.add(25);
        expected.add(10);
        expected.add(5);
        expected.add(1);
        expected.add(1);
*/        
        assertEquals(expected, CoinsUtils.getMinChange(coinDenominations, change));
        
    }
    
    @Test
    public void testDynamicReturnChange(){
        int change = 33;
        int[] coinDenominations = {1, 10, 25};
        Integer[] returnedCoins = {10, 10, 10, 1, 1, 1};
        ArrayList coins = new ArrayList();
        for(int i = 0; i < returnedCoins.length; i++){
            coins.add(returnedCoins[i]);
        }
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testEmptyArrayParameter(){
        int[] array = {};
        int change = 15;
        
        CoinsUtils.getMinChange(array, change);
        
    }
    
}