package calculadora.colecoes;

import calculadora.operadoresmatrizes.DeterminantePorLaplace;
import calculadora.operadoresmatrizes.InversaPorGauss;
import calculadora.operadoresmatrizes.MultiplicacaoComum;
import calculadora.operadoresmatrizes.Soma;
import calculadora.operadoresmatrizes.Subtracao;

public abstract class MatrizBase<T> implements Matriz<T> {

	public Matriz<T> soma(Matriz<T> m) {
return new Soma<T>().calcula(this, m);
	}

	public Matriz<T> subtrai(Matriz<T> m) {
		return new Subtracao<T>().calcula(this, m);
	}

	public Matriz<T> multiplica(Matriz<T> m) {
		return new MultiplicacaoComum<T>().calcula(this, m);
	}

	public Elemento<T> determinante() {
		return new DeterminantePorLaplace<T>().calcula(this).getElemento(0, 0);
	}

	public Matriz<T> inversa() {
		return new InversaPorGauss<T>().calcula(this);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		s.append("{\n");
		for (int i = 0; i < getTamanhoLinhas() - 1; i++) {
			s.append("{ ");
			for (int j = 0; j < getTamanhoColunas() - 1; j++) {
				s.append(getElemento(i, j));
				s.append(", ");
			}
			s.append(getElemento(i, getTamanhoColunas() - 1));
			s.append(" },\n");
		}

		s.append("{ ");
		for (int j = 0; j < getTamanhoColunas() - 1; j++) {
			s.append(getElemento(getTamanhoLinhas() - 1, j));
			s.append(", ");
		}
		s.append(getElemento(getTamanhoLinhas() - 1, getTamanhoColunas() - 1));
		s.append(" }\n");

		s.append("}");

		return s.toString();
	}

		@Override
		public boolean equals(Object obj) {

			if (!(obj instanceof MatrizBase<?>))
				return false;

			MatrizBase<?> m = (MatrizBase<?>) obj;

			if (getTamanhoLinhas() != m.getTamanhoLinhas()
					|| getTamanhoColunas() != m.getTamanhoColunas())
				return false;

			for (int i = 0; i < getTamanhoLinhas(); i++) {
				for (int j = 0; j < getTamanhoColunas(); j++) {
					if (!this.getElemento(i, j).equals(m.getElemento(i, j)))
						return false;
				}
			}

			return true;
		}

		@Override
		public int hashCode() {
			int hashSum = 0;

			for (int i = 0; i < getTamanhoLinhas(); i++) {
				for (int j = 0; j < getTamanhoColunas(); j++) {
					hashSum += getElemento(i, j).hashCode();
				}
			}

			return hashSum;
		}

}
