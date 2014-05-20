package spec;

import lib.Contact;
import lib.Email;
import lib.JobSite;
import lib.Location;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.jnario.lib.Assert;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@Named("When a site has a contact")
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class WhenASiteHasAContactSpec {
  Contact contact = new Function0<Contact>() {
    public Contact apply() {
      Contact _contact = new Contact("John Smith", "555-1212", "123 Main St.");
      return _contact;
    }
  }.apply();
  
  JobSite site = new Function0<JobSite>() {
    public JobSite apply() {
      Location _mock = Mockito.<Location>mock(Location.class);
      JobSite _jobSite = new JobSite(_mock, WhenASiteHasAContactSpec.this.contact);
      return _jobSite;
    }
  }.apply();
  
  @Test
  @Named("returns the contact\\\'s name")
  @Order(1)
  public void _returnsTheContactSName() throws Exception {
    String _contactName = this.site.getContactName();
    boolean _should_be = Should.<String>should_be(_contactName, "John Smith");
    Assert.assertTrue("\nExpected site.getContactName should be \'John Smith\' but"
     + "\n     site.getContactName is " + new org.hamcrest.StringDescription().appendValue(_contactName).toString()
     + "\n     site is " + new org.hamcrest.StringDescription().appendValue(this.site).toString() + "\n", _should_be);
    
  }
  
  @Test
  @Named("returns the customer\\\'s phone number")
  @Order(2)
  public void _returnsTheCustomerSPhoneNumber() throws Exception {
    String _contactPhone = this.site.getContactPhone();
    boolean _should_be = Should.<String>should_be(_contactPhone, "555-1212");
    Assert.assertTrue("\nExpected site.getContactPhone should be \'555-1212\' but"
     + "\n     site.getContactPhone is " + new org.hamcrest.StringDescription().appendValue(_contactPhone).toString()
     + "\n     site is " + new org.hamcrest.StringDescription().appendValue(this.site).toString() + "\n", _should_be);
    
  }
  
  @Test
  @Named("sends an email to the contact")
  @Order(3)
  public void _sendsAnEmailToTheContact() throws Exception {
    final Email email = Mockito.<Email>mock(Email.class);
    this.site.email_contact(email);
    Email _verify = Mockito.<Email>verify(email);
    _verify.deliver("John Smith");
  }
}
