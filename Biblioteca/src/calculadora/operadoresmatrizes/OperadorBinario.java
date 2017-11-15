package calculadora.operadoresmatrizes;

import calculadora.colecoes.Matriz;

public interface OperadorBinario<T> {
	Matriz<T> calcula(Matriz<T> m1, Matriz<T> m2);
}
