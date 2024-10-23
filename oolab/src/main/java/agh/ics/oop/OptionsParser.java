package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;


public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        List<MoveDirection> output = new ArrayList<>();

        for(String arg : args) {
            switch(arg) {
                case "f" -> output.add(MoveDirection.FORWARD);
                case "b" -> output.add(MoveDirection.BACKWARD);
                case "r" -> output.add(MoveDirection.RIGHT);
                case "l" -> output.add(MoveDirection.LEFT);
                default -> System.out.println("Wrong letter");
            }
        }

        return output.toArray(new MoveDirection[0]);
    }
}