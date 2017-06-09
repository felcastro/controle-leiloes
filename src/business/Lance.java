package business;

import java.util.Date;

public class Lance {
	private double valor;
	private Date data;
	private Usuario dono;
	
	public Lance(double valor, Usuario dono, Date data){
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

	public Usuario getDono() {
		return dono;
	}
}
