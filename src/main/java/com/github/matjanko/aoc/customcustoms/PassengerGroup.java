package com.github.matjanko.aoc.customcustoms;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PassengerGroup {

    private List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public int getNoOfAnsweredQuestions() {
        return Math.toIntExact(
                people.stream()
                        .map(Person::getAnswer)
                        .collect(Collectors.joining())
                        .chars()
                        .distinct()
                        .count()
        );
    }
}
