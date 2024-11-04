package agh.ics.oop.model;

public class Animal {

    private static final Vector2d DEFAULT_VECTOR = new Vector2d(2, 2);
    private static final MapDirection DEFAULT_ANIMAL_ORIENTATION = MapDirection.NORTH;
    private static final Vector2d MAP_MIN_POINT = new Vector2d(0,0);
    private static final Vector2d MAP_MAX_POINT = new Vector2d(4,4);


    private MapDirection animalOrientation;
    private Vector2d animalCoordinates;

    public Animal()
    {
        this(DEFAULT_VECTOR);
    }
    public Animal (Vector2d inputAnimalCoordinates)
    {
        this.animalOrientation= DEFAULT_ANIMAL_ORIENTATION;
        this.animalCoordinates = inputAnimalCoordinates;
    }

    public String toString()
    {
        return "Położenie zwierzęcia to :" + this.animalCoordinates.toString()
                + ", a jego orientacja to: " + this.animalOrientation.toString()+".";
    }

    public boolean isAt(Vector2d position)
    {
        return this.animalCoordinates.equals(position);
    }
    public Vector2d getAnimalCoordinates()
    {
        return this.animalCoordinates;
    }
    public MapDirection getAnimalOrientation()
    {
        return this.animalOrientation;
    }
    public void move(MoveDirection direction) {
        switch (direction)
        {
            case LEFT ->
            {
                this.animalOrientation=this.animalOrientation.previous();
            }
            case RIGHT ->
            {
                this.animalOrientation=this.animalOrientation.next();

            }
            case FORWARD ->
            {
                Vector2d movecandidate =  new Vector2d(this.animalCoordinates.getX(), this.animalCoordinates.getY());
                movecandidate =movecandidate.add(this.animalOrientation.toUnitVector());
                if ( movecandidate.precedes(MAP_MAX_POINT) && movecandidate.follows(MAP_MIN_POINT) )
                {
                    this.animalCoordinates = movecandidate;


                }

            }
            case BACKWARD -> {
                Vector2d movecandidate = new Vector2d(this.animalCoordinates.getX(), this.animalCoordinates.getY());
                movecandidate = movecandidate.add(this.animalOrientation.toUnitVector().opposite());
                if (movecandidate.precedes(MAP_MAX_POINT) && movecandidate.follows(MAP_MIN_POINT)) {
                    this.animalCoordinates = movecandidate;
                }
            }
        }
    }
}
