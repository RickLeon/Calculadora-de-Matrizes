package calculadora.colecoes;

public abstract class Elemento<T> implements Comparable<Elemento<T>> {
	protected T valor;

	public T getValor() {
		return valor;
	}

	public abstract Elemento<T> getNovaInstancia();

	public abstract Elemento<T> getNovaInstancia(Object valor);

	public abstract Elemento<T> soma(Elemento<T> el);

	public abstract Elemento<T> subtrai(Elemento<T> el);

	public abstract Elemento<T> multiplica(Elemento<T> el);

	public abstract Elemento<T> divide(Elemento<T> el);

	public abstract boolean equals(Elemento<T> el);

	@Override
	public String toString() {
		return valor.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Elemento<?>))
			return false;

		Elemento<?> el = (Elemento<?>) obj;

		return this.getValor().equals(el.getValor());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

}
