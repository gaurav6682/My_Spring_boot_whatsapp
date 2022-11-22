package Spring.Twilio.service;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class Twilioinitializer {
	
	//@SuppressWarnings("unused")
	private final Twilioproperties twilioproperties;
	
	public Twilioinitializer(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
		Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());
		System.out.println("twilio intialized with account: "+twilioproperties.getAccountSid());
	}

}
