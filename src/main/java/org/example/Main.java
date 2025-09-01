package org.example;

import org.example.Execution.Execution;
import org.example.models.State;
import org.example.models.Tape;
import org.example.models.TapeMovement;
import org.javatuples.Triplet;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        State<Character> initialState = new State<>(false);
        State<Character> secondState = new State<>(false);
        State<Character> thirdState = new State<>(true);

        Character[] tape = {'1', '0', '1', '0', '2'};
        Tape<Character> tapeObject = new Tape<>(tape);

        initialState.addNextState('1', new Triplet<>(
                'B', TapeMovement.RIGHT, secondState));
        secondState.addNextState('0', new Triplet<>(
                'Z', TapeMovement.RIGHT, initialState));
        initialState.addNextState('2', new Triplet<>(
                'C',  TapeMovement.LEFT, thirdState
        ));


        Execution<Character> execution = new Execution<>(initialState, tapeObject);
        System.out.println(Arrays.toString(execution.execute()));
    }
}