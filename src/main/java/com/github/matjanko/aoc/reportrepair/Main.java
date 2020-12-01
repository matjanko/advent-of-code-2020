package com.github.matjanko.aoc.reportrepair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Integer> report = new ArrayList<>();

        File file = new File("src/main/java/com/github/matjanko/aoc/reportrepair/input.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                report.add(Integer.parseInt(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(report);

        ReportRepairService reportRepairService = new ReportRepairServiceImpl();

        int[] array = new int[report.size()];
        for (int i = 0; i < report.size(); i++) {
            array[i] = report.get(i);
        }
        int value = reportRepairService.getValueOfTwoNumbersMultipliedByThemselvesWitchSumIs2020(array);
        System.out.println(value);

        int value2 = reportRepairService.getValueOfThreeNumbersMultipliedByThemselvesWitchSumIs2020(array);
        System.out.println(value2);
    }
}
