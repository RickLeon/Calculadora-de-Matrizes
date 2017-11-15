package calculadora.operadoresmatrizes;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.Matriz;

public class DeterminantePorLaplace<T> extends Cofatores<T> {

	@Override
	public Matriz<T> calcula(Matriz<T> m) {
		if (m.getTamanhoLinhas() != m.getTamanhoColunas())
			throw new IllegalArgumentException(
					"Para calcular a determinante a matriz precisa ser quadrada.");

		Matriz<T> r = m.getNovaInstancia(1, 1);
		r.setElemento(0, 0, det(m));

		return r;
	}

	private Elemento<T> det(Matriz<T> m) {
		if (m.getTamanhoLinhas() == 1)
			return m.getElemento(0, 0);

		// Comeca em elemento com valor nao 0 para evitar a soma por zeros na descricao do calculo
		Elemento<T> det = m.getElemento(0, 0).getNovaInstancia(Math.pow(-1, 0))
				.multiplica(m.getElemento(0, 0))
				.multiplica(det(getMenorComplementar(m, 0, 0)));

		for (int j = 1; j < m.getTamanhoLinhas(); j++) {
			det = det.soma(det.getNovaInstancia(Math.pow(-1, j))
					.multiplica(m.getElemento(0, j))
					.multiplica(det(getMenorComplementar(m, 0, j))));
		}

		return det;
	}

}
