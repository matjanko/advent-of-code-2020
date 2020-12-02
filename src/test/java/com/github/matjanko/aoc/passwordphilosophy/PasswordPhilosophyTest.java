package com.github.matjanko.aoc.passwordphilosophy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PasswordPhilosophyTest {

    PasswordPhilosophyService service = new PasswordPhilosophyServiceImpl();

    @ParameterizedTest
    @CsvSource({
            "1,3,a,abcde", "2,9,c,ccccccccc"
    })
    void shouldReturnValid(int min, int max, char letter, String password) {
        //when
        boolean condition = service.isPasswordCorrect(min, max, letter, password);

        //them
        Assertions.assertTrue(condition);
    }

    @ParameterizedTest
    @CsvSource({
            "1,3,b,cdefg"
    })
    void shouldReturnInvalid(int min, int max, char letter, String password) {
        //when
        boolean condition = service.isPasswordCorrect(min, max, letter, password);

        //them
        Assertions.assertFalse(condition);
    }

    @ParameterizedTest
    @CsvSource({
            "1,3,a,abcde"
    })
    void shouldReturnValidForOTCA(int min, int max, char letter, String password) {
        //when
        boolean condition = service.isPasswordCorrectByOTCA(min, max, letter, password);

        //them
        Assertions.assertTrue(condition);
    }

    @ParameterizedTest
    @CsvSource({
            "1,3,b,cdefg", "2,9,c,ccccccccc"
    })
    void shouldReturnInvalidForOTCA(int min, int max, char letter, String password) {
        //when
        boolean condition = service.isPasswordCorrectByOTCA(min, max, letter, password);

        //them
        Assertions.assertFalse(condition);
    }
}
