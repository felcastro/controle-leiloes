package business;

import java.util.List;

public class Lote {

	private int valor;
	private List<Item> itens;

	public Lote(int valor, List<Item> itens) {
		this.valor = valor;
		this.itens = itens;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
