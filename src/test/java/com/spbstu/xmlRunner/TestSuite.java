package com.spbstu.xmlRunner;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by dmitry on 21.03.2017.
 */
public class TestSuite extends BaseTest_ {

    @DataProvider(parallel = true)
    public Object[][] data(){
        return new Object[][]{
                {1, 2},
                {2, 4},
                {4, 8},
                {8, 16},
                {16, 32}
        };
    }

    @Test(dataProvider = "data")
    public void searchTest(int var, int expectedResult){
        System.out.println(String.format("%d * 2 = %d", var, expectedResult));
        Assert.assertEquals(var * 2, expectedResult);
    }

    @Test(groups = "ignore")
    public void loginTest() {
        Assert.fail();
    }
}
