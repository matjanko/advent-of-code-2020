package com.github.matjanko.aoc.binaryboarding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        File file = new File("src/main/java/com/github/matjanko/aoc/binaryboarding/input.txt");

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

        List<BoardingPass> boardingPasses = inputs.stream()
                .map(x -> new BoardingPass(x.substring(0, 7), x.substring(7)))
                .collect(Collectors.toList());

        int highestSeatID = boardingPasses.stream()
                .mapToInt(BoardingPass::getSeatID)
                .max()
                .orElse(0);

        System.out.println(highestSeatID);
    }
}
