package recur;

public class Expr {
	Word input;
	char next;	
	public Expr(){}
	
	public boolean analys(String word){
		// ... statements
		return true;
	}
	// .... methods
	// ......
	// ......

	//--------------------------------------------------------
	public Integer evalLeft(String word){
		// ... statements
		return null;
	}
	// .... methods
	// ......
	// ......
	
	//-------------
	public Integer evalRigth(String word){
		// ... statements
		return null;
	}
	// .... methods
	// ......
	// ......
	
 	//------------------------------------------
	public Integer evalPrior(String word){
		// ... statements
		return null;
	}
	// .... methods
	// ......
	// ......
	private void match(char c) throws SyntaxError{
		if(next == c) next=input.nextChar();
		else throw new SyntaxError("Expecting " + c + ", found " + next);
	}
}
