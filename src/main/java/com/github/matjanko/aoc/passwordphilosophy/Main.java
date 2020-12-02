package com.github.matjanko.aoc.passwordphilosophy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("src/main/java/com/github/matjanko/aoc/passwordphilosophy/input.txt");

        PasswordPhilosophyService service = new PasswordPhilosophyServiceImpl();

        List<String> inputs = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int validPasswordCounterTaskOne = 0;
        int validPasswordCounterTaskTwo = 0;

        for (String i : inputs) {

            String[] values = i.split("-|\\s|:\\s");

            boolean isCorrectForTaskOne = service.isPasswordCorrect(
                    Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2].charAt(0), values[3]);

            boolean isCorrectForTaskTwo = service.isPasswordCorrectByOTCA(
                    Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2].charAt(0), values[3]);

            if (isCorrectForTaskOne) {
                ++validPasswordCounterTaskOne;
            }

            if (isCorrectForTaskTwo) {
                ++validPasswordCounterTaskTwo;
            }
        }

        System.out.println(validPasswordCounterTaskOne);
        System.out.println(validPasswordCounterTaskTwo);
    }
}
