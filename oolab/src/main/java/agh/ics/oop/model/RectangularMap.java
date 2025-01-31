package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;

public class RectangularMap extends AbstractWorldMap
{
    private static final String MAP_NAME="RectangularMap";

    public RectangularMap (int width, int height)
    {
        super();
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);
        boundary = new Boundary(lowerLeft,upperRight);
    }
    @Override
    public String getId(){
        return String.format("%s %s",MAP_NAME,id.toString());

    }




}
