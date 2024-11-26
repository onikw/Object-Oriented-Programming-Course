package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {

    @Test
    public void testParseOptions() {
        //given
        String[] args = {"r", "b", "l", "f"};
        List<MoveDirection> expectedMoves = List.of(MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD);

        //when
        List<MoveDirection> results = OptionsParser.parse(args);

        //then
        assertEquals(expectedMoves, results);
    }

    @Test
    public void testParseOptionsWithException() {
        try{
            String[] args = {"r", "b", "l", "f", "s"};
            List<MoveDirection> expectedMoves = List.of(MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD);
            OptionsParser.parse(args);
        }
        catch(IllegalArgumentException e){
            assertEquals("s - illegal move",e.getMessage());
        }

    }

    @Test
    public void testParseOptionsWithoutException() {
        try{
            String[] args = {"r", "b", "l", "f"};
            List<MoveDirection> expectedMoves = List.of(MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD);
            List<MoveDirection> moves = OptionsParser.parse(args);
            assertEquals(expectedMoves,moves);
        }
        catch(IllegalArgumentException e){
            assertEquals("s - not legal move",e.getMessage());
        }


    }
}