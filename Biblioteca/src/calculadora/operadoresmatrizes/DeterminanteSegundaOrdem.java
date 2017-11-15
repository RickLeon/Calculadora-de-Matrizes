package calculadora.operadoresmatrizes;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.Matriz;
import calculadora.excecoes.MatrizInvalidaException;

public class DeterminanteSegundaOrdem<T> implements OperadorUnario<T> {

	@Override
	public Matriz<T> calcula(Matriz<T> m) {
		if (m.getTamanhoLinhas() != 2 && m.getTamanhoColunas() != 2)
			throw new MatrizInvalidaException("A matriz precisa ser de ordem 2.");

Elemento<T> d1 = m.getElemento(0, 0).multiplica(m.getElemento(1, 1));
Elemento<T> d2 = m.getElemento(0, 1).multiplica(m.getElemento(1, 0));

Matriz<T> mResultado = m.getNovaInstancia(1, 1);
mResultado.setElemento(0, 0, d1.subtrai(d2));

return mResultado;
	}

}
