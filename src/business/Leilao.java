package business;

import java.util.Date;

public class Leilao {
	private String dono, natureza, formaLances;
	private Date inicio, termino;
	public Leilao(String dono, String natureza, String formaLances, Date inicio, Date termino){
		this.dono = dono;
		this.natureza = natureza;
		this.formaLances = formaLances;
		this.inicio = inicio;
		this.termino = termino;
	}
	public String getDono() {
		return dono;
	}
	public String getNatureza() {//oferta ou demanda
		return natureza;
	}
	public String getFormaLances() {//aberto ou fechado
		return formaLances;
	}
	public Date getInicio() {
		return inicio;
	}
	public Date getTermino() {
		return termino;
	}
}
