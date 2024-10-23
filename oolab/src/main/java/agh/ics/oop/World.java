package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;

public class World {


    public static void main(String[] args) {
        System.out.println("system wystartował");


        MapDirection dir = MapDirection.NORTH;
        //chyba println używa nadpisnoego tostringa i dlatego po polsku jest
        System.out.println(dir.previous());


        System.out.println(dir.toUnitVector());
        run(args);
        System.out.println("system zakończył działanie");
    }

    public static void run(String[] args) {
        System.out.println("Start");
        MoveDirection[] moves = OptionsParser.parse(args);

        for (MoveDirection move : moves) {
            System.out.println(move);
        }






        System.out.println("Stop");
    }

}
