package calculadora.operadoresmatrizes;

import calculadora.colecoes.Matriz;

public class Transposta<T> implements OperadorUnario<T> {

	@Override
	public Matriz<T> calcula(Matriz<T> m) {
		Matriz<T> mResultado = m.getNovaInstancia(m.getTamanhoColunas(), m.getTamanhoLinhas());

		for (int i = 0; i < m.getTamanhoLinhas(); i++) {
			for (int j = 0; j < m.getTamanhoColunas(); j++) {
				mResultado.setElemento(j, i, m.getElemento(i, j));
			}
		}

		return mResultado;
	}

}
