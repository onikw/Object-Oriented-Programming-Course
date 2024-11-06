package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private int numberOfAnimals = 0;
    private int movesCount = 0;

    private final List<MoveDirection> moves;
    private final List<Animal> animals;
    private final WorldMap worldMap;


    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves, WorldMap worldMap)
    {

        this.movesCount = moves.size();
        this.numberOfAnimals = initialPositions.size();
        this.moves =  moves;
        this.worldMap = worldMap;
        this.animals = new ArrayList<>();
        for(Vector2d position : initialPositions) {
            this.animals.add(new Animal(position));
            this.worldMap.place(new Animal(position));
        }



    }
    public List<Animal> getAnimals() {
        return animals;
    }

    public void Run()
    {
        System.out.println(worldMap);
        for (int i = 0; i < movesCount; i++)
        {


            Animal animal =  animals.get(i%numberOfAnimals);
            MoveDirection move = moves.get(i);

            worldMap.move(animal, move);
            System.out.println(worldMap);

        }

    }
}
