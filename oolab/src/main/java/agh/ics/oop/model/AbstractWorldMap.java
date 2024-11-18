package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap
{
    protected final Map<Vector2d, Animal> animals;
    protected final MapVisualizer visualizer;
    protected Vector2d lowerLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected AbstractWorldMap() {
        this.animals = new HashMap<>();
        this.visualizer = new MapVisualizer(this);
    }
    @Override
    public boolean place(Animal animal)
    {
        if (canMoveTo(animal.getPosition()))
        {
            animals.put(animal.getPosition(), animal);
            return true;

        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction)
    {
        Vector2d oldCoordinates = animal.getPosition();
        animal.move(direction,this);
        animals.remove(oldCoordinates);
        animals.put(animal.getPosition(), animal);
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position)
    {
        return animals.get(position);
    }
    @Override
    public String toString()
    {
        return visualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public LinkedList<WorldElement> getElements()
    {
        return new LinkedList<>(animals.values());
    }
}
