import java.io.Serializable;
import java.util.TreeMap;

public class ClientDisconnectedMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8173895730669584817L;
	
	public int departingClientID;
	public String departingClientName;
	public TreeMap<Integer, String> nameMap;

	public ClientDisconnectedMessage(int departingClientID, String departingClientName,
			TreeMap<Integer, String> nameMap) {
		super();
		this.departingClientID = departingClientID;
		this.departingClientName = departingClientName;
		this.nameMap = nameMap;
	}
}
