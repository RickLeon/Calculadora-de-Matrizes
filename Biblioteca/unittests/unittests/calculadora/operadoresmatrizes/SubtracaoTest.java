package unittests.calculadora.operadoresmatrizes;

import org.junit.Assert;
import org.junit.Test;

import calculadora.colecoes.Matriz;
import calculadora.colecoes.MatrizBase;
import calculadora.colecoes.MatrizExpressao;
import calculadora.excecoes.MatrizesIncompativeisException;
import calculadora.operadoresmatrizes.OperadorBinario;
import calculadora.operadoresmatrizes.Subtracao;

public class SubtracaoTest {

	@Test
	public void Subtrai_Duas_Matrizes_De_Ordem_1() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(
				new String[][] {
						{ "6" }
						});

		MatrizBase<String> m2 = new MatrizExpressao(
				new String[][] {
				{ "1" } 
				});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(
				new String[][] {
				{ "5" }
				});

		OperadorBinario<String> opSubtracao = new Subtracao<String>();

		// Act
		Matriz<String> resultadoObtido = opSubtracao.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	public void Subtrai_Duas_Matrizes_De_Ordem_2() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(new String[][] {
				{ "1", "2" },
				{ "3", "4" }
				});

		MatrizBase<String> m2 = new MatrizExpressao(new String[][] {
				{ "5", "6" },
				{ "7", "8" }
				});

		MatrizBase<?> resultadoEsperado = new MatrizExpressao(new String[][] {
				{ "-4", "-4" },
				{ "-4", "-4" }
				});

		OperadorBinario<String> opSubtracao = new Subtracao<String>();

		// Act
		Matriz<String> resultadoObtido = opSubtracao.calcula(m1, m2);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test(expected = MatrizesIncompativeisException.class)
	public void Nao_Deve_Efetuar_Subtracao_De_Duas_Matrizes_De_Ordens_Diferentes() {

		// Arrange
		MatrizBase<String> m1 = new MatrizExpressao(new String[][] {
				{ "1", "2" }, 
				{ "3", "4" } 
				});

		MatrizBase<String> m2 = new MatrizExpressao(new String[][] {
				{ "5", "6", "1" }, 
				{ "7", "8", "9" }, 
				{ "4", "6", "8" } 
				});

		OperadorBinario<String> opSubtracao = new Subtracao<String>();

		// Act
		opSubtracao.calcula(m1, m2);
	}

}
