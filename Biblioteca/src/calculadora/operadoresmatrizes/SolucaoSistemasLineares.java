package calculadora.operadoresmatrizes;

import calculadora.colecoes.Matriz;
import calculadora.excecoes.MatrizInvalidaException;

public class SolucaoSistemasLineares<T> extends EliminacaoGaussiana<T> {

	@Override
	public Matriz<T> calcula(Matriz<T> m) {
		avalia(m);

		m = m.clona();

		aplicaEliminacaoGaussiana(m, false);

		return copiaColuna(m, m.getTamanhoColunas() - 1);
	}

	protected Matriz<T> copiaColuna(Matriz<T> m, int c) {
		Matriz<T> mRes = m.getNovaInstancia(m.getTamanhoLinhas(), 1);

		for (int i = 0; i < m.getTamanhoLinhas(); i++) {
			mRes.setElemento(i, 0, m.getElemento(i, c));
		}

		return mRes;
	}

	protected void avalia(Matriz<T> m) {
		if (m.getTamanhoLinhas() == m.getTamanhoColunas())
			throw new MatrizInvalidaException(
					"A matriz não pode ser quadrada, é preciso ter uma coluna para os resultados.");
		else if (m.getTamanhoLinhas() > m.getTamanhoColunas())
			throw new MatrizInvalidaException(
					"Há mais linhas do que colunas na matriz.");
	}

}
