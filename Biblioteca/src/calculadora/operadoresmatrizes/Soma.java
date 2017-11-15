package calculadora.operadoresmatrizes;

import calculadora.colecoes.Matriz;
import calculadora.excecoes.MatrizesIncompativeisException;

public class Soma<T> implements OperadorBinario<T> {

	@Override
	public Matriz<T> calcula(Matriz<T> m1, Matriz<T> m2) {
		avalia(m1, m2);

		Matriz<T> resultado = m1.getNovaInstancia(m1.getTamanhoLinhas(),
				m1.getTamanhoColunas());

		for (int i = 0; i < m1.getTamanhoLinhas(); i++) {
			for (int j = 0; j < m1.getTamanhoLinhas(); j++) {
				resultado.setElemento(i, j,
						m1.getElemento(i, j).soma(m2.getElemento(i, j)));
			}
		}

		return resultado;
	}

	protected void avalia(Matriz<T> m1, Matriz<T> m2) {
		if (m1.getTamanhoLinhas() != m2.getTamanhoLinhas()
				&& m1.getTamanhoColunas() != m2.getTamanhoColunas())
			throw new MatrizesIncompativeisException(
					"As matrizes possuem linhas e colunas de tamanhos diferentes.");
		else if (m1.getTamanhoLinhas() != m2.getTamanhoLinhas())
			throw new MatrizesIncompativeisException(
					"As matrizes possuem linhas de tamanhos diferentes.");
		else if (m1.getTamanhoColunas() != m2.getTamanhoColunas())
			throw new MatrizesIncompativeisException(
					"As matrizes possuem colunas de tamanhos diferentes.");
	}

}
