package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void testEquals() {
        // given
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(2, 3);

        // when & then
        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
    }

    @Test
    public void testToString() {
        // given
        Vector2d v1 = new Vector2d(1, 2);

        // when
        String result = v1.toString();

        // then
        assertEquals("(1,2)", result);
    }

    @Test
    public void testPrecedes() {
        // given
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);

        // when & then
        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
    }

    @Test
    public void testFollows() {
        // given
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(1, 2);

        // when & then
        assertTrue(v1.follows(v2));
        assertFalse(v2.follows(v1));
    }

    @Test
    public void testUpperRight() {
        // given
        Vector2d v1 = new Vector2d(1, 10);
        Vector2d v2 = new Vector2d(10, 1);
        Vector2d v3 = new Vector2d(10, 10);

        // when
        Vector2d result1 = v1.upperRight(v2);
        Vector2d result2 = v2.upperRight(v1);

        // then
        assertEquals(v3, result1);
        assertEquals(v3, result2);
    }

    @Test
    public void testLowerLeft() {
        // given
        Vector2d v1 = new Vector2d(1, 10);
        Vector2d v2 = new Vector2d(10, 1);
        Vector2d v3 = new Vector2d(1, 1);

        // when
        Vector2d result1 = v1.lowerLeft(v2);
        Vector2d result2 = v2.lowerLeft(v1);

        // then
        assertEquals(v3, result1);
        assertEquals(v3, result2);
    }

    @Test
    public void testAdd() {
        // given
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 1);
        Vector2d v3 = new Vector2d(3, 3);

        // when
        Vector2d result = v1.add(v2);

        // then
        assertEquals(v3, result);
    }

    @Test
    public void testSubtract() {
        // given
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);
        Vector2d v3 = new Vector2d(-1, -1);

        // when
        Vector2d result = v1.subtract(v2);

        // then
        assertEquals(v3, result);
    }

    @Test
    public void testOpposite() {
        // given
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-1, -2);

        // when
        Vector2d result = v1.opposite();

        // then
        assertEquals(v2, result);
    }
}
