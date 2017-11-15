package calculadora.operadoresmatrizes;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.Matriz;
import calculadora.excecoes.MatrizesIncompativeisException;

public class MultiplicacaoComum<T> implements OperadorBinario<T> {

	@Override
	public Matriz<T> calcula(Matriz<T> m1, Matriz<T> m2) {
		avalia(m1, m2);

		Matriz<T> resultado = m1.getNovaInstancia(m1.getTamanhoLinhas(), m2.getTamanhoColunas());

		for (int i = 0; i < m1.getTamanhoLinhas(); i++) {
			for (int j = 0; j < m2.getTamanhoColunas(); j++) {
				// Inicializa-se o elemento com o produto das posicoes k= 0 para que na descricao nao se some os produtos a 0
				Elemento<T> el = m1.getElemento(i, 0).multiplica(m2.getElemento(0, j));

				for (int k = 1; k < m1.getTamanhoColunas(); k++) {
					el = el.soma(m1.getElemento(i, k).multiplica(m2.getElemento(k, j)));
				}

				resultado.setElemento(i, j, el);
			}
		}

		return resultado;
	}

	private void avalia(Matriz<T> m1, Matriz<T> m2) {
		if (m1.getTamanhoColunas() != m2.getTamanhoLinhas())
			throw new MatrizesIncompativeisException(
					"Linhas e colunas não são iguais.");
	}

}
