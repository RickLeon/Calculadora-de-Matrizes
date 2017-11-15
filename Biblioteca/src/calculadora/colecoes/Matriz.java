package calculadora.colecoes;

public interface Matriz<T> {
	Elemento<T> getElemento(int linha, int coluna);

	void setElemento(int linha, int coluna, Elemento<T> el);

	int getTamanhoLinhas();

	int getTamanhoColunas();

	void remove(int linha, int coluna);

	Matriz<T> getNovaInstancia(int linhas, int colunas);

	default Matriz<T> getNovaInstancia() {
		return getNovaInstancia(getTamanhoLinhas(), getTamanhoColunas());
	}

	default Matriz<T> clona() {
		Matriz<T> m = getNovaInstancia(getTamanhoLinhas(), getTamanhoColunas());

		for (int i = 0; i < getTamanhoLinhas(); i++) {
			for (int j = 0; j < getTamanhoColunas(); j++) {
				m.setElemento(i, j, getElemento(i, j));
			}
		}

		return m;
	}

}
