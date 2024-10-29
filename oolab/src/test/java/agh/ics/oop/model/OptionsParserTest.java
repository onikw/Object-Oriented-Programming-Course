package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
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
}