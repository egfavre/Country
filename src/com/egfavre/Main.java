package com.egfavre;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //sort the objects into array by first character
        //ask user to pick a letter; throw exception if they don't pick a valid entry
        //save a file of countries that start with that letter
        //Optional Tasks

        String firstLetter;

        HashMap<String, String> allCountries = new HashMap<>();

        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            firstLetter = String.valueOf(country.name.charAt(0));
            allCountries.put(firstLetter, country.name);
        }

       Scanner consoleScanner = new Scanner(System.in);

        public void getLetter() {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.println("Please pick a letter");
            String answer = consoleScanner.nextLine();
            char[] charAnswer = answer.toCharArray();
            if (charAnswer.length != 1 || !Character.isAlphabetic(charAnswer[0])) {
            System.out.println("That is not a single letter.");
                getLetter();

        }
        }

    }
}
