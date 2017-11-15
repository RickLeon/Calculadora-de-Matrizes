package calculadora.utils;

import calculadora.excecoes.ExpressionParseException;

public class ExpressionParser {

	public static String evalToString(final String str) {
		return String.valueOf(parse(str));
	}

	public static double evalToDouble(final String str) {
		return parse(str);
	}

	/*
	 * Implementacao de um analisador descendente recursivo (recursive descent
	 * parser) para a compilacao e calculo das expressoes. A base do codigo foi
	 * retirada do Stack Overflow. Endereco para acesso:
	 * http://stackoverflow.com
	 * /questions/3422673/evaluating-a-math-expression-given-in-string-form O
	 * codigo original esta no dominio publico, detalhes em:
	 * https://creativecommons.org/publicdomain/zero/1.0/
	 */
	private static double parse(final String str) {
		double result = new Object() {
			int pos = -1, ch;

			void nextChar() {
				ch = (++pos < str.length()) ? str.charAt(pos) : -1;
			}

			boolean eat(int charToEat) {
				while (ch == ' ')
					nextChar();
				if (ch == charToEat) {
					nextChar();
					return true;
				}
				return false;
			}

			double parse() {
				nextChar();
				double x = parseExpression();
				if (pos < str.length())
					throw new ExpressionParseException("Inesperado: "
							+ (char) ch);
				return x;
			}

			// Grammar:
			// expression = term | expression "+" term | expression "-" term
			// term = factor | term "*" factor | term "/" factor
			// factor = "+" factor | "-" factor | "(" expression ")"
			// | number | functionName factor | factor "^" factor
			double parseExpression() {
				double x = parseTerm();
				for (;;) {
					if (eat('+'))
						x += parseTerm(); // addition
					else if (eat('-'))
						x -= parseTerm(); // subtraction
					else
						return x;
				}
			}

			double parseTerm() {
				double x = parseFactor();
				for (;;) {
					if (eat('*'))
						x *= parseFactor(); // multiplication
					else if (eat('/'))
						x /= parseFactor(); // division
					else
						return x;
				}
			}

			double parseFactor() {
				if (eat('+'))
					return parseFactor(); // unary plus
				if (eat('-'))
					return -parseFactor(); // unary minus

				double x;
				int startPos = this.pos;
				if (eat('(')) { // parentheses
					x = parseExpression();
					eat(')');
				} else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
					while ((ch >= '0' && ch <= '9') || ch == '.')
						nextChar();
					x = Double.parseDouble(str.substring(startPos, this.pos));
				} else if (ch >= 'a' && ch <= 'z') { // functions
					while (ch >= 'a' && ch <= 'z')
						nextChar();
					String func = str.substring(startPos, this.pos);
					x = parseFactor();
					if (func.equals("sqrt"))
						x = Math.sqrt(x);
					else if (func.equals("sin"))
						x = Math.sin(Math.toRadians(x));
					else if (func.equals("cos"))
						x = Math.cos(Math.toRadians(x));
					else if (func.equals("tan"))
						x = Math.tan(Math.toRadians(x));
					else
						throw new ExpressionParseException(
								"Função desconhecida: " + func);
				} else {
					throw new ExpressionParseException("Unexpected: "
							+ (char) ch);
				}

				if (eat('^'))
					x = Math.pow(x, parseFactor()); // exponentiation

				return x;
			}
		}.parse();

		return result;
	}

}
