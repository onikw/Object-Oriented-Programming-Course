package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {


    public static void main(String[] args) {
        System.out.println("system wystartował");

        //World czy Rec map

        //kiedy te this.


        // RectangularMap
        RectangularMap newRecMap = new RectangularMap (4,4);
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Animal> Animals = List.of(new Animal(new Vector2d(2, 2)), new Animal(new Vector2d(3, 4)), new Animal(new Vector2d(1, 1)));
        Simulation<Animal,Vector2d> simulationRectangular = new Simulation<>(Animals, directions, newRecMap);
        simulationRectangular.Run();


        // TextMap
        TextMap newTextMap = new TextMap();
        List <String> texts = List.of("Ala", "ma", "sowoniedźwiedzia");

        List<MoveDirection> directionsText = OptionsParser.parse(new String[]{"f","f","b","f"});
        Simulation<String,Integer> simulationText = new Simulation<>(texts,directionsText,newTextMap);
        simulationText.Run();






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
