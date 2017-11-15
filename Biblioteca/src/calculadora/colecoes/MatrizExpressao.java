package calculadora.colecoes;

public class MatrizExpressao extends MatrizBase<String> {
	private Elemento<String>[][] representacao;

	public MatrizExpressao(int tamLinhas, int tamColunas) {
		representacao = new Expressao[tamLinhas][tamColunas];
	}

	public MatrizExpressao(String[][] m) {
		if (!isMatrizRetangular(m))
throw new IllegalArgumentException("O array bidimencional passado pelo construtor não é retangular.");

		representacao = new Expressao[m.length][m[0].length];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				representacao[i][j] = new Expressao(m[i][j]);
			}
		}
	}

	public MatrizExpressao(Object[][] m) {
		if (!isMatrizRetangular(m))
throw new IllegalArgumentException("O array bidimencional passado pelo construtor não é retangular.");

		representacao = new Expressao[m.length][m[0].length];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				representacao[i][j] = new Expressao(m[i][j]);
			}
		}
	}



	@Override
	public Elemento<String> getElemento(int linha, int coluna) {
		return (representacao[linha][coluna] == null) ? new Expressao() : representacao[linha][coluna];
	}

	@Override
	public void setElemento(int linha, int coluna, Elemento<String> el) {
		representacao[linha][coluna] = el;
	}

	@Override
	public int getTamanhoLinhas() {
		return representacao.length;
	}

	@Override
	public int getTamanhoColunas() {
		return representacao[0].length;
	}

	@Override
	public void remove(int linha, int coluna) {
		representacao[linha][coluna] = null;
	}

	private boolean isMatrizRetangular(Object[][] m) {
		int tamanhoColunas = m[0].length;

		for (int i = 0; i < m.length; i++) {
			if (m[i].length != tamanhoColunas)
				return false;
		}

		return true;
	}

	@Override
	public Matriz<String> getNovaInstancia(int linhas, int colunas) {
return new MatrizExpressao(linhas, colunas);
	}

}
