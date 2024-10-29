package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

    @Test
    public void SimulationRunWithinBorders() {
        //GIVEN
        List<MoveDirection> directions = new ArrayList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2, 2));
        Simulation simulation = new Simulation(positions, directions);


        //WHEN
        simulation.Run();
        List<Animal> animals = simulation.getAnimals();

        //THEN
        assertEquals(1, animals.size());
        for (Animal animal : animals) {
            assertTrue(animal.getAnimalCoordinates().equals(new Vector2d(2, 2)));
            assertTrue(animal.getAnimalCoordinates().follows(new Vector2d(0, 0)));
            assertTrue(animal.getAnimalCoordinates().precedes(new Vector2d(4, 4)));
        }
    }

    @Test
    public void SimulationRunNotValidMoves() {
        //GIVEN
        List<MoveDirection> directions = new ArrayList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.BACKWARD);
        directions.add(MoveDirection.BACKWARD);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0, 0));
        Simulation simulation = new Simulation( positions, directions);

        //WHEN
        simulation.Run();
        List<Animal> animals = simulation.getAnimals();


        assertEquals(1, animals.size());

        for (Animal animal : animals) {
            assertSame(animal.getAnimalOrientation(), MapDirection.EAST);
            assertTrue(animal.getAnimalCoordinates().equals(new Vector2d(0, 1)));
        }
    }
    @Test
    public void SimulationRunWithTwoAnimals(){

        //GIVEN
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(1, 1));
        Simulation simulation = new Simulation(positions, directions);


        //WHEN
        simulation.Run();
        List<Animal> animals = simulation.getAnimals();


        //THEN
        assertEquals(3, animals.size());
        for (Animal animal : animals) {
            assertTrue(animal.getAnimalCoordinates().follows(new Vector2d(0, 0)));
            assertTrue(animal.getAnimalCoordinates().precedes(new Vector2d(4, 4)));
        }

        Animal animal = animals.get(0);
        assertTrue(animal.getAnimalOrientation() == MapDirection.NORTH);
        assertTrue(animal.getAnimalCoordinates().equals(new Vector2d(2, 4)));
    }
}