package business;

public class Usuario {
	private String nome, cp, email, senha;
	//cp = cadastro de pessoa (fisica ou juridica)
	
	public Usuario(String nome, String cp, String email, String senha){
		this.nome = nome;
		this.cp = cp;
		this.email = email;
		this.senha = senha;
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
	
	public String getSenha() {
		return senha;
	}

	public String toString() {
		String str = "[" + nome + "," + cp + "," + email + "]";
		return str;
	}
}
