package com.github.matjanko.aoc.customcustoms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        File file = new File("src/main/java/com/github/matjanko/aoc/customcustoms/input.txt");

        List<String> inputs = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Plane plane = new Plane();
        PassengerGroup group = new PassengerGroup();
        String input = "";

        for (int i = 0; i < inputs.size(); i++) {
            input = inputs.get(i);
            if(input.equals("")) {
                plane.addPassengerGroup(group);
                if (i < inputs.size() - 1) {
                    group = new PassengerGroup();
                }
            } else {
                group.addPerson(new Person(input));
            }
        }

        int countsAnyoneAnsweredYesSum = Math.toIntExact(
                plane.getPassengerGroups().stream()
                        .map(PassengerGroup::getNoOfQuestionsWhichAnyoneAnsweredYes)
                        .mapToInt(Integer::intValue)
                        .sum());

        int countsEveryoneAnsweredYesSum = Math.toIntExact(
                plane.getPassengerGroups().stream()
                        .map(PassengerGroup::getNoOfQuestionsWhichEveryoneAnsweredYes)
                        .mapToInt(Integer::intValue)
                        .sum());


        System.out.println(countsAnyoneAnsweredYesSum);
        System.out.println(countsEveryoneAnsweredYesSum);
    }
}
