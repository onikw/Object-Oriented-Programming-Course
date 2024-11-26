package agh.ics.oop.model;

import java.util.Objects;

public class Grass implements WorldElement
{

    private static final String GRASS_SYMBOL = "*";
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
        return GRASS_SYMBOL;
    }




    //jak to panie działa
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grass grass = (Grass) o;
        return Objects.equals(GrassPosition, grass.GrassPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(GrassPosition);
    }
}
