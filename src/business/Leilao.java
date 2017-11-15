package business;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Leilao {
	private String id, dono, donoId, natureza, formaLances;
	private Timestamp inicio, termino;
	private List<Lote> lotes;
	private double valor;
	public Leilao(String id, String dono, String donoId, String natureza, String formaLances, Timestamp inicio, Timestamp termino, List<Lote> lotes, double valor){
		this.id = id;
		this.dono = dono;
		this.donoId = donoId;
		this.natureza = natureza;
		this.formaLances = formaLances;
		this.inicio = inicio;
		this.termino = termino;
		this.lotes = lotes;
		this.valor = valor;
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
	public List<Lote> getLotes(){
		return lotes;
	}
	public String getDonoId(){
		return donoId;
	}
	public double getValor(){
		return valor;
	}
	
	public String getId(){
		return id;
	}
	
	public String toString(){
		String lotesStr = "";
		for (int i = 0; i < lotes.size(); i++) {
			lotesStr += "\nLote ID: " + (i + 1);
			lotesStr += "\n" + lotes.get(i).toString();
		}
		String str = "\nLeilão ID: " + id
				+ "\nDono: " + dono
				+ "\nNatureza: " + natureza
				+ "\nForma lance: " + formaLances
				+ "\nData inicio: " + inicio.toLocaleString()
				+ "\nData fim: " + termino.toLocaleString()
				+ "\nValor limite: " + valor 
				+ lotesStr;
		return str;
	}
}
