package calculadora.utils;

public final class TratamentoString {

	public static String RemoveZerosDeExpressoes(String exp) {
		exp = exp.indexOf(".") < 0 ? exp : exp
				.replaceAll("0*$", "")
				.replaceAll("\\.$", "");

		return exp;
	}

}
