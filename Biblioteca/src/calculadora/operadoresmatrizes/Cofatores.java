package calculadora.operadoresmatrizes;

import calculadora.colecoes.Matriz;

public abstract class Cofatores<T> implements OperadorUnario<T> {

	protected Matriz<T> getMenorComplementar(Matriz<T> m, int i, int j) {
		Matriz<T> mc = m.getNovaInstancia(m.getTamanhoLinhas() - 1,
				m.getTamanhoColunas() - 1);
		int r = 0, s = 0;

		for (int l = 0; l < m.getTamanhoLinhas(); l++) {
			if (l != i) {
				for (int c = 0; c < m.getTamanhoColunas(); c++) {
					if (c != j) {
						mc.setElemento(r, s++, m.getElemento(l, c));
					}
				}
				r++;
				s = 0;
			}
		}

		return mc;
	}

}
