package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrassTest {
    @Test
    void testToString() {
        //given
        Grass grass = new Grass(new Vector2d(2, 2));

        //when
        String result = grass.toString();

        //then
        assertEquals("*",result);
    }

    @Test
    void testGetPosition() {
        //given
        Grass grass = new Grass(new Vector2d(2, 2));

        //when
        Vector2d result= grass.getPosition();

        //then
        assertEquals(new Vector2d(2, 2),result);
    }
}