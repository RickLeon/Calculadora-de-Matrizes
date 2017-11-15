package unittests.calculadora.operadoresmatrizes;

import org.junit.Assert;
import org.junit.Test;

import calculadora.colecoes.Matriz;
import calculadora.colecoes.MatrizBase;
import calculadora.colecoes.MatrizExpressao;
import calculadora.excecoes.MatrizesIncompativeisException;
import calculadora.operadoresmatrizes.MultiplicacaoComum;
import calculadora.operadoresmatrizes.OperadorBinario;

public class MultiplicacaoTest {

	@Test
	public void Multiplica_Duas_Matrizes_De_Ordem_1() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
						{ "2" }
						});

		MatrizBase<String> m2 = new MatrizExpressao(
				new String[][] {
				{ "5" } 
				});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(new String[][] {
				{ "10" }
				});

		OperadorBinario<String> opMultiplicacao = new MultiplicacaoComum<String>();

		// Act
		Matriz<String> resultadoObtido = opMultiplicacao.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	public void Multiplica_Duas_Matrizes_De_Ordem_2() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
						{ "2", "3" },
						{ "5", "6" }
						});

		MatrizBase<String> m2 = new MatrizExpressao(
				new String[][] {
				{ "5", "2" },
				{ "3", "6" }
				});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(
				new String[][] {
						{ "19", "22" },
						{ "43", "46" }
						});

		OperadorBinario<String> opMultiplicacao = new MultiplicacaoComum<String>();

		// Act
		Matriz<String> resultadoObtido = opMultiplicacao.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	public void Multiplica_Matriz_Linha_Por_Matriz_De_Ordem_2() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
						{ "2", "4" }
						});

		MatrizBase<String> m2 = new MatrizExpressao(
				new String[][] {
				{ "5", "2" },
				{ "3", "6" }
				});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(
				new String[][] {
						{ "22", "28" },
						});

		OperadorBinario<String> opMultiplicacao = new MultiplicacaoComum<String>();

		// Act
		Matriz<String> resultadoObtido = opMultiplicacao.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	public void Multiplica_Matriz_De_Ordem_2_Por_Matriz_Coluna() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
				{ "5", "2" },
				{ "3", "6" }
				});

		MatrizBase<String> m2 = new MatrizExpressao(
				new String[][] {
						{ "2"},
						{ "4" }
						});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(
				new String[][] {
						{ "18"},
						{"30" },
						});

		OperadorBinario<String> opMultiplicacao = new MultiplicacaoComum<String>();

		// Act
		Matriz<String> resultadoObtido = opMultiplicacao.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	public void Multiplica_Matriz_Linha_Por_Matriz_Coluna() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
						{ "3", "6" }
						});

		MatrizBase<String> m2 = new MatrizExpressao(
		new String[][] {
				{ "2"},
				{ "4" }
				});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(
				new String[][] {
						{"30" }
						});

		OperadorBinario<String> opMultiplicacao = new MultiplicacaoComum<String>();

		// Act
		Matriz<String> resultadoObtido = opMultiplicacao.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	public void Multiplica_Matriz_Coluna_Por_Matriz_Linha() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
						{ "2"},
						{ "4" }
						});

		MatrizBase<String> m2 = new MatrizExpressao(
						new String[][] {
								{ "3", "6" }
								});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(
				new String[][] {
						{ "6", "12" },
						{ "12", "24" }
						});

		OperadorBinario<String> opMultiplicacao = new MultiplicacaoComum<String>();

		// Act
		Matriz<String> resultadoObtido = opMultiplicacao.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test(expected = MatrizesIncompativeisException.class)
	public void Nao_Deve_Multiplicar_Matrizes_Com_Numero_De_Colunas_Diferente_Do_Numero_De_Linhas() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
						{ "3", "6", "9" }
						});

		MatrizBase<String> m2 = new MatrizExpressao(
		new String[][] {
				{ "2"},
				{ "4" }
				});

		OperadorBinario<String> opMultiplicacao = new MultiplicacaoComum<String>();

		// Act
		opMultiplicacao.calcula(m1, m2);
	}

}
