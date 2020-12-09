package com.github.matjanko.aoc.customcustoms;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Plane {

    private List<PassengerGroup> passengerGroups = new ArrayList<>();

    public void addPassengerGroup(PassengerGroup group) {
        this.passengerGroups.add(group);
    }
}
