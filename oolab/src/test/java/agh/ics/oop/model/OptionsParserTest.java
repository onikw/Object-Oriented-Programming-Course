package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void testParseOptions() {
        String[] args = {"r", "b", "l", "f"};
        MoveDirection[] expectedMoves = {MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD};
        assertArrayEquals(OptionsParser.parse(args), expectedMoves);
    }
}