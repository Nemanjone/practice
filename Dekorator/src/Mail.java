
public class Mail {
	
	private String  to, content;

	public Mail(String to, String content) {
		super();
		this.to = to;
		this.content = content;
	}

	public Mail() {
		super();
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void send() {
		System.out.println("Saljem mejl...");
		System.out.println("Na adresu: " + to);
		System.out.println("Sadrzaj mejla: ");
		System.out.println(content);
		System.out.println("- - - - - - - - - - - - - - - - - - ");
	}
}
