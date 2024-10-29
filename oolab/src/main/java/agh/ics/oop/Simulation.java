package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {


    private int numberOfAnimals = 0;
    private int movesCount = 0;

    private List<Vector2d> initialPositions;
    private final List<MoveDirection> moves;
    private final List<Animal> animals;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves)
    {
        this.movesCount = moves.size();
        this.numberOfAnimals = initialPositions.size();
        this.moves =  moves;
        this.animals = new ArrayList<>();
        for(Vector2d position : initialPositions)
            this.animals.add(new Animal(position));

    }
    public List<Animal> getAnimals() {
        return this.animals;
    }
    public void Run()
    {

        for (int i = 0; i < movesCount; i++)
        {
            Animal animal =  animals.get(i%numberOfAnimals);
            MoveDirection move = moves.get(i);
            animal.move(move);
            animals.set(i%numberOfAnimals,animal);
            System.out.println("Zwierze " + i%numberOfAnimals + " : "+
                    animals.get(i%numberOfAnimals).getAnimalCoordinates().toString()
            );
        }

    }
}
