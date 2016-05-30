package com.egfavre;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by user on 5/30/16.
 */
public class MainTest {
    @Test
    public void createHashMap() throws Exception {

        String[] countries = {"test1", "test2", "test3", "test4", "a", "b", "c", "z"};
        HashMap<String, ArrayList> allCountries = new HashMap<>();

        Main.createHashMap(countries, allCountries);

        System.out.println(allCountries);
    }

}