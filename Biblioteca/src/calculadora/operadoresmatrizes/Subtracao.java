package calculadora.operadoresmatrizes;

import calculadora.colecoes.Matriz;

public class Subtracao<T> extends Soma<T> {

	@Override
	public Matriz<T> calcula(Matriz<T> m1, Matriz<T> m2) {
		avalia(m1, m2);

		Matriz<T> resultado = m1.getNovaInstancia(m1.getTamanhoLinhas(),
				m1.getTamanhoColunas());

		for (int i = 0; i < m1.getTamanhoLinhas(); i++) {
			for (int j = 0; j < m1.getTamanhoLinhas(); j++) {
				resultado.setElemento(i, j,
						m1.getElemento(i, j).subtrai(m2.getElemento(i, j)));
			}
		}

		return resultado;
	}

}
