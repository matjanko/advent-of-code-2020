package com.github.matjanko.aoc.binaryboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Plane {

    public static final List<Integer> ROWS = IntStream
            .range(0, 128)
            .boxed()
            .collect(Collectors.toList());

    public static final List<Integer> COLUMNS = IntStream
            .range(0, 8)
            .boxed()
            .collect(Collectors.toList());
}
