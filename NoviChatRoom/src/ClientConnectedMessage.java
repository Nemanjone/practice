import java.io.Serializable;
import java.util.TreeMap;

public class ClientConnectedMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3799888862767697651L;
	
	public int newClientID;
	public TreeMap<Integer, String> nameMap;
	
	public ClientConnectedMessage(int newClientID, TreeMap<Integer, String> nameMap) {
		super();
		this.newClientID = newClientID;
		this.nameMap = nameMap;
	}
	
	
	

}
