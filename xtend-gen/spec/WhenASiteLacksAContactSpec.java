package spec;

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
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

@Named("When a site lacks a contact")
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class WhenASiteLacksAContactSpec {
  JobSite site = new Function0<JobSite>() {
    public JobSite apply() {
      Location _mock = Mockito.<Location>mock(Location.class);
      JobSite _jobSite = new JobSite(_mock, null);
      return _jobSite;
    }
  }.apply();
  
  @Test
  @Named("returns a null name")
  @Order(1)
  public void _returnsANullName() throws Exception {
    String _contactName = this.site.getContactName();
    boolean _should_be = Should.<String>should_be(_contactName, "no name");
    Assert.assertTrue("\nExpected site.getContactName should be \'no name\' but"
     + "\n     site.getContactName is " + new org.hamcrest.StringDescription().appendValue(_contactName).toString()
     + "\n     site is " + new org.hamcrest.StringDescription().appendValue(this.site).toString() + "\n", _should_be);
    
  }
  
  @Test
  @Named("returns a null phone")
  @Order(2)
  public void _returnsANullPhone() throws Exception {
    String _contactPhone = this.site.getContactPhone();
    boolean _should_be = Should.<String>should_be(_contactPhone, "no phone");
    Assert.assertTrue("\nExpected site.getContactPhone should be \'no phone\' but"
     + "\n     site.getContactPhone is " + new org.hamcrest.StringDescription().appendValue(_contactPhone).toString()
     + "\n     site is " + new org.hamcrest.StringDescription().appendValue(this.site).toString() + "\n", _should_be);
    
  }
  
  @Test
  @Named("does not email the contact")
  @Order(3)
  public void _doesNotEmailTheContact() throws Exception {
    final Email email = Mockito.<Email>mock(Email.class);
    this.site.email_contact(email);
    VerificationMode _never = Mockito.never();
    Email _verify = Mockito.<Email>verify(email, _never);
    String _any = Matchers.<String>any(String.class);
    _verify.deliver(_any);
  }
}
