package lib;

public class NullContact extends Contact {

	public NullContact() {
		super("no name", "no phone", "no address");
	}

	public void deliver_personalized_email(Email email) {
	}
}