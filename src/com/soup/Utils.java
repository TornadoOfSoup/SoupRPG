package com.soup;

import java.util.Random;

public class Utils {

    static Random rand = new Random();

    /**
     * A method to get a random integer between min and max.
     *
     * randomIntBetweenBounds(5, 10) can return 5, 6, 7, 8, 9, and 10.
     *
     * @param min the minimum number
     * @param max the maxmimum number
     * @return a random integer between min and max, inclusive.
     */
    public static int randomIntBetweenBounds(int min, int max) {
        int i = rand.nextInt((max + 1) - min);
        return i + min;
    }
}
