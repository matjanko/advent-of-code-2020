package com.github.matjanko.aoc.toboggantrajectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("src/main/java/com/github/matjanko/aoc/toboggantrajectory/input.txt");

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


        int slope1 = getEncounteredTrees(inputs, 1, 1);
        int slope2 = getEncounteredTrees(inputs, 3, 1);
        int slope3 = getEncounteredTrees(inputs, 5, 1);
        int slope4 = getEncounteredTrees(inputs, 7, 1);
        int slope5 = getEncounteredTrees(inputs, 1, 2);

        System.out.println(slope2);
        System.out.println((long) slope1 * slope2 * slope3 * slope4 * slope5);
    }

    private static int getEncounteredTrees(List<String> inputs, int right, int down) {
        int yPosition = right;
        int trees = 0;

        for (int i = down; i < inputs.size(); i += down) {
            StringBuilder row = new StringBuilder(inputs.get(i));
            if (yPosition >= row.length()) {
                yPosition -= row.length();
            }
            if (isTree(row.charAt(yPosition))) {
                ++trees;
            }
            yPosition += right;
        }
        return trees;
    }

    private static boolean isTree(char c) {
        return c == '#';
    }
}
