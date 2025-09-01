package org.example.models;

import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class State<T> {

    private final boolean isAcceptable;
    private final Map<Pair<T, TapeMovement>, State<T>> nextStateMap;

    public State(boolean isAcceptable) {
        this.isAcceptable = isAcceptable;
        nextStateMap = new HashMap<>();
    }

    /**
     * Add a next state to the current state.
     *
     * @param keyTuple  Tuple with the key that gets into the next state and a TapeMovement value representing the next tape movement.
     * @param nextState the next state to move to
     * @return The previous state or null if there was no previous state associated with the key.
     */
    public State<T> addNextState(Pair<T, TapeMovement> keyTuple, State<T> nextState) {
        return nextStateMap.put(keyTuple, nextState);
    }

    public boolean getIsAcceptable() {
        return isAcceptable;
    }

}