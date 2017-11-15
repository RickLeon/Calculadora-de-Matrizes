package calculadora.colecoes;

import calculadora.utils.ExpressionParser;
import calculadora.utils.TratamentoString;

public class ExpressaoDescritiva extends Elemento<String> {

	public ExpressaoDescritiva() {
		this.valor = "0";
	}

	public ExpressaoDescritiva(Object valor) {
		this.valor = valor.toString();
	}

	@Override
	public Elemento<String> getNovaInstancia() {
		return new ExpressaoDescritiva();
	}

	@Override
	public Elemento<String> getNovaInstancia(Object valor) {
		return new ExpressaoDescritiva(valor.toString());
	}

	@Override
	public Elemento<String> soma(Elemento<String> el) {
		return new ExpressaoDescritiva(this.valor + " + " + el.valor);
	}

	@Override
	public Elemento<String> subtrai(Elemento<String> el) {
		return new ExpressaoDescritiva(this.valor + " - " + el.valor);
	}

	@Override
	public Elemento<String> multiplica(Elemento<String> el) {
		return new ExpressaoDescritiva(this.valor + " * " + el.valor);
	}

	@Override
	public Elemento<String> divide(Elemento<String> el) {
		return new ExpressaoDescritiva(this.valor + " / " + el.valor);
	}

	@Override
	public boolean equals(Elemento<String> el) {
return compareTo(el) == 0;
	}

	@Override
	public int compareTo(Elemento<String> el) {
		return Double.valueOf(ExpressionParser.evalToDouble(removeCoordenadas(this.valor))).compareTo(ExpressionParser.evalToDouble(removeCoordenadas(el.valor)));
	}

	@Override
	public String toString() {
		return TratamentoString.RemoveZerosDeExpressoes(valor.trim());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ExpressaoDescritiva))
			return false;

		return ((ExpressaoDescritiva) obj).toString().equals(this.toString());
	}

	private String removeCoordenadas(String val) {
		return val.replaceAll("\\w*\\(\\d+, \\d+\\):", "").replaceAll("= \\-*\\d+\\.*\\d*", "");
	}

}
