package unittests.calculadora.operadoresmatrizes;

import org.junit.Assert;
import org.junit.Test;

import calculadora.colecoes.Matriz;
import calculadora.colecoes.MatrizBase;
import calculadora.colecoes.MatrizExpressao;
import calculadora.excecoes.MatrizesIncompativeisException;
import calculadora.operadoresmatrizes.OperadorBinario;
import calculadora.operadoresmatrizes.Soma;

public class SomaTest {

	@Test
	public void Soma_Duas_Matrizes_De_Ordem_1() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
						{ "1" }
						});

		MatrizBase<String> m2 = new MatrizExpressao(
				new String[][] {
				{ "5" } 
				});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(new String[][] {
				{ "6" }
				});

		OperadorBinario<String> opSoma = new Soma<String>();

		// Act
		Matriz<String> resultadoObtido = opSoma.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	public void Soma_Duas_Matrizes_De_Ordem_2() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
				{ "1", "2" },
				{ "3", "4" }
				});

		MatrizBase<String> m2 = new MatrizExpressao(
				new String[][] {
				{ "5", "6" },
				{ "7", "8" }
				});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(
				new String[][] {
				{ "6", "8" },
				{ "10", "12" }
				});

		OperadorBinario<String> opSoma = new Soma<String>();

		// Act
		Matriz<String> resultadoObtido = opSoma.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test(expected = MatrizesIncompativeisException.class)
	public void Nao_Deve_Efetuar_Soma_De_Duas_Matrizes_De_Ordens_Diferentes() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
				{ "1", "2" },
				{ "3", "4" }
				});

		MatrizBase<String> m2 = new MatrizExpressao(
				new String[][] {
				{ "5", "6",
					"1" }, { "7", "8", "9" }, { "4", "6", "8" }
					});

		OperadorBinario<String> opSoma = new Soma<String>();

		// Act
		opSoma.calcula(m1, m2);
	}

}
