package agh.ics.oop.model;

public class IncorrectPositionException extends Exception {
    private static final String ERROR_MESSAGE="Position %s is incorrect";
    public IncorrectPositionException(Vector2d place) {
        super(String.format(ERROR_MESSAGE,place));

    }
}
