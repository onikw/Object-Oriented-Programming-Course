package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;


public class OptionsParser {
    public static List<MoveDirection> parse(String[] args)
    {
        List<MoveDirection> moves = new ArrayList<>();
        for(String arg : args)
            switch(arg) {
                case "f" -> moves.add(MoveDirection.FORWARD);
                case "b" -> moves.add(MoveDirection.BACKWARD);
                case "r" -> moves.add(MoveDirection.RIGHT);
                case "l" -> moves.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(arg + " - illegal move");
            }
        return moves;
    }
}