package com.github.matjanko.aoc.reportrepair;

public class ReportRepairServiceImpl implements ReportRepairService {
    @Override
    public int getValueOfTwoNumbersMultipliedByThemselvesWitchSumIs2020(int[] report) {
        for (int i = 0; i < report.length; i++) {
            for (int j = 1; j < report.length; j++) {
                if (i == j) {
                    break;
                }
                if (report[i] + report[j] == 2020) {
                    return report[i] * report[j];
                }
            }
        }
        return 0;
    }

    @Override
    public int getValueOfThreeNumbersMultipliedByThemselvesWitchSumIs2020(int[] report) {
        for (int i = 0; i < report.length; i++) {
            for (int j = 1; j < report.length; j++) {
                if (i == j) {
                    break;
                }
                for (int k = 2; k < report.length; k++) {
                    if (i == k || j == k) {
                        break;
                    }
                    if (report[i] + report[j] + report[k] == 2020) {
                        return report[i] * report[j] * report[k];
                    }
                }
            }
        }
        return 0;
    }
}
