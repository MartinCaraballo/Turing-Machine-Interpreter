package org.example.models;

public class Tape<T> {

    private final T[] values;
    private int currentIndex;

    public Tape(T[] tapeValues) {
        currentIndex = 0;
        values = tapeValues;
    }

    public T write(T value, TapeMovement movement) {
        values[currentIndex] = value;
        move(movement);

        return value;
    }

    private void move(TapeMovement movement) {
        switch (movement) {
            case LEFT:
                currentIndex++;
            case RIGHT:
                currentIndex--;
        }
    }
}
