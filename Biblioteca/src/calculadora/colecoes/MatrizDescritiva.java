package calculadora.colecoes;

import java.util.List;

public class MatrizDescritiva extends MatrizBase<String> {
	private Elemento<String>[][] representacao;

	// Os quadros servem para gravar os estados das tabelas em algumas operacoes
	private List<Matriz<String>> quadros;

	public MatrizDescritiva(Matriz<?> m) {
		representacao = new ExpressaoDescritiva[m.getTamanhoLinhas()][m
				.getTamanhoColunas()];

		for (int i = 0; i < m.getTamanhoLinhas(); i++) {
			for (int j = 0; j < m.getTamanhoColunas(); j++) {
				representacao[i][j] = new ExpressaoDescritiva("(" + (i + 1) + ", " + (j + 1) + "): " + m.getElemento(i, j).valor.toString());
			}
		}
	}

	public MatrizDescritiva(Matriz<?> m, String variavel) {
		representacao = new ExpressaoDescritiva[m.getTamanhoLinhas()][m
				.getTamanhoColunas()];

		for (int i = 0; i < m.getTamanhoLinhas(); i++) {
			for (int j = 0; j < m.getTamanhoColunas(); j++) {
				representacao[i][j] = new ExpressaoDescritiva(variavel+"(" + (i + 1) + ", " + (j + 1) + "): " + m.getElemento(i, j).valor.toString());
			}
		}
	}

	public MatrizDescritiva(int linhas, int colunas) {
		representacao = new ExpressaoDescritiva[linhas][colunas];
	}

	@Override
	public Elemento<String> getElemento(int linha, int coluna) {
		return (representacao[linha][coluna] == null) ? new ExpressaoDescritiva()
				: representacao[linha][coluna];
	}

	@Override
	public void setElemento(int linha, int coluna, Elemento<String> exp) {
		representacao[linha][coluna] = exp;
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

	@Override
	public Matriz<String> getNovaInstancia(int linhas, int colunas) {
		return new MatrizDescritiva(linhas, colunas);
	}

	public List<Matriz<String>> getQuadros() {
		return quadros;
	}

	public void setQuadros(List<Matriz<String>> quadros) {
		this.quadros = quadros;
	}

}
