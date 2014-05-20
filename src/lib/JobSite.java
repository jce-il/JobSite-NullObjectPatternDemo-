package lib;

import lib.Email;

public class JobSite {
	private Location location;
	private Contact contact;

	public JobSite(Location location, Contact contact) {
		this.location = location;
		this.contact = contact;
	}

	public String  getContactName(){
		if (contact != null) {
			return contact.name;
		}
		else {
			return "no name";
		}
	}

	public String getContactPhone(){
		if (contact != null) {
			return contact.phone;
		}
		else {
			return "no phone";
		}
	}

	public void email_contact(Email email){
		if (contact != null)
			contact.deliver_personalized_email(email);
	}
}