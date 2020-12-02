package com.github.matjanko.aoc.passwordphilosophy;

public class PasswordPhilosophyServiceImpl implements PasswordPhilosophyService {

    @Override
    public boolean isPasswordCorrect(int min, int max, char letter, String password) {
        int counter = 0;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == letter) {
                ++counter;
            }
        }
        return counter >= min && counter <= max;
    }

    @Override
    public boolean isPasswordCorrectByOTCA(int min, int max, char letter, String password) {
        if (password.charAt(min - 1) == letter && password.charAt(max - 1) != letter) {
            return true;
        } else return password.charAt(min - 1) != letter && password.charAt(max - 1) == letter;
    }

}
