package business;

public class Usuario {
	private String nome, cp, email;
	//cp = cadastro de pessoa (fisica ou juridica)
	
	public Usuario(String nome, String cp, String email){
		this.nome = nome;
		this.cp = cp;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCp() {
		return cp;
	}

	public String getEmail() {
		return email;
	}

}
