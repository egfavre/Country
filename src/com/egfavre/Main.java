package com.egfavre;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
    public static String answer;

    public static void main(String[] args) throws FileNotFoundException {

        //ask user to pick a letter; throw exception if they don't pick a valid entry
        //save a file of countries that start with that letter
        //Optional Tasks

        String[] countries = new String[241];

        HashMap<String, ArrayList> allCountries = new HashMap<>();


        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        int i = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            countries[i] = country.name;
            i++;
        }

        for (String name : countries) {
            String thisName = name;
            char firstLetter = name.charAt(0);
            String firstLetterStr = String.valueOf(firstLetter);
            allCountries.put(firstLetterStr, new ArrayList<>());
        }

        for (String name : countries) {
            String thisName = name;
            char firstLetter = name.charAt(0);
            String firstLetterStr = String.valueOf(firstLetter);
            allCountries.get(firstLetterStr).add(name);
        }

        Scanner consoleScanner = new Scanner(System.in);

        getLetter();

        ArrayList<String> choosenCountryList = allCountries.get(answer);
        String filename = answer + "_countries.txt";

        save(filename, choosenCountryList);

        }

        public static String getLetter() {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.println("Please pick a letter");
            answer = consoleScanner.nextLine();
            char[] charAnswer = answer.toCharArray();
            if (charAnswer.length != 1 || !Character.isAlphabetic(charAnswer[0])) {
            System.out.println("That is not a single letter.");
                getLetter();
            }
            return answer;

        }

    public static void save(String filename, ArrayList<String> choosenCountryList) {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(choosenCountryList);
        File f = new File(filename);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

