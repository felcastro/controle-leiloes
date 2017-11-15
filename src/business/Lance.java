package business;

import java.sql.Timestamp;
import java.util.Date;

public class Lance {
	private double valor;
	private Timestamp data;
	private String dono, donoId;
	
	public Lance(double valor, String dono, String donoId, Timestamp data){
		this.donoId = donoId;
		this.valor = valor;
		this.dono = dono;
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public Date getData() {
		return data;
	}

	public String getDono() {
		return dono;
	}
	
	public String getDonoId() {
		return donoId;
	}
	
	public String toString() {
		String str = "Dono: " + dono + ", Valor: " + valor + ", Data: " + data.toLocaleString();
		return str;
	}
}
