package unittests.calculadora.operadoresmatrizes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculadora.colecoes.Matriz;
import calculadora.colecoes.MatrizExpressao;
import calculadora.operadoresmatrizes.DeterminantePorGauss;
import calculadora.operadoresmatrizes.DeterminantePorLaplace;
import calculadora.operadoresmatrizes.OperadorUnario;

@RunWith(Parameterized.class)
public class DeterminantesDeQualquerOrdemTests {

	@Parameters
	public static Collection<Object[]> operadores() {
return Arrays.asList(new Object[][] {{ new DeterminantePorLaplace<String>() }, { new DeterminantePorGauss<String>()} });
	}

	private OperadorUnario<String> det;

	public DeterminantesDeQualquerOrdemTests(OperadorUnario<String> op) {
		det = op;
	}

	@Test
	public void Deve_Calcular_Determinante_De_Matriz_De_Ordem_1() {
		// Arrange
		Matriz<String> m = new MatrizExpressao(
				new Integer[][] { 
						{ 2 }
						});

		Matriz<String> resultadoEsperado = new MatrizExpressao(
				new Integer[][] { { 2 } });

		// Act
		Matriz<String> resultadoObtido = det.calcula(m);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	public void Deve_Calcular_Determinante_De_Matriz_De_Ordem_2() {
		// Arrange
		Matriz<String> m = new MatrizExpressao(
				new Integer[][] { 
						{ 2, -1 },
						{ 10, 5 }
						});

		Matriz<String> resultadoEsperado = new MatrizExpressao(
				new Integer[][] { { 20 } });

		// Act
		Matriz<String> resultadoObtido = det.calcula(m);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	public void Deve_Calcular_Determinante_De_Matriz_De_Ordem_3() {
		// Arrange
		Matriz<String> m = new MatrizExpressao(
				new Integer[][] {
						{4, 2, 8}, 
						{9, 3, 6}, 
						{10, 4, 18}
						});

		Matriz<String> resultadoEsperado = new MatrizExpressao(
				new Integer[][] { { -36 } });

		// Act
		Matriz<String> resultadoObtido = det.calcula(m);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	public void Deve_Calcular_Determinante_De_Matriz_De_Ordem_4() {
		// Arrange
		Matriz<String> m = new MatrizExpressao(
				new Integer[][] { 
						{ 2, 0, 1, 4 }, 
						{ -1, 2, 1, 0 },
						{ 6, 0, 3, 2 }, 
						{ 4, 1, 1, 2 } 
						});

		Matriz<String> resultadoEsperado = new MatrizExpressao(
				new Integer[][] { { -70 } });

		// Act
		Matriz<String> resultadoObtido = det.calcula(m);

		// Assert
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}

}
