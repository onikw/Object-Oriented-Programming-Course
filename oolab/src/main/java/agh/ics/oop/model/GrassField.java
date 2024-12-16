package agh.ics.oop.model;

import agh.ics.oop.model.util.RandomPositionGenerator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GrassField extends AbstractWorldMap
{
    private static final String MAP_NAME="Grassfield";

    int grassCount;
    private final Map<Vector2d, Grass> grasses;

    public GrassField (int grassCount)
    {
        super();
        this.grasses = new HashMap<>();
        this.grassCount = grassCount;

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int) Math.sqrt(10 * grassCount), (int) Math.sqrt(10 * grassCount), grassCount);
        for (Vector2d grassPosition : randomPositionGenerator) {
            grasses.put(grassPosition, new Grass(grassPosition));
        }
    }


    @Override
    public String getId(){
        return String.format("%s %s",MAP_NAME,id.toString());

    }

    @Override
    public WorldElement objectAt(Vector2d position)
    {
        if(super.objectAt(position) != null)
            return super.objectAt(position);
        if(grasses.get(position) != null)
            return grasses.get(position);
        return null;
    }

    @Override
    public LinkedList<WorldElement> getElements() {
        LinkedList<WorldElement> elements = super.getElements();
        elements.addAll(grasses.values());
        return elements;
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        return objectAt(position) != null;
    }


    //to chyba źle mam
    @Override
    public String toString()
    {
        LinkedList<WorldElement> elements = this.getElements();
        Vector2d lowerLeftPrim= elements.getFirst().getPosition();
        Vector2d upperRightPrim = elements.getFirst().getPosition();
        for (WorldElement element : elements)
        {
            lowerLeftPrim = lowerLeftPrim.lowerLeft(element.getPosition());
            upperRightPrim = upperRightPrim.upperRight(element.getPosition());
        }
        return visualizer.draw(lowerLeftPrim, upperRightPrim);
    }




}
