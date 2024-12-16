package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int change_count=1;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.printf("%d %s - Map type and map ID: %s%n", change_count,message,worldMap.getId());
        synchronized (this) {change_count++;}
        System.out.println(worldMap);
    }
}
