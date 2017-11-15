package calculadora.operadoresmatrizes;

import java.util.ArrayList;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.ExpressaoDescritiva;
import calculadora.colecoes.Matriz;
import calculadora.colecoes.MatrizDescritiva;

public class InversaPorGaussDesc extends InversaPorGauss<String> {
	private Matriz<String> mCalculo;
	private MatrizDescritiva mDesc;

	@Override
	public Matriz<String> calcula(Matriz<String> m) {
		if (m.getTamanhoLinhas() != m.getTamanhoColunas())
			throw new IllegalArgumentException(
					"Para calcular a inversa a matriz precisa ser quadrada.");

		mDesc = new MatrizDescritiva(1, 1);
		mDesc.setQuadros(new ArrayList<Matriz<String>>());
		mCalculo = m.clona();
		int ordem = m.getTamanhoLinhas();
		mInversa = m.getNovaInstancia();

		for (int i = 0; i < ordem; i++)
			mInversa.setElemento(i, i, m.getElemento(0, 0).getNovaInstancia(1));

		adicionaQuadro("");

		aplicaEliminacaoGaussiana(mCalculo, false);

		return mDesc;
	}

	@Override
	protected void evtSomaLinhas(int i, int j, Elemento<String> produto) {
		adicionaQuadro("l" + (i + 1) + " * " + produto + " + l" + (j + 1));
	}

	@Override
	protected void evtPermutaLinhas(int i, int j) {
		adicionaQuadro("permuta l" + (i + 1) + " e l" + (j + 1));
		super.evtPermutaLinhas(i, j);
	}

	@Override
	protected void evtEscolhaRazao(int i, Elemento<String> razao) {
		adicionaQuadro("l" + (i + 1) + " * " + razao);
	}

	private void adicionaQuadro(String mensagem) {
		Matriz<String> mTemp = new MatrizDescritiva(1, 1);
		mTemp.setElemento(0, 0, new ExpressaoDescritiva(mensagem));
		mDesc.getQuadros().add(mTemp);
		mDesc.getQuadros().add(mCalculo.clona());
		mDesc.getQuadros().add(mInversa.clona());
	}

}
