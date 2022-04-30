package recur;

public class Brackets {
	Word input;
	char next;	
	public Brackets(){ }
	
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
