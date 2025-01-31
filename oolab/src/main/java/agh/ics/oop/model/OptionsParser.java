package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;


public class OptionsParser {

    private final static String ILLEGAL_MOVE_MESSAGE = "- illegal move";
    public static List<MoveDirection> parse(String[] args)
    {
        List<MoveDirection> moves = new ArrayList<>();
        for(String arg : args)
            switch(arg) {

                case "f" -> moves.add(MoveDirection.FORWARD);
                case "b" -> moves.add(MoveDirection.BACKWARD);
                case "r" -> moves.add(MoveDirection.RIGHT);
                case "l" -> moves.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(String.format("%s %s",arg,ILLEGAL_MOVE_MESSAGE));

            }
        return moves;
    }
}