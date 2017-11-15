
import java.util.Random;

import calculadora.colecoes.Matriz;
import calculadora.colecoes.MatrizExpressao;

class TestesManuais {

	public static void main(String[] args) {
		MatrizExpressao m = new MatrizExpressao(
				new Integer[][] { { 2, 3, 7, 8 }, { 1, 0, 6, 5 },
						{ 9, 6, 2, 3 }, { 0, 4, 7, 4 } });

		Random r = new Random();
		String[][] m1 = new String[100][100];
		String[][] m2 = new String[100][100];

		double tempo = 0;
		for (int k = 0; k < 20; k++) {
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				m1[i][j] = String.valueOf(r.nextInt(100));
			}
		}

		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				m2[i][j] = String.valueOf(r.nextInt(100));
			}
		}

		MatrizExpressao ma1 = new MatrizExpressao(m1);
		MatrizExpressao ma2 = new MatrizExpressao(m2);

		long ini = System.currentTimeMillis();
		Matriz<String> mo = ma1.multiplica(ma2);
		long fim = System.currentTimeMillis();
		tempo += (((double)fim - ini)/1000);
	}

		System.out.println("Tempo médio: "+(((double)tempo)/20)+"s.");
	}

}
