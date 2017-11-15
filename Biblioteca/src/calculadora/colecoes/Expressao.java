package calculadora.colecoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

import calculadora.utils.ExpressionParser;
import calculadora.utils.TratamentoString;

public class Expressao extends Elemento<String> {

	public Expressao() {
		this.valor = "0";
	}

	public Expressao(Object valor) {
		this.valor = valor.toString();
	}

	@Override
	public Elemento<String> getNovaInstancia() {
		return new Expressao();
	}

	@Override
	public Elemento<String> getNovaInstancia(Object valor) {
		return new Expressao(valor.toString());
	}

	@Override
	public Elemento<String> soma(Elemento<String> el) {
		return new Expressao(ExpressionParser.evalToString(this.valor + "+" + el.valor));
	}

	@Override
	public Elemento<String> subtrai(Elemento<String> el) {
		return new Expressao(ExpressionParser.evalToString(this.valor + "-" + el.valor));
	}

	@Override
	public Elemento<String> multiplica(Elemento<String> el) {
		return new Expressao(ExpressionParser.evalToString("(" + this.valor + ")*(" + el.valor + ")"));
	}

	@Override
	public Elemento<String> divide(Elemento<String> el) {
		return new Expressao(ExpressionParser.evalToString("(" + this.valor + ")/(" + el.valor + ")"));
	}

	@Override
	public boolean equals(Elemento<String> el) {
		return compareTo(el) == 0;
	}

	@Override
	public int compareTo(Elemento<String> el) {
		return Double.valueOf(ExpressionParser.evalToDouble(this.valor)).compareTo(ExpressionParser.evalToDouble(el.valor));
	}

	@Override
	public String toString() {
		return TratamentoString.RemoveZerosDeExpressoes(valor.trim());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Expressao))
			return false;

		return this.equals(((Expressao) obj));
	}

	public Expressao Arredonda(int casas) {
		return new Expressao(new BigDecimal(ExpressionParser.evalToDouble(this.valor)).setScale(casas, RoundingMode.HALF_UP));
	}

}
