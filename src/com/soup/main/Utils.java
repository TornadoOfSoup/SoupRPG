package com.soup.main;

import com.soup.entities.EntityAction;
import com.soup.entities.Player;

import java.util.ArrayList;
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

    public static void printLogo() {
        System.out.println("=======================================================================\n" +
                "==  _______  _______           _______    _______  _______  _______  ==\n" +
                "== (  ____ \\(  ___  )|\\     /|(  ____ )  (  ____ )(  ____ )(  ____ \\ ==\n" +
                "== | (    \\/| (   ) || )   ( || (    )|  | (    )|| (    )|| (    \\/ ==\n" +
                "== | (_____ | |   | || |   | || (____)|  | (____)|| (____)|| |       ==\n" +
                "== (_____  )| |   | || |   | ||  _____)  |     __)|  _____)| | ____  ==\n" +
                "==       ) || |   | || |   | || (        | (\\ (   | (      | | \\_  ) ==\n" +
                "== /\\____) || (___) || (___) || )        | ) \\ \\__| )      | (___) | ==\n" +
                "== \\_______)(_______)(_______)|/         |/   \\__/|/       (_______) ==\n" +
                "=======================================================================");
    }

    public static void printList(ArrayList<?> items) {
        StringBuilder builder = new StringBuilder();
        int i = 1;

        for (Object item : items) {
            builder.append(i + ". " + item + "\n");
            i++;
        }
        System.out.println(builder.toString());
    }

    public static String viewPlayerStats(Player player) {
        return ""; //TODO make this work
    }
}
