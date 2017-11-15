package calculadora.operadoresmatrizes;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.Matriz;
import calculadora.excecoes.MatrizInvalidaException;

public class DeterminantePorSarrus<T> implements OperadorUnario<T> {

	@Override
	public Matriz<T> calcula(Matriz<T> m) {
		if (m.getTamanhoLinhas() != 3 && m.getTamanhoColunas() != 3)
			throw new MatrizInvalidaException("O método de Sarrus so pode ser aplicado em matrizes de ordem 3..");

		Elemento<T> el1 = m.getElemento(0, 0);
		el1 = el1.multiplica(m.getElemento(1, 1));
		el1 = el1.multiplica(m.getElemento(2, 2));

		Elemento<T> el2 = m.getElemento(0, 1);
		el2 = el2.multiplica(m.getElemento(1, 2));
		el2 = el2.multiplica(m.getElemento(2, 0));

		Elemento<T> el3 = m.getElemento(0, 2);
		el3 = el3.multiplica(m.getElemento(1, 0));
		el3 = el3.multiplica(m.getElemento(2, 1));

		Elemento<T> d1 = el1.soma(el2).soma(el3);

		el1 = m.getElemento(0, 2);
		el1 = el1.multiplica(m.getElemento(1, 1));
		el1 = el1.multiplica(m.getElemento(2, 0));

		el2 = m.getElemento(0, 0);
		el2 = el2.multiplica(m.getElemento(1, 2));
		el2 = el2.multiplica(m.getElemento(2, 1));

		el3 = m.getElemento(0, 1);
		el3 = el3.multiplica(m.getElemento(1, 0));
		el3 = el3.multiplica(m.getElemento(2, 2));

		Elemento<T> d2 = el1.soma(el2).soma(el3);

Elemento<T> elResultado = d1.subtrai(d2);
Matriz<T> mResultado = m.getNovaInstancia(1, 1);
mResultado.setElemento(0, 0, elResultado);

		return mResultado;
	}

}
