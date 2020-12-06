package com.github.matjanko.aoc.passportprocessing;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString
public class Passport {

    private String byr;
    private String iyr;
    private String eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;


    public boolean isValidPartOne() {
        return byr != null &&
                iyr != null &&
                eyr != null &&
                hgt != null &&
                hcl != null &&
                ecl != null &&
                pid != null;
    }

    public boolean isValidPartTwo() {
        return isBirthYearValid() &&
                isIssueYearValid() &&
                isExpirationYearValid() &&
                isHeightValid() &&
                isHairColorValid() &&
                isEyeColorValid() &&
                isPassportIDValid();
    }

    public boolean isBirthYearValid() {
        return isYearValid(byr, 1920, 2002);
    }

    public boolean isIssueYearValid() {
        return isYearValid(iyr, 2010, 2020);
    }

    public boolean isExpirationYearValid() {
        return isYearValid(eyr, 2020, 2030);
    }

    public boolean isHeightValid() {
        if (!hasUnit(hgt) || hgt == null) {
            return false;
        }
        String unit = hgt.substring(hgt.length() - 2);

        try {
            int h = Integer.parseInt(hgt.replace(unit, ""));
            return unit.equals("cm")
                    ? h >= 150 && h <= 193
                    : h >= 59 && h <= 76;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isHairColorValid() {
        if (hcl == null)
            return false;

        return hcl.matches("^(\\#)(\\d|[a-f]){6}$");
    }

    public boolean isEyeColorValid() {
        if (ecl == null)
            return false;

        return Arrays.stream(EyeColor.values())
                .anyMatch(x -> ecl.equals(x.name()));
    }

    public boolean isPassportIDValid() {
        if (pid == null)
            return false;

        return pid.matches("^\\d{9}$");
    }

    private boolean isYearValid(String year, int min, int max) {
        if (year == null)
            return false;

        try {
            int y = Integer.parseInt(year);
            return y >= min && y <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean hasUnit(String height) {
        if (height == null)
            return false;

        return height.endsWith("cm") || height.endsWith("in");
    }
}
