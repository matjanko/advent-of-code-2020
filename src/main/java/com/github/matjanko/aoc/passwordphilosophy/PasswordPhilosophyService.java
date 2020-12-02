package com.github.matjanko.aoc.passwordphilosophy;

public interface PasswordPhilosophyService {

    boolean isPasswordCorrect(int min, int max, char letter, String password);

    boolean isPasswordCorrectByOTCA(int min, int max, char letter, String password);
}
