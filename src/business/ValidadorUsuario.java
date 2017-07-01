package business;

public class ValidadorUsuario {

	public static boolean validaNome(String nome) {
		return (!nome.isEmpty());
	}
	
	public static boolean validaCP(String cp) {
		return ((cp.length() == 11 || cp.length() == 14) && 
				 cp.matches("\\d+") &&
				 !cp.isEmpty());
	}

	public static boolean validaEmail(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches() && 
        	   !email.isEmpty();
	}
	
	public static boolean validaSenha(String senha) {
		return (!senha.isEmpty());
	}
}
