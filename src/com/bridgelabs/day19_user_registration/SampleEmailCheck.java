package com.bridgelabs.day19_user_registration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SampleEmailCheck {
    ArrayList<String> validEmails = new ArrayList<>();
    ArrayList<String> inValidEmails = new ArrayList<>();
    File file1 = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day19-RegexUserRegistration\\src\\com\\bridgelabs\\day19_user_registration\\ValidEmails.txt");
    File file2 = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day19-RegexUserRegistration\\src\\com\\bridgelabs\\day19_user_registration\\InvalidEmails.txt");
    Scanner sc1 = new Scanner(file1); //this scanner will only take the input from this file path
    Scanner sc2 = new Scanner(file2);
    Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+([-+.][a-zA-Z0-9]+)*[@][a-zA-Z0-9]{1,}[.][a-zA-Z]{2,3}([.][a-zA-Z]{2,3})?$");

    public SampleEmailCheck() throws FileNotFoundException {
    }

    ArrayList<Boolean> isValid = new ArrayList<>();
    public ArrayList<Boolean> validEmailcheck() {
        while(sc1.hasNextLine()) {
            validEmails.add(sc1.nextLine()); //this loop will continue unless there is no next line and add each line as a arraylist
        }
        System.out.println("\nList of valid email samples\n");
        for (String valid : validEmails) {
            boolean matches = pattern.matcher(valid).matches();
            if(matches)
            {
                System.out.println(valid+" is Valid");
                isValid.add(true);
            }
            else
            {
                System.out.println(valid+" is inValid");
                isValid.add(false);
            }
        }
        return isValid;
    }
    ArrayList<Boolean> isInValid = new ArrayList<>();
    public ArrayList<Boolean> invalidEmailcheck() {
        while(sc2.hasNextLine()) {
            inValidEmails.add(sc2.nextLine());
        }
        System.out.println("\nList of InValid email samples\n");
        for (String inValid : inValidEmails) {
            boolean matches = pattern.matcher(inValid).matches();
            if(matches)
            {
                System.out.println(inValid+" is Valid");
                isInValid.add(false);
            }
            else {
                System.out.println(inValid+" is invalid");
                isInValid.add(true);
            }
        }
        return isInValid;
    }
}
