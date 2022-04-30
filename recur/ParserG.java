package recur;

import recur.util.Grammar;

import java.util.List;
import java.util.ListIterator;

public class ParserG {
    private static final Grammar grammar =
            new Grammar("S ->abABd,  S -> abb, A -> aAb, A -> d, B -> BcA, B -> b");
    private static final List<Grammar.Transition> transitions = grammar.getTransitions();
    private final ListIterator<Grammar.Transition> transitionIterator = transitions.listIterator();

    private Word input;
    private char next;

    public boolean analys(String word) {
        input = new Word(word);
        return true;
    }

    private void match(char c) throws SyntaxError {
        if (next == c)
            next = input.nextChar();
        else throw new SyntaxError("Expecting " + c + ", found " + next);
    }


}
