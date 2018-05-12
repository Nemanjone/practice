
import java.io.Serializable;

final class DisconnectMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1054421280894085048L;
	
	final public String message;

	public DisconnectMessage(String message) {
		this.message = message;
	}

}