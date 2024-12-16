package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.simulation.Simulation;
import agh.ics.oop.simulation.SimulationEngine;

import java.util.ArrayList;
import java.util.List;

public class World {


    public static void main(String[] args) {
        System.out.println("system wystartował");
        try{

            List<Simulation> simulations = new ArrayList<>();



//            List<MoveDirection> directions = OptionsParser.parse(args);
//            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(1, 1));
//            AbstractWorldMap newRecMap = new RectangularMap(4,4);
//            newRecMap.addObserver(new ConsoleMapDisplay());
//            Simulation simulation = new Simulation(positions, directions,newRecMap);
//            simulations.add(simulation);
//
//            AbstractWorldMap grassMap = new GrassField(10);
//            List<MoveDirection> directionsg = OptionsParser.parse(args);
//            List<Vector2d> positionsg = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(1, 1));
//            grassMap.addObserver(new ConsoleMapDisplay());
//            Simulation simulationg = new Simulation(positionsg, directionsg, grassMap);
//            simulations.add(simulationg);


            List<MoveDirection> directions = OptionsParser.parse(args);
            List<Vector2d> positions = List.of(
                    new Vector2d(3, 1),
                    new Vector2d(4, 2),
                    new Vector2d(8, 4),
                    new Vector2d(9, 3),
                    new Vector2d(3,9));
                    new Vector2d(0,6);

            for (int i=0; i<1000; i++){
                AbstractWorldMap map;
                if (i%2==0){map = new GrassField(10);}
                else {map = new RectangularMap(10,10);}
                map.addObserver(new ConsoleMapDisplay());
                Simulation simulation = new Simulation(positions,directions,map);
                simulations.add(simulation);
            }
            SimulationEngine engine = new SimulationEngine(simulations);
            engine.runAsyncInThreadPool();
            //engine.runAsync();






            System.out.println("System zakonczyl dzialanie");
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }





//
//            AbstractWorldMap grassMap = new GrassField(10);
//            List<MoveDirection> directions = OptionsParser.parse(args);
//            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(1, 1));
//            grassMap.addObserver(new ConsoleMapDisplay());
//            Simulation simulation = new Simulation(positions, directions, grassMap);
//            simulation.Run();

//        WorldMap newRecMap = new RectangularMap (4,4);
//        List<MoveDirection> directions = OptionsParser.parse(args);
//        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(1, 1));
//        Simulation simulation = new Simulation(positions, directions,newRecMap);
//        simulation.Run();

    }
}
