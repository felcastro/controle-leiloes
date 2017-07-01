package business;

public class UsuarioException extends Exception {

	public UsuarioException() {
    }

    public UsuarioException(String msg) {
        super(msg);
    }

    public UsuarioException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
