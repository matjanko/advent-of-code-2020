package com.github.matjanko.aoc.binaryboarding;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardingPass {

    private String rowCode;
    private String columnCode;

    private int row;
    private int column;

    private int seatID;

    public BoardingPass(String rowCode, String columnCode) {
        this.rowCode = rowCode;
        this.columnCode = columnCode;

        if (rowCode != null && columnCode != null) {
            row = calculateRow();
            column = calculateColumn();
            seatID = calculateSeatID();
        }
    }

    private int calculateRow() {
        return calculatePlace(DirectionType.ROW, Plane.ROWS, rowCode);
    }

    private int calculateColumn() {
        return calculatePlace(DirectionType.COLUMN, Plane.COLUMNS, columnCode);
    }

    private int calculateSeatID() {
        return row * 8 + column;
    }

    private int calculatePlace(DirectionType type, List<Integer> places, String code) {
        char dt = type.name().equals("ROW") ? 'F' : 'L';
        for(char c: code.toCharArray()) {
            if (c == dt) {
                places = places.subList(0, places.size()/2);
            } else {
                places = places.subList(places.size()/2, places.size());
            }
        }
        return places.get(0);
    }
}
