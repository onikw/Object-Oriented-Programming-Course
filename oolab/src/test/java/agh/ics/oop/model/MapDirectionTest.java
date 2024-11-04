package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class MapDirectionTest {
    @Test
    public void testMapDirectionNext() {
        //given
        MapDirection Polnoc = MapDirection.NORTH;
        MapDirection Wschod = MapDirection.EAST;
        MapDirection Poludnie = MapDirection.SOUTH;
        MapDirection Zachod = MapDirection.WEST;

        //when
        MapDirection NewPolnoc = MapDirection.WEST.next();
        MapDirection NewWschod = MapDirection.NORTH.next();
        MapDirection NewPoludnie = MapDirection.EAST.next();
        MapDirection NewZachod = MapDirection.SOUTH.next();

        //then
        assertEquals(Polnoc, NewPolnoc);
        assertEquals(Wschod, NewWschod);
        assertEquals(Poludnie, NewPoludnie);
        assertEquals(Zachod, NewZachod);
    }

    @Test
    public void testMapDirectionPrev() {
        //given
        MapDirection Polnoc = MapDirection.NORTH;
        MapDirection Wschod = MapDirection.EAST;
        MapDirection Poludnie = MapDirection.SOUTH;
        MapDirection Zachod = MapDirection.WEST;

        //when
        MapDirection NewPolnoc = MapDirection.EAST.previous();
        MapDirection NewWschod = MapDirection.SOUTH.previous();
        MapDirection NewPoludnie = MapDirection.WEST.previous();
        MapDirection NewZachod = MapDirection.NORTH.previous();

        //then
        assertEquals(Polnoc, NewPolnoc);
        assertEquals(Wschod, NewWschod);
        assertEquals(Poludnie, NewPoludnie);
        assertEquals(Zachod, NewZachod);
    }




}