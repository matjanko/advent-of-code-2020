package com.github.matjanko.aoc.reportrepair;

public class ReportRepairServiceImpl implements ReportRepairService {
    @Override
    public int getValueOfTwoNumbersMultipliedByThemselvesWitchSumIs2020(int[] report) {
        for (int r : report) {
            for (int i = 1; i < report.length; i++) {
                if (r + report[i] == 2020) {
                    return r * report[i];
                }
            }
        }
        return 0;
    }

    @Override
    public int getValueOfThreeNumbersMultipliedByThemselvesWitchSumIs2020(int[] report) {
        for (int r : report) {
            for (int i = 1; i < report.length; i++) {
                for (int j = 2; j < report.length; j++) {
                    if (r + report[i] + report[j] == 2020) {
                        return r * report[i] * report[j];
                    }
                }
            }
        }
        return 0;
    }
}
