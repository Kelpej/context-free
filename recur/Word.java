package recur;

public class Word {
    // $ - end of string
    String input;
    int p = 0;
    char c;

    public Word(String input) {
        this.input = input;
    }

    public char nextChar() {
        if (p < input.length())
            c = input.charAt(p++);
        else
            c = '$';
        return c;
    }
}
