package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    void testToString()
    {
        //given
        Animal animal = new Animal();

        //when
        String result = animal.toString();

        //then
        assertEquals("^",result);
    }

    @Test
    void testGetPosition() {
        //given
        Animal animal = new Animal();

        //when
        Vector2d result= animal.getPosition();

        //then
        assertEquals(new Vector2d(2, 2),result);
    }

    @Test
    void testGetDirection() {
        //given
        Animal animal = new Animal();

        //when
        MapDirection result = animal.getAnimalOrientation();

        //then
        assertEquals(MapDirection.NORTH,result);
    }
}