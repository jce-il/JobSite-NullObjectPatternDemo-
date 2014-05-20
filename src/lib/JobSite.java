package lib;

import lib.Email;

public class JobSite {
	private Location location;
	private Contact contact;

	public JobSite(Location location, Contact contact) {
		this.location = location;
		this.contact = contact != null ? contact : new NullContact();
	}

	public String  getContactName(){
		return contact.name;
	}

	public String getContactPhone(){
		return contact.phone;
	}

	public void email_contact(Email email){
		contact.deliver_personalized_email(email);
	}
}