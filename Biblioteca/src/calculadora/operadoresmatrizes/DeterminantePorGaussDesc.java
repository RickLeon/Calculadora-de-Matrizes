package calculadora.operadoresmatrizes;

import java.util.ArrayList;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.ExpressaoDescritiva;
import calculadora.colecoes.Matriz;
import calculadora.colecoes.MatrizDescritiva;

public class DeterminantePorGaussDesc extends DeterminantePorGauss<String> {
	private Matriz<String> mCalculo;
	private MatrizDescritiva mDesc;

	@Override
	public Matriz<String> calcula(Matriz<String> m) {
		if (m.getTamanhoLinhas() != m.getTamanhoColunas())
			throw new IllegalArgumentException(
					"Para calcular a determinante a matriz precisa ser quadrada.");

		mCalculo = m.clona();
		mDesc = new MatrizDescritiva(1, 1);
		mDesc.setQuadros(new ArrayList<Matriz<String>>());
		int ordem = m.getTamanhoLinhas();
		det = new ExpressaoDescritiva(1);
		menosUm = new ExpressaoDescritiva(-1);
		um = new ExpressaoDescritiva(1);

		aplicaEliminacaoGaussiana(mCalculo, true);

		for (int i = 0; i < ordem; i++) {
			det = det.multiplica(mCalculo.getElemento(i, i));
			adicionaQuadro();
		}

		return mDesc;
	}

	@Override
	protected void evtPermutaLinhas(int i, int j) {
		det = det.multiplica(menosUm);
		adicionaQuadro();
	}

	@Override
	protected void evtEscolhaRazao(int i, Elemento<String> razao) {
		det = det.multiplica(um.divide(razao));
		adicionaQuadro();
	}

	private void adicionaQuadro() {
		Matriz<String> mTemp = new MatrizDescritiva(1, 1);
		mTemp.setElemento(0, 0, det);
		mDesc.getQuadros().add(mTemp);
		mDesc.getQuadros().add(mCalculo.clona());
	}

}
