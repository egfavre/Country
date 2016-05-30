package com.egfavre;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 5/30/16.
 */
public class MainTest2 {
    @Test
    public void save() throws Exception {

        ArrayList<String> choosenCountryList = new ArrayList<>();
        choosenCountryList.add("america");
        choosenCountryList.add("brazil");
        choosenCountryList.add("cuba");

        Main.save("TestFile", choosenCountryList);

    }

}