package calculadora.operadoresmatrizes;

import calculadora.colecoes.Elemento;
import calculadora.colecoes.Matriz;
import calculadora.excecoes.MatrizInvalidaException;

public abstract class EliminacaoGaussiana<T> implements OperadorUnario<T> {

	public void aplicaEliminacaoGaussiana(Matriz<T> m, Boolean parcial) {

		// Instancia elementos que precisariam ser criados varias vezes
		Elemento<T> um = m.getElemento(0, 0).getNovaInstancia(1);
		Elemento<T> menosUm = m.getElemento(0, 0).getNovaInstancia(-1);
		Elemento<T> zero = m.getElemento(0, 0).getNovaInstancia(0);

		for (int i = 0; i < ((parcial == true) ? m.getTamanhoLinhas() - 1 : m.getTamanhoLinhas()); i++) {
			if (m.getElemento(i, i).equals(zero)) {
				for (int j = i + 1; j < m.getTamanhoLinhas(); j++) {
					if (!m.getElemento(j, i).equals(zero)) {
						permutaLinhas(m, i, j);
						evtPermutaLinhas(i, j);
						break;
					}
				}
			}

			if (m.getElemento(i, i).equals(zero))
				throw new MatrizInvalidaException("Não foi possível completar o método. O número a ser transformado em 1 na linha pivô é 0.");

			Elemento<T> razao = um.divide(m.getElemento(i, i));

			for (int j = 0; j < m.getTamanhoColunas(); j++) {
				m.setElemento(i, j, m.getElemento(i, j).multiplica(razao));
				evtMultiplicaLinhaPivo(i, j, razao);
			}
			evtEscolhaRazao(i, razao);

			for (int j = (parcial == true) ? i + 1 : 0; j < m.getTamanhoLinhas(); j++) {
				if (j != i) {
					if (m.getElemento(j, i).equals(zero))
						continue;

					Elemento<T> mult = m.getElemento(j, i).multiplica(menosUm);

					for (int k = 0; k < m.getTamanhoColunas(); k++) {
						m.setElemento(j, k, m.getElemento(j, k).soma(m.getElemento(i, k).multiplica(mult)));
						evtSomaProdutoALinha(i, j, k, mult);
					}

					evtSomaLinhas(i, j, mult);
				}
			}
		}

	}

	protected void permutaLinhas(Matriz<T> m, int l1, int l2) {
		for (int c = 0; c < m.getTamanhoColunas(); c++) {
			Elemento<T> temp = m.getElemento(l1, c);
			m.setElemento(l1, c, m.getElemento(l2, c));
			m.setElemento(l2, c, temp);
		}
	}


	protected void evtMultiplicaLinhaPivo(int i, int j, Elemento<T> razao) { }

	protected void evtSomaProdutoALinha(int pivo, int i, int j, Elemento<T> produto) { }

	protected void evtPermutaLinhas(int i, int j) { }

	protected void evtEscolhaRazao(int i, Elemento<T> razao) { }

	protected void evtSomaLinhas(int i, int j, Elemento<T> produto) { }
}
