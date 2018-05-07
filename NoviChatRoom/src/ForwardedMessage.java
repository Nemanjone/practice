
import java.io.Serializable;

public class ForwardedMessage implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4813941433571589084L;
	
	public final Object message;  
    public final int senderID;  

    public ForwardedMessage(int senderID, Object message) {
        this.senderID = senderID;
        this.message = message;
    }
}