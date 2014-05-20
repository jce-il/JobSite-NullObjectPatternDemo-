package lib;

public class Contact {
	public final String name;
	public final String phone;
	public final String address;

	public Contact(String name, String phone, String address)
	{
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public void deliver_personalized_email(Email email) {
		email.deliver(name);
	}
}