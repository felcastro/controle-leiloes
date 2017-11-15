package business;

import java.util.List;

public class Lote {

	private List<Item> itens;
	private List<Lance> lances;

	public Lote(List<Item> itens, List<Lance> lances) {
		this.itens = itens;
		this.lances = lances;
	}

	public List<Item> getItens() {
		return itens;
	}
	
	public List<Lance> getLances() {
		return lances;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public String toString() {
		String str = "";
		String itensStr = "Itens:\n";
		for (int i = 0; i < itens.size(); i++) {
			itensStr += itens.get(i).toString() + "\n";
		}
		str += itensStr;
		
		String lancesStr = "Lances:\n";
		if (lances.size() == 0) {
			lancesStr += "Nada para apresentar.\n";
		} else {
			for (int i = 0; i < lances.size(); i++) {
				lancesStr += lances.get(i).toString() + "\n";
			}
		}
		str += lancesStr;
		
		return str;
	}
}
