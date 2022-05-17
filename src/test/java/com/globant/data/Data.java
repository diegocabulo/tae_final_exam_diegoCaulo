package com.globant.data;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class Data {

    @DataProvider(name = "user")
    public Object[][] inputUser(){
        return new Object[][] {{randomEmailGenerate()}};
    }

    /**
     * Generate random Email to pass to test
     * @return String
     */
    public String randomEmailGenerate(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 18;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return String.join("",generatedString, "@gmail.com");
    }
}
