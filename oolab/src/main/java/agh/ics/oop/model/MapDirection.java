package agh.ics.oop.model;

public enum MapDirection   {
    NORTH, EAST, SOUTH, WEST;

    static final String[] ROSE = {"Polnoc", "Wschod", "Poludnie", "Zachod"};
    static final Vector2d[] ROSE_VECTORS = {
            new Vector2d(0, 1),
            new Vector2d(1, 0),
            new Vector2d(0, -1),
            new Vector2d(-1, 0)
    };
    @Override
    public  String toString() {
        return ROSE[this.ordinal()];
    }
    public MapDirection next()
    {
        return MapDirection.values()[(this.ordinal()+1)%MapDirection.values().length];
    }
    public MapDirection previous()
    {
        return MapDirection.values()[(this.ordinal()+(MapDirection.values().length-1))%MapDirection.values().length];
    }
    public Vector2d toUnitVector()
    {
        return ROSE_VECTORS[this.ordinal()];
    }
}
