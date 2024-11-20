package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.WorldMap;

import java.util.List;

public class Simulation<T, P>  {

    private int numberOfCreatures = 0;
    private int movesCount = 0;

    private final List<MoveDirection> moves;
    private final List<T> creatures;
    private final WorldMap<T, P> worldMap;


    public Simulation(List<T> Creatures, List<MoveDirection> moves, WorldMap<T, P> worldMap)
    {

        this.movesCount = moves.size();
        this.numberOfCreatures = Creatures.size();
        this.moves =  moves;
        this.worldMap = worldMap;
        this.creatures = Creatures;


        for (T creature : creatures) {
            worldMap.place(creature);
        }

    }



    public List<T> getCreatures() {
        return creatures;
    }

    public void Run() {
        System.out.println(worldMap);
        for (int i = 0; i < movesCount; i++) {
            T creature = creatures.get(i % numberOfCreatures);
            MoveDirection move = moves.get(i);

            worldMap.move(creature, move);
            System.out.println(worldMap);
        }
    }

}