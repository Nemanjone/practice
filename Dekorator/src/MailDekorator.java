
public class MailDekorator extends Mail {

	final private String ourDomen;
	private String additionalContent;

	public MailDekorator(String ourDomen, String additionalContent) {
		this.ourDomen = ourDomen;
		this.additionalContent = additionalContent;
	}

	public MailDekorator(String to, String content, String ourDomen, String additionalContent) {
		super(to, content);
		this.ourDomen = ourDomen;
		this.additionalContent = additionalContent;
	}

	public MailDekorator(Mail mail, String ourDomen, String additionalContent) {
		super.setTo(mail.getTo());
		super.setContent(mail.getContent());
		this.ourDomen = ourDomen;
		this.additionalContent = additionalContent;
	}

	@Override
	public void send() {
		if (!getTo().endsWith(ourDomen)) {
			setContent(getContent() + "\n\n" + additionalContent + "\nOvaj mail je namenjen samo za " + getTo());
		}
		super.send();
	}
}
