package com.github.matjanko.aoc.customcustoms;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
public class PassengerGroup {

    private List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public int getNoOfQuestionsWhichAnyoneAnsweredYes() {
        return Math.toIntExact(people.stream()
                .map(Person::getAnswer)
                .collect(Collectors.joining())
                .chars()
                .distinct()
                .count()
        );
    }

    public int getNoOfQuestionsWhichEveryoneAnsweredYes() {
        if (people.size() == 1) {
            return people.get(0).getAnswer().length();
        }
        return Math.toIntExact(people.stream()
                .map(Person::getAnswer)
                .collect(Collectors.toList())
                .stream()
                .flatMap(x -> x.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() == people.size())
                .count());
    }
}
