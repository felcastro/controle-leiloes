package business;

public class Item {

	private String descricaoBreve;
	private String descricaoCompleta;
	private Categoria categoria;

	public Item(String descricaoBreve, String descricaoCompleta, Categoria categoria) {
		this.descricaoBreve = descricaoBreve;
		this.descricaoCompleta = descricaoCompleta;
		this.categoria = categoria;
	}

	public String getDescricaoBreve() {
		return descricaoBreve;
	}

	public void setDescricaoBreve(String descricaoBreve) {
		this.descricaoBreve = descricaoBreve;
	}

	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}

	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
