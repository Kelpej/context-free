package recur;

public class MainRecur {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("...........Recursive descent Home ....");

        System.out.println("\n===Analys Brackets ....");
        String[] bal = new String[]{"", "{}", "{", "([(){}])", "{}{[]()}()", "[()]",
                "{)}", "(][)", "()({}{()}[])"};
        Brackets br = new Brackets();

		for (String s : bal)
			System.out.println("... " + s + " analys: " + br.analys(s));

        System.out.println("\n===Analys grammar G ....");
        String[] sg = new String[]{"abb", "abcad", "abdbd", "abdbcdd", "abadbbcadbd"};
        ParserG pg = new ParserG();

		for (String s : sg)
			System.out.println("... " + s + " analys: " + pg.analys(s));

        System.out.println("\n===Analys RegExpr ....");
        String[] rs = new String[]{"0", "1|0", "1|2", "(ab|1)bb*", "a0b1(", "(ab)**|0",
                "(a*b*)(0*|ab)", "(ab(a*)"};
        RegExpr re = new RegExpr();

		for (String r : rs)
			System.out.println("... " + r + " analys: " + re.analys(r));

        System.out.println("\n===== Test Expr =====");
        String[] se = new String[]{"1+2-9*3-3", "(3*2-2)+(4-3)*1", "7", "5-6*", "((9))",
                "(7+7-7(3+2))", "3*4-2*5", "(7+7-7*(3+2))"};

        Expr exp = new Expr();

        System.out.println("\n===Analys Expr ....");
		for (String value : se)
			System.out.println("... " + value + " analys: " + exp.analys(value));

        System.out.println("\n===EvalLeft Expr ....");
		for (String s : se)
			System.out.println("... " + s + " evalLeft: " + exp.evalLeft(s));

        System.out.println("\n===EvalRigth Expr ....");
		for (String s : se)
			System.out.println("... " + s + " evalRigth: " + exp.evalRigth(s));

        System.out.println("\n===EvalPrior Expr ....");
		for (String s : se)
			System.out.println("... " + s + " evalPrior: " + exp.evalPrior(s));
    }

}
