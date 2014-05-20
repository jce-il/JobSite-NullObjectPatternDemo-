package spec

import lib.Contact
import lib.JobSite
import lib.Location
import lib.Email

import static org.mockito.Mockito.*

import static extension org.jnario.lib.Should.*


describe "When a site has a contact" {
	Contact contact = new Contact("John Smith", '555-1212', '123 Main St.')
	JobSite site = new JobSite(mock(typeof(Location)), contact)

	fact "returns the contact's name" {
      site.getContactName should be 'John Smith'
 	}
 	
	fact "returns the customer's phone number" {
      site.getContactPhone should be '555-1212'
 	}
 	
	fact 'sends an email to the contact' {
      val email = mock(typeof(Email))

      site.email_contact(email)
      
      verify(email).deliver('John Smith')
 	}
}

describe 'When a site lacks a contact' {
	JobSite site = new JobSite(mock(typeof(Location)), null) 

	fact 'returns a null name' {
      site.getContactName should be 'no name'
 	}
 	
	fact 'returns a null phone' {
      site.getContactPhone should be 'no phone'
 	}
 	
	fact 'does not email the contact' {
      val email = mock(typeof(Email))

      site.email_contact(email)
      
      verify(email, never()).deliver(any(typeof(String)))
 	}
}