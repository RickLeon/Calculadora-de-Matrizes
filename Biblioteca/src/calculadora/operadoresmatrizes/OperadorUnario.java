package calculadora.operadoresmatrizes;

import calculadora.colecoes.Matriz;

public interface OperadorUnario<T> {
	Matriz<T> calcula(Matriz<T> m);
}
