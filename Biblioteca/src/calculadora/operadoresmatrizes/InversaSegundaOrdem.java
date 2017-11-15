package calculadora.operadoresmatrizes;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.Matriz;
import calculadora.excecoes.MatrizInvalidaException;

public class InversaSegundaOrdem<T> implements OperadorUnario<T> {
	private DeterminanteSegundaOrdem<T> opDet;

public InversaSegundaOrdem() {
	this.opDet = new DeterminanteSegundaOrdem<T>();
}

	@Override
	public Matriz<T> calcula(Matriz<T> m) {
		if (m.getTamanhoLinhas() != 2 || m.getTamanhoColunas() != 2)
			throw new MatrizInvalidaException("A matriz precisa ser de ordem 2.");

		m = m.clona();

		int ordem = m.getTamanhoLinhas();
		Elemento<T> det = opDet.calcula(m).getElemento(0, 0);
		Elemento<T> um = m.getElemento(0, 0).getNovaInstancia(1);
		Elemento<T> menosUm = m.getElemento(0, 0).getNovaInstancia(-1);

		Elemento<T> el1 = m.getElemento(0, 0);
		Elemento<T> el2 = m.getElemento(1, 1);
		m.setElemento(0, 0, el2);
		m.setElemento(1, 1, el1);
		m.setElemento(0, 1, m.getElemento(0, 1).multiplica(menosUm));
		m.setElemento(1, 0, m.getElemento(1, 0).multiplica(menosUm));

		for (int i = 0; i < ordem; i++) {
			for (int j = 0; j < ordem; j++) {
				m.setElemento(i, j, m.getElemento(i, j).multiplica(um.divide(det)));
			}
		}

		return m;
	}

}
