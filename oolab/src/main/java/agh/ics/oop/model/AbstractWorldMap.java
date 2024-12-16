package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap
{
    protected final Map<Vector2d, Animal> animals;
    protected final MapVisualizer visualizer;
    protected Vector2d lowerLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected final UUID id;
    protected Boundary boundary;

    protected final List<MapChangeListener> observers = new ArrayList<>();

    protected AbstractWorldMap() {
        this.animals = new HashMap<>();
        this.visualizer = new MapVisualizer(this);
        this.id = UUID.randomUUID();
    }


    @Override
    public String getId() {
        return id.toString();
    }

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }

    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this,message);
        }
    }



    @Override
    public void place (Animal animal) throws IncorrectPositionException
    {
        Vector2d position = animal.getPosition();
        if (canMoveTo(animal.getPosition()))
        {
            animals.put(position, animal);
            notifyObservers("placed at "+position);
        }
        else
            throw new IncorrectPositionException(position);



    }
    public Boundary getCurrentBounds() {
        return boundary;
    }

    @Override
    public String toString() {
        return visualizer.draw(getCurrentBounds().lowerLeft(), getCurrentBounds().upperRight());
    }
    @Override
    public void move(Animal animal, MoveDirection direction)
    {
        Vector2d oldCoordinates = animal.getPosition();
        animal.move(direction,this);
        animals.remove(oldCoordinates);
        Vector2d newCoordinates = animal.getPosition();
        animals.put(newCoordinates, animal);

        if (direction==MoveDirection.RIGHT) notifyObservers(oldCoordinates+ " moved right");
        else if (direction==MoveDirection.LEFT) notifyObservers(oldCoordinates+ " moved left");
        else if (! newCoordinates.equals(oldCoordinates) ) notifyObservers("move from " + oldCoordinates + " to " + newCoordinates);
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !isOccupiedByAnimal(position);
    }

    public Animal animalAt (Vector2d position)
    {
        return animals.get(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position)
    {
        return animals.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        return objectAt(position) != null;
    }

    public boolean isOccupiedByAnimal(Vector2d position)
    {
        return animalAt(position) != null;
    }


    @Override
    public LinkedList<WorldElement> getElements()
    {
        return new LinkedList<>(animals.values());
    }
}
