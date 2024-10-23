package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void testMapDirectionNext() {
        MapDirection Polnoc = MapDirection.NORTH;
        MapDirection Wschod = MapDirection.EAST;
        MapDirection Poludnie = MapDirection.SOUTH;
        MapDirection Zachod = MapDirection.WEST;

        assertEquals(Zachod.next(), Polnoc);
        assertEquals(Polnoc.next(), Wschod);
        assertEquals(Wschod.next(), Poludnie);
        assertEquals(Poludnie.next(), Zachod);

    }

    @Test
    public void testMapDirectionPrev() {
        MapDirection Polnoc = MapDirection.NORTH;
        MapDirection Wschod = MapDirection.EAST;
        MapDirection Poludnie = MapDirection.SOUTH;
        MapDirection Zachod = MapDirection.WEST;
        assertEquals(Wschod.previous(), Polnoc);
        assertEquals(Poludnie.previous() , Wschod);
        assertEquals(Zachod.previous(), Poludnie);
        assertEquals(Polnoc.previous(), Zachod);

    }




}