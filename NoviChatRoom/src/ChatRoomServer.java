
import java.io.IOException;

public class ChatRoomServer {

	private final static int PORT = 37829;

	public static void main(String[] args) {
		try {
			new NewHub(PORT);
		}
		catch (IOException e) {
			System.out.println("Can't create listening socket.  Shutting down.");
		}
	}
}