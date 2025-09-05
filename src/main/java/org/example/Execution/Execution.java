package org.example.Execution;

import org.example.models.State;
import org.example.models.Tape;
import org.example.models.TapeMovement;
import org.javatuples.Triplet;

public class Execution<T> {

    private State<T> actualState;
    private final Tape<T> TAPE;

    public Execution(State<T> initialState, Tape<T> tape) {
        actualState = initialState;
        TAPE = tape;
    }

    /**
     * Execute reading the tape, writing and moving into the corresponding next state evaluating the value in the tape.
     * @return A copy of the elements in the tape.
     */
    public T[] execute() {
        T actualElement = TAPE.read();
        Triplet<T, TapeMovement, State<T>> nextStateTuple = actualState.getNextState(actualElement);
        State<T> nextState = nextStateTuple.getValue2();

        while (nextState != null) {
            TAPE.write(nextStateTuple.getValue0(),  nextStateTuple.getValue1());

            actualState = nextStateTuple.getValue2();
            actualElement = TAPE.read();
            nextStateTuple = actualState.getNextState(actualElement);

            if (nextStateTuple == null) {
                break;
            }
            nextState = nextStateTuple.getValue2();
        }

        if (!this.actualState.getIsAcceptable()) {
            throw new RuntimeException("State is not acceptable");
        }

        return TAPE.getTapeValues();
    }
}
