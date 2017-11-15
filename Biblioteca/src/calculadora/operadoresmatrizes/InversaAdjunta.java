package calculadora.operadoresmatrizes;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.Matriz;

public class InversaAdjunta<T> extends Cofatores<T> {
	private DeterminantePorGauss<T> opDet;
	private Transposta<T> opTransposta;

	public InversaAdjunta() {
		this.opDet = new DeterminantePorGauss<T>();
		this.opTransposta = new Transposta<T>();
	}

	@Override
	public Matriz<T> calcula(Matriz<T> m) {
		if (m.getTamanhoLinhas() != m.getTamanhoColunas())
			throw new IllegalArgumentException(
					"Para calcular a inversa a matriz precisa ser quadrada.");

		Matriz<T> mInversa = m.getNovaInstancia();
		Elemento<T> det = opDet.calcula(m).getElemento(0, 0);

		for (int i = 0; i < m.getTamanhoLinhas(); i++) {
			for (int j = 0; j < m.getTamanhoColunas(); j++) {
				mInversa.setElemento(i, j, 
						opDet.calcula(getMenorComplementar(m, i, j)).getElemento(0, 0)
						.multiplica(m.getElemento(0, 0).getNovaInstancia(Math.pow(-1, i + j)))
						.divide(det));
			}
		}

		Matriz<T> mResultado = opTransposta.calcula(mInversa);
		mInversa = null;

		return mResultado;
	}

}
