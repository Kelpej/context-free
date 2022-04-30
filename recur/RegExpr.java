package recur;

public class RegExpr {
    Word input;
    char next;

    public boolean analys(String word) {
        // ... statements
        return true;
    }

    private void match(char c) throws SyntaxError {
        if (next == c)
            next = input.nextChar();
        else throw new SyntaxError("Expecting " + c + ", found " + next);
    }
}
