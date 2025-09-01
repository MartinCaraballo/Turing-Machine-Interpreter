package org.example.models;

public class Tape<T> {

    private final T[] values;
    private int currentIndex;

    public Tape(T[] tapeValues) {
        currentIndex = 0;
        values = tapeValues;
    }

    /**
     * Write a value in the tape.
     * @param value The value to write in the tape.
     * @param movement Move to the left or right after write.
     * @return The written element.
     */
    public T write(T value, TapeMovement movement) {
        values[currentIndex] = value;
        move(movement);

        return value;
    }

    /**
     * Read the element pointed in the tape.
     * @return Element pointed in the tape.
     */
    public T read() {
        return values[currentIndex];
    }

    /**
     * Returns a copy of the tape.
     * @return Tape cloned.
     */
    public T[] getTapeValues() {
        return values.clone();
    }

    /**
     * Move the pointer in the tape to left or right.
     * @param movement LEFT or RIGHT
     */
    private void move(TapeMovement movement) {
        switch (movement) {
            case LEFT:
                currentIndex--;
            case RIGHT:
                currentIndex++;
        }
    }
}
