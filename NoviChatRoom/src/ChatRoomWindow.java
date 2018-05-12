
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import javax.swing.*;


public class ChatRoomWindow extends JFrame {

	private final static int PORT = 37829; 

	public static void main(String[] args) {
		String host = JOptionPane.showInputDialog(
				"Enter the host name of the\ncomputer that hosts the chat room:");
		if (host == null || host.trim().length() == 0)
			return;
		String name = JOptionPane.showInputDialog("Enter the name that you want to use in the chat room: ");
		if (name == null || name.trim().length() == 0)
			return;
		ChatRoomWindow window = new ChatRoomWindow(host, name.trim());
		window.setLocation(200,100);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ChatClient extends Client {

		ChatClient(String host) throws IOException {
			super(host, PORT);
		}

		protected void messageReceived(Object message) {
			if (message instanceof ForwardedMessage) { 
				ForwardedMessage fm = (ForwardedMessage)message;
				String senderName = clientNameMap.get(fm.senderID);
				addToTranscript(senderName + " SAYS:  " + fm.message);
			}
			else if (message instanceof PrivateMessage) {
				PrivateMessage pm = (PrivateMessage) message;
				String senderName = clientNameMap.get(pm.senderID);
				addToTranscript("PRIVATE MESSAGE FROM " + senderName + ": " +  pm.message);
			}
			else if (message instanceof ClientConnectedMessage) {
				ClientConnectedMessage cm = (ClientConnectedMessage) message;
				addToTranscript('"' + cm.nameMap.get(cm.newClientID) + "\" HAS JOINED THE CHAT ROOM.");
				newNameMap(cm.nameMap);
			}
			
			else if (message instanceof ClientDisconnectedMessage) {
				ClientDisconnectedMessage dm = (ClientDisconnectedMessage) message;
				addToTranscript('"' + clientNameMap.get(dm.departingClientID) + "\"  HAS LEFT THE CHAT ROOM.");
				newNameMap(dm.nameMap);
			}
		}

		protected void extraHandShake(ObjectInputStream in, ObjectOutputStream out) throws IOException {
			try {
				out.writeObject(myName);
				myName = (String)in.readObject();
			}
			catch (Exception e) {
				throw new IOException("Eror while setting up the connection:" + e);
			}
		}

		protected void connectionClosedByError(String message) {
			addToTranscript("Sorry, communication has shut down due to an error:\n     " + message);
			sendButton.setEnabled(false);
			messageInput.setEnabled(false);
			messageInput.setEditable(false);
			messageInput.setText("");
			sendPrivateButton.setEnabled(false);
			privateMessageInput.setEnabled(false);
			privateMessageInput.setEditable(false);
			connected = false;
			connection = null;
		}
	} 

	private volatile String myName;
	private volatile TreeMap<Integer, String> clientNameMap = new TreeMap<Integer, String>();
	private JComboBox<String> clientList;
	private JTextField messageInput;   
	private JButton sendButton;        
	private JButton quitButton;  
	private JTextField privateMessageInput;
	private JButton sendPrivateButton;
	private JTextArea transcript;    
	private ChatClient connection;      
	private volatile boolean connected; 


	private ChatRoomWindow(final String host, String clientName) {
		super("Chat Room");
		myName = clientName;
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(2,2));
		transcript = new JTextArea(30,60);
		transcript.setLineWrap(true);
		transcript.setWrapStyleWord(true);
		transcript.setMargin(new Insets(5,5,5,5));
		transcript.setEditable(false);
		add(new JScrollPane(transcript), BorderLayout.CENTER);
		sendButton = new JButton("send");
		quitButton = new JButton("quit");
		sendPrivateButton = new JButton("send to one");
		messageInput = new JTextField(40);
		messageInput.setMargin(new Insets(3,3,3,3));
		privateMessageInput = new JTextField(40);
		privateMessageInput.setMargin(new Insets(3, 3, 3, 3));
		clientList = new JComboBox<String>();
		clientList.addItem("No one available");
		ActionHandler ah = new ActionHandler();
		sendButton.addActionListener(ah);
		quitButton.addActionListener(ah);
		messageInput.addActionListener(ah);
		privateMessageInput.addActionListener(ah);
		sendButton.setEnabled(false);
		sendPrivateButton.setEnabled(false);
		messageInput.setEditable(false);
		messageInput.setEnabled(false);
		privateMessageInput.setEditable(false);
		privateMessageInput.setEnabled(false);
		JPanel bottom = new JPanel();
		bottom.setBackground(Color.LIGHT_GRAY);
		bottom.add(new JLabel("You say:"));
		bottom.add(messageInput);
		bottom.add(sendButton);
		bottom.add(Box.createHorizontalStrut(30));
		bottom.add(quitButton);
		JPanel bottom2 = new JPanel();
		bottom2.setBackground(Color.LIGHT_GRAY);
		bottom2.add(new JLabel("Say: "));
		bottom2.add(privateMessageInput);
		bottom2.add(new JLabel(" to: "));
		bottom2.add(clientList);
		bottom2.add(sendPrivateButton);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 5, 5));
		panel.add(bottom);
		panel.add(bottom2);
		add(panel, BorderLayout.SOUTH);
		pack();
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				doQuit();
			}
		});
		new Thread() {
			public void run() {
				try {
					addToTranscript("Connecting to " + host + " ...");
					connection = new ChatClient(host);
					connected = true;
					messageInput.setEditable(true);
					messageInput.setEnabled(true);
					sendButton.setEnabled(true);
					messageInput.requestFocus();
					setTitle("Chat Room: Connected as " + myName);
				}
				catch (IOException e) {
					addToTranscript("Connection attempt failed.");
					addToTranscript("Error: " + e);
				}
			}
		}.start();
	}

	private void addToTranscript(String message) {
		transcript.append(message);
		transcript.append("\n\n");
		transcript.setCaretPosition(transcript.getDocument().getLength());
	}

	private void doQuit() {
		if (connected)
			connection.disconnect();  
		dispose();
		try {
			Thread.sleep(1000); 
		}
		catch (InterruptedException e) {
		}
		System.exit(0);
	}

	private void newNameMap(final TreeMap<Integer, String> nameMap) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				clientNameMap = nameMap;
				clientList.removeAllItems();
				boolean someoneIsThere = false;
				for ( String str : nameMap.values()) {
					if (!str.equals(myName)) {
						clientList.addItem(str);
						someoneIsThere = true;
					}
				}
				privateMessageInput.setEditable(someoneIsThere);
				privateMessageInput.setEnabled(someoneIsThere);
				sendPrivateButton.setEnabled(someoneIsThere);
				if (!someoneIsThere)
					clientList.addItem("no one available");

			}
		});
	}

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			Object src = evt.getSource();
			if (src == quitButton) { 
				doQuit();
			}
			else if (src == sendButton || src == messageInput) {
				String message = messageInput.getText();
				if (message.trim().length() == 0)
					return;
				connection.send(message);
				messageInput.selectAll();
				messageInput.requestFocus();
			}
			else if (src == sendPrivateButton || src == privateMessageInput) {
				String message = privateMessageInput.getText();
				if (message.trim().length() == 0)
					return;
				String recepient = (String)clientList.getSelectedItem();
				int recepientID = -1;
				for (int id : clientNameMap.keySet()) {
					if (recepient.equals(clientNameMap.get(id))) {
						recepientID = id;
						break;
					}
				}
				if (recepientID == -1) {
					JOptionPane.showMessageDialog(ChatRoomWindow.this, 
							"Funny... The selected recepient\ndoes not seem to exist!?");
					return;
				}
				connection.send(new PrivateMessage(recepientID, message));
				addToTranscript("Send to " + recepient + ": " + message);

			}
		}
	}   
}
