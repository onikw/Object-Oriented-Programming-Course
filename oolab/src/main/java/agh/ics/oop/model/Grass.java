package agh.ics.oop.model;

public class Grass implements WorldElement
{
    Vector2d GrassPosition;
    public Grass(Vector2d GrassPosition)
    {
        this.GrassPosition = GrassPosition;
    }


    @Override
    public Vector2d getPosition()
    {
        return GrassPosition;
    }

    public String toString()
    {
        return "*";
    }

}
