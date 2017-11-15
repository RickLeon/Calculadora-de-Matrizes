package calculadora.operadoresmatrizes;

import java.util.ArrayList;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.ExpressaoDescritiva;
import calculadora.colecoes.Matriz;
import calculadora.colecoes.MatrizDescritiva;
import calculadora.colecoes.MatrizExpressao;

public class SolucaoSistemasLinearesDesc extends
		SolucaoSistemasLineares<String> {
	private MatrizExpressao mCalculo;
	private MatrizDescritiva mDescricao;

	@Override
	public Matriz<String> calcula(Matriz<String> m) {
avalia(m);

		mCalculo = (MatrizExpressao) m.clona();
		mDescricao = new MatrizDescritiva(1, 1);
		mDescricao.setQuadros(new ArrayList<Matriz<String>>());

		aplicaEliminacaoGaussiana(mCalculo, false);

		return mDescricao;
	}

	@Override
	protected void evtSomaLinhas(int i, int j, Elemento<String> produto) {
		adicionaQuadro("l" + (i + 1) + " * " + produto + " + l" + (j + 1));
	}

	@Override
	protected void evtPermutaLinhas(int i, int j) {
		adicionaQuadro("permuta l" + (i + 1) + " e l" + (j + 1));
	}

	@Override
	protected void evtEscolhaRazao(int i, Elemento<String> razao) {
		adicionaQuadro("l" + (i + 1) + " * " + razao);
	}

	private void adicionaQuadro(String mensagem) {
		MatrizDescritiva mTemp = new MatrizDescritiva(1, 1);
		mTemp.setElemento(0, 0, new ExpressaoDescritiva(mensagem));
		mDescricao.getQuadros().add(mTemp);
		mDescricao.getQuadros().add(mCalculo.clona());
	}
}
