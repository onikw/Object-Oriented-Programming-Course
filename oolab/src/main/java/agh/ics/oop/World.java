package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.List;

public class World {


    public static void main(String[] args) {
        System.out.println("system wystartował");

        //World czy Rec map
        WorldMap newRecMap = new RectangularMap (4,4);
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(1, 1));
        Simulation simulation = new Simulation(positions, directions,newRecMap);
        simulation.Run();




        System.out.println("system zakończył działanie");
    }

    public static void run(String[] args) {
        System.out.println("Start");
        List<MoveDirection> moves = OptionsParser.parse(args);
        for (MoveDirection move : moves) {
            System.out.println(move);
        }
        System.out.println("Stop");
    }

}
