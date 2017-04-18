package com.spbstu.helper;

import com.google.gson.Gson;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

/**
 * Created by dmitry on 18.04.2017.
 */
public class TestUtils {

    private static Random random = new Random();


    public static String Random() {
        return new BigInteger(64, random).toString(32);
    }
}
