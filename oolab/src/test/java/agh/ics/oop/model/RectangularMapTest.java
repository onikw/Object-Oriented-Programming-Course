package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void CanMoveToTakenPlace(){
        //GIVEN
        WorldMap newRecMap = new RectangularMap(4, 4);
        Animal animal1 = new Animal();

        //WHEN
        newRecMap.place(animal1);

        //THEN
        assertTrue(newRecMap.canMoveTo(new Vector2d(2, 3)));
        assertFalse(newRecMap.canMoveTo(new Vector2d(2, 2)));
    }


    @Test
    public void MapCreateAndMoveWithinBorders(){
        //GIVEN
        WorldMap newRecMap = new RectangularMap(4, 4);
        Animal animal = new Animal();

        //WHEN
        newRecMap.place(animal);
        newRecMap.move(animal, MoveDirection.FORWARD);

        //THEN
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }



    @Test
    public void CanMoveOutsideBorder(){
        //GIVEN
        WorldMap newRecMap = new RectangularMap(4, 4);
        Animal animal1 = new Animal(new Vector2d(2, 3));

        //WHEN
        animal1.move(MoveDirection.FORWARD, newRecMap);
        animal1.move(MoveDirection.FORWARD, newRecMap);


        //THEN
        assertEquals(animal1.getPosition(), new Vector2d(2, 4));
    }

    @Test
    public void testPlace(){
        //GIVEN
        WorldMap newRecMap = new RectangularMap(4, 4);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2, 3));

        //WHEN
        animal1.move(MoveDirection.FORWARD, newRecMap);

        //THEN
        assertTrue(newRecMap.place(animal1));
        assertFalse(newRecMap.place(animal2));
    }

    @Test
    public void testMove(){
        //GIVEN
        WorldMap newRecMap = new RectangularMap(4, 4);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(3, 2));
        animal1.move(MoveDirection.RIGHT, newRecMap);
        animal1.move(MoveDirection.RIGHT, newRecMap);

        //WHEN
        newRecMap.place(animal1);
        newRecMap.place(animal2);
        newRecMap.move(animal1, MoveDirection.FORWARD);
        newRecMap.move(animal2, MoveDirection.FORWARD);

        //THEN
        assertEquals(new Vector2d(2, 1), animal1.getPosition());
        assertEquals(new Vector2d(3, 3), animal2.getPosition());
    }

}