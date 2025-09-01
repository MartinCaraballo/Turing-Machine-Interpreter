package org.example.models;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.HashMap;
import java.util.Map;

public class State<T> {

    private final boolean IS_ACCEPTABLE;
    private final Map<T, Triplet<T, TapeMovement, State<T>>> NEXT_STATE_MAP;

    public State(boolean isAcceptable) {
        this.IS_ACCEPTABLE = isAcceptable;
        NEXT_STATE_MAP = new HashMap<>();
    }

    /**
     * Add a next state to the current state.
     *
     * @param key the key that gets into the next state.
     * @param nextState Tuple with the value to write in the tape, the next tape movement (LEFT or RIGHT) and the next state.
     * @return The previous state or null if there was no previous state associated with the key.
     */
    public Triplet<T, TapeMovement, State<T>> addNextState(T key, Triplet<T, TapeMovement, State<T>> nextState) {
        return NEXT_STATE_MAP.put(key, nextState);
    }

    public Triplet<T, TapeMovement, State<T>> getNextState(T key) {
        return NEXT_STATE_MAP.get(key);
    }

    public boolean getIsAcceptable() {
        return IS_ACCEPTABLE;
    }

}