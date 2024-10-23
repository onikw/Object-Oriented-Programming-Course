package agh.ics.oop.model;

public enum MapDirection   {
        NORTH, EAST, SOUTH, WEST;

    public  String toString() {
        return switch (this) {
            case NORTH -> "Polnoc";
            case EAST -> "Wschod";
            case SOUTH -> "Poludnie";
            case WEST -> "Zachod";
            };

    }
    public MapDirection next()
    {//czemu tak działa dopytać
        return MapDirection.values()[(this.ordinal()+1)%MapDirection.values().length];
    }
    public MapDirection previous()
    {
        return MapDirection.values()[(this.ordinal()+(MapDirection.values().length-1))%MapDirection.values().length];
    }
    public Vector2d toUnitVector()
    {
        return switch (this)
        {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);

        };
    }
}
