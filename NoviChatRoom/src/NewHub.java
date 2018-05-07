import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

public class NewHub extends Hub {

	private TreeMap<Integer, String> nameMap = new TreeMap<Integer, String>();

	public NewHub (int port) throws IOException{
		super(port);
	}

	protected void extraHandShake(int playerID, ObjectInputStream in,
			ObjectOutputStream out) throws IOException {

		try {
			String name = (String) in.readObject();
			if (name == null)
				name = "noname";
			if (name.length() > 15)
				name = name.substring(0, 15).trim();
			if (name.equals(""))
				name = "noname";

			synchronized (nameMap) {
				if (nameMap.containsValue(name)) {
					String approvedName = name;
					int num = 2;
					while (nameMap.containsValue(approvedName)) {
						approvedName = name + "#" + num;
						num++;
					}
					name = approvedName;
				}	
			}
			out.writeObject(name);
			nameMap.put(playerID, name);
		}
		catch (Exception e) {
			throw new IOException("Eror while setting up connection: " + e);
		}
	}

	protected void messageReceived (int playerID, Object message) {
		if (message instanceof PrivateMessage) {
			PrivateMessage pm = (PrivateMessage) message;
			pm.senderID = playerID;
			sendToOne(pm.recipientID, pm);
		}
		else
			super.messageReceived(playerID, message);
	}
	
	protected void playerConnected(int PlayerID) {
		resetOutput();
		sendToAll(new ClientConnectedMessage(PlayerID, nameMap));
	}
	
	protected void playerDisconnected(int playerID) {
		String name = nameMap.get(playerID);
		nameMap.remove(playerID);
		resetOutput();
		sendToAll(new ClientDisconnectedMessage(playerID, name, nameMap));
	}
}










