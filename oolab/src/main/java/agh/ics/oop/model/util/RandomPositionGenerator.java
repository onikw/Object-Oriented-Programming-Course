package agh.ics.oop.model.util;

import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final int maxWidth;
    private final int maxHeight;
    private final int count;
    private final ArrayList<Vector2d> allPositions;

    public RandomPositionGenerator(int maxWidth, int maxHeight, int count) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.count = count;
        this.allPositions = generateAllPositions();
    }

    private ArrayList<Vector2d> generateAllPositions() {
        ArrayList<Vector2d> positions = new ArrayList<>();
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {
                positions.add(new Vector2d(x, y));
            }
        }
        return positions;
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new Iterator<>() {
            private int generatedCount = 0;
            final Random random = new Random();


            @Override
            public boolean hasNext() {
                return generatedCount < count;
            }

            @Override
            public Vector2d next() {
                if (!hasNext()) {
                    throw new UnsupportedOperationException("No more positions to generate");
                }


                Vector2d position;


                int randomNumber = random.nextInt(count*count-generatedCount);
                position = allPositions.get(randomNumber);
                allPositions.remove(randomNumber);
                //losuje pozycje z listy wszystkich pozycji
                //nasteþnie ja usuwam żeby uniknac duplikatow
                generatedCount++;
                return position;
            }
        };
    }
}