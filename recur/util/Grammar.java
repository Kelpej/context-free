package recur.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Grammar {
    public static final class Transition {
        private static final Pattern transitionPattern = Pattern.compile("\\s*[\\w\\W]*\\s*->\\s*[\\w\\W]*\\s*");

        private final String nonTerminal;
        private final String substitute;

        Transition(String nonTerminal, String substitute) {
            this.nonTerminal = nonTerminal;
            this.substitute = substitute;
        }

        Transition(String transition) {
            Matcher isTransition = transitionPattern.matcher(transition);
            if (isTransition.matches()) {
                String[] parameters = Arrays.stream(transition.split("->"))
                        .map(s -> s.replaceAll(" ", ""))
                        .toArray(String[]::new);

                this.nonTerminal = parameters[0];
                this.substitute = parameters[1].replaceFirst("ε", "");
            } else {
                throw new IllegalArgumentException(transition + " is inappropriate.");
            }
        }

        @Override
        public String toString() {
            return "Transition{" +
                    "nonTerminal='" + nonTerminal + '\'' +
                    ", substitute='" + substitute + '\'' +
                    '}';
        }

        public String getNonTerminal() {
            return nonTerminal;
        }

        public String getSubstitute() {
            return substitute;
        }
    }

    private final Set<Character> terminals;
    private final Set<Character> nonTerminals;
    private final List<Transition> transitions;

    public Grammar(String transitions) {
        this.transitions = Arrays.stream(transitions.split(","))
                .filter(transition -> !transition.isEmpty())
                .map(Transition::new)
                .collect(Collectors.toCollection(ArrayList::new));

        this.nonTerminals = this.transitions.stream()
                .map(Transition::getSubstitute)
                .map(String::chars)
                .flatMap(intStream -> intStream.mapToObj(i -> (char) i))
                .filter(Grammar::isNonTerminal)
                .collect(Collectors.toSet());

        this.terminals = this.transitions.stream()
                .map(Transition::getSubstitute)
                .map(String::chars)
                .flatMap(intStream -> intStream.mapToObj(i -> (char) i))
                .filter(character -> !isNonTerminal(character) && character != 'ε')
                .collect(Collectors.toSet());
    }

    public Grammar(String nonTerminals, String terminals, String transitions) {
        this.transitions = Arrays.stream(transitions.split(","))
                .filter(transition -> !transition.isEmpty())
                .map(Transition::new)
                .collect(Collectors.toCollection(ArrayList::new));

        this.nonTerminals = nonTerminals.replaceAll("[ ,]+", "").chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toSet());

        this.terminals = terminals.replaceAll("[ ,]+", "").chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toSet());
    }

    private static boolean isNonTerminal(char character) {
        return Character.isLetter(character) && Character.isUpperCase(character);
    }

    public boolean isNonTerminalPresent(char nonTerminal) {
        return nonTerminals.contains(nonTerminal);
    }

    public boolean isTerminalPresent(char terminal) {
        return terminals.contains(terminal);
    }

    public boolean isValid(String word) {
        return word.chars().mapToObj(i -> (char) i).anyMatch(character -> !isNonTerminalPresent(character) &&
                !isTerminalPresent(character));
    }

    @Override
    public String toString() {
        return "Grammar{" +
                "nonTerminals=" + nonTerminals +
                ", terminals=" + terminals +
                ", transitions=" + transitions +
                '}';
    }

    public Set<Character> getTerminals() {
        return terminals;
    }

    public Set<Character> getNonTerminals() {
        return nonTerminals;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }
}
