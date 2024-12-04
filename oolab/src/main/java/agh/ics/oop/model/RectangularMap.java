package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap
{
    public RectangularMap (int width, int height)
    {
        super();
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);
    }


}
