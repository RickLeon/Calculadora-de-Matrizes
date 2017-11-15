package calculadora.operadoresmatrizes;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.Matriz;

public class InversaPorGauss<T> extends EliminacaoGaussiana<T> {
	protected Matriz<T> mInversa;

	@Override
	public Matriz<T> calcula(Matriz<T> m) {
		if (m.getTamanhoLinhas() != m.getTamanhoColunas())
			throw new IllegalArgumentException(
					"Para calcular a inversa a matriz precisa ser quadrada.");

		m = m.clona();
		int ordem = m.getTamanhoLinhas();
		mInversa = m.getNovaInstancia();

		// Cria matriz identidade
		for (int i = 0; i < ordem; i++)
			mInversa.setElemento(i, i, m.getElemento(0, 0).getNovaInstancia(1));

		aplicaEliminacaoGaussiana(m, false);

		Matriz<T> mResultado = mInversa;
		mInversa = null;

		return mResultado;
	}

	@Override
	protected void evtPermutaLinhas(int i, int j) {
permutaLinhas(mInversa, i, j);
	}

	@Override
	protected void evtMultiplicaLinhaPivo(int i, int j, Elemento<T> razao) {
		mInversa.setElemento(i, j, mInversa.getElemento(i, j).multiplica(razao));
	}

@Override
protected void evtSomaProdutoALinha(int i, int j, int k, Elemento<T> produto) {
	mInversa.setElemento(j, k, mInversa.getElemento(j, k)
			.soma(mInversa.getElemento(i, k)
					.multiplica(produto)));
}

}
