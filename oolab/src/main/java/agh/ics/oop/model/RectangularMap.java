package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final Map<Vector2d, Animal> animals;
    private final MapVisualizer visualizer;

    public RectangularMap (int width, int height)
    {
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);
        this.animals= new HashMap<>();
        this.visualizer = new MapVisualizer(this);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getAnimalCoordinates()))
        {
            animals.put(animal.getAnimalCoordinates(), animal);
            return true;

            }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldCoordinates = animal.getAnimalCoordinates();
        animal.move(direction,this);
        animals.remove(oldCoordinates);
        animals.put(animal.getAnimalCoordinates(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals.get(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return this.animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !isOccupied(position);
    }

    @Override
    public String toString() {
        return visualizer.draw(lowerLeft, upperRight);
    }
}
