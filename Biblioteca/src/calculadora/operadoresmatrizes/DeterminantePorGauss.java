package calculadora.operadoresmatrizes;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.Matriz;

public class DeterminantePorGauss<T> extends EliminacaoGaussiana<T> {
	protected Elemento<T> det;
	protected Elemento<T> um;
	protected Elemento<T> menosUm;

	@Override
	public Matriz<T> calcula(Matriz<T> m) {
		if (m.getTamanhoLinhas() != m.getTamanhoColunas())
			throw new IllegalArgumentException(
					"Para calcular a determinante a matriz precisa ser quadrada.");

		m = m.clona();
		int ordem = m.getTamanhoLinhas();
		det = m.getElemento(0, 0).getNovaInstancia(1);
		menosUm = m.getElemento(0, 0).getNovaInstancia(-1);
		um = m.getElemento(0, 0).getNovaInstancia(1);

		aplicaEliminacaoGaussiana(m, true);

		// Multiplica o resultados das operacoes nas linhas pela diagonal da
		// matriz triangular superior
		for (int i = 0; i < ordem; i++) {
			det = det.multiplica(m.getElemento(i, i));
		}

		Matriz<T> mResultado = m.getNovaInstancia(1, 1);
		mResultado.setElemento(0, 0, det);

		det = null;

		return mResultado;
	}

	@Override
	protected void evtPermutaLinhas(int i, int j) {
		det = det.multiplica(menosUm);
	}

	@Override
	protected void evtEscolhaRazao(int i, Elemento<T> razao) {
		det = det.multiplica(um.divide(razao));
	}

}
