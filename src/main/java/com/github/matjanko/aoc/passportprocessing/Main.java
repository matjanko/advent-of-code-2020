package com.github.matjanko.aoc.passportprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        PassportFactory factory = new PassportFactory();

        File file = new File("src/main/java/com/github/matjanko/aoc/passportprocessing/input.txt");

        Scanner scanner;

        List<String> inputs = new ArrayList<>();

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> passportsData = new ArrayList<>();
        StringBuilder passport = new StringBuilder();
        for (String i: inputs) {
            if (passport.length() > 0 && !i.equals("")) {
                passport.append(" ");
            }
            passport.append(i);
            if (i.equals("")) {
                passportsData.add(passport.toString());
                passport.setLength(0);
            }
        }

        List<Passport> passports = passportsData
                .stream()
                .map(factory::createPassport)
                .collect(Collectors.toList());

        long validPassportPartOne = passports.stream()
                .filter(Passport::isValidPartOne)
                .count();

        long validPasswordPartTwo = passports.stream()
                .filter(Passport::isValidPartTwo)
                .count();

        System.out.println(validPassportPartOne);
        System.out.println(validPasswordPartTwo);
    }
}
