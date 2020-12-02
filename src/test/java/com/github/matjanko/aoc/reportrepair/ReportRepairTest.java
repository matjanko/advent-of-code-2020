package com.github.matjanko.aoc.reportrepair;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportRepairTest {

    private ReportRepairService reportRepairService;

    @BeforeEach
    void beforeEach() {
        reportRepairService = new ReportRepairServiceImpl();
    }

    @Test
    void shouldReturnCorrectValueWhenSumOfTwoDifferentNumbersEquals2020() {
        //given
        int[] report = new int[] { 1721, 979, 366, 299, 675, 1456 };
        int expected = 514579;

        //when
        int actual = reportRepairService.getValueOfTwoNumbersMultipliedByThemselvesWitchSumIs2020(report);

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectValueWhenSumOfThreeDifferentDigitsEquals2020() {
        //given
        int[] report = new int[] { 1721, 979, 366, 299, 675, 1456 };
        int expected = 241861950;

        //when
        int actual = reportRepairService.getValueOfThreeNumbersMultipliedByThemselvesWitchSumIs2020(report);

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnZeroWhenSumOfTwoTheSameDigitsEquals2020() {
        //given
        int[] report = new int[] { 5, 1010, 4, 4 };
        int expected = 0;

        //when
        int actual = reportRepairService.getValueOfTwoNumbersMultipliedByThemselvesWitchSumIs2020(report);

        //then
        Assertions.assertEquals(expected, actual);
    }
}
