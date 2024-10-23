package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void testEquals() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        Vector2d v3 = new Vector2d(2,3);
        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
    }

    @Test
    public void testToString() {
        Vector2d v1 = new Vector2d(1,2);
        assertEquals("(1,2)",v1.toString());
    }

    @Test
    public void testPrecedes() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,3);
        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
    }

    @Test
    public void testFollows() {
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(1,2);
        assertTrue(v1.follows(v2));
        assertFalse(v2.follows(v1));

    }

    @Test
    public void testUpperRight() {
        Vector2d v1 = new Vector2d(1,10);
        Vector2d v2 = new Vector2d(10,1);
        Vector2d v3 = new Vector2d(10,10);
        assertEquals(v1.upperRight(v2),v3);
        assertEquals(v2.upperRight(v1),v3);

    }

    @Test
    public void testLowerLeft() {
        Vector2d v1 = new Vector2d(1,10);
        Vector2d v2 = new Vector2d(10,1);
        Vector2d v3 = new Vector2d(1,1);
        assertEquals(v1.lowerLeft(v2),v3);
        assertEquals(v2.lowerLeft(v1),v3);

    }

    @Test
    public void testAdd() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(3,3);
        assertEquals(v1.add(v2),v3);
    }

    @Test
    public void testSubtract() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,3);
        Vector2d v3 = new Vector2d(-1,-1);
        assertEquals(v1.subtract(v2),v3);
    }

    @Test
    public void testOpposite() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(-1,-2);
        assertEquals(v1.opposite(),v2);
    }
}